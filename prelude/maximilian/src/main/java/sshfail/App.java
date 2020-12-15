package sshfail;

import com.espertech.esper.common.client.EPCompiled;
import com.espertech.esper.common.client.configuration.Configuration;
import com.espertech.esper.compiler.client.CompilerArguments;
import com.espertech.esper.compiler.client.EPCompileException;
import com.espertech.esper.compiler.client.EPCompiler;
import com.espertech.esper.compiler.client.EPCompilerProvider;
import com.espertech.esper.runtime.client.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
		EPCompiler compiler = EPCompilerProvider.getCompiler();

    	// add all base classes to configuration
       	Configuration configuration = new Configuration();
		configuration.getCommon().addEventType(SSHLogMessageEvent.class);
		configuration.getCommon().addEventType(SSHFailedLogMessage.class);
		configuration.getCommon().addEventType(SSHAlert.class);

    	CompilerArguments arg = new CompilerArguments(configuration);

    	// add sshlog statement and compile
    	EPCompiled sshLogCompiled;
    	try {
    		sshLogCompiled = compiler.compile("@name('sshlog-statement') select message, timestamp from SSHLogMessageEvent", arg);
    	}
    	catch (EPCompileException ex) {
    		// handle exception here
    	throw new RuntimeException(ex);
    	}

		// add sshfail statement and compile
		EPCompiled sshFailCompiled;
		try {
			sshFailCompiled = compiler.compile("@name('sshfail-statement') select message, timestamp from SSHFailedLogMessage", arg);
		}
		catch (EPCompileException ex) {
			throw new RuntimeException(ex);
		}

		// add sshalert statement and compile
		EPCompiled sshAlertCompiled;
		try {
			sshAlertCompiled = compiler.compile("@name('sshalert-statement') select message, timestamp from SSHAlert", arg);
		}
		catch (EPCompileException ex) {
			// handle exception here
			throw new RuntimeException(ex);
		}

		EPRuntime epruntime = EPRuntimeProvider.getDefaultRuntime(configuration);

		EPDeployment sshLogDeployment;
		try {
			sshLogDeployment = epruntime.getDeploymentService().deploy(sshLogCompiled);
		}
		catch (EPDeployException ex) {
			// handle exception here
			throw new RuntimeException(ex);
		}

		EPDeployment sshFailDeployment;
		try {
			sshFailDeployment = epruntime.getDeploymentService().deploy(sshFailCompiled);
		} catch (EPDeployException ex){
			throw new RuntimeException(ex);
		}

		EPDeployment sshAlertDeployment;
		try {
			sshAlertDeployment = epruntime.getDeploymentService().deploy(sshAlertCompiled);
		} catch (EPDeployException ex){
			throw new RuntimeException(ex);
		}

		// failure listener checks for count of failures
		EPStatement sshAlertStatment = epruntime.getDeploymentService().getStatement(sshAlertDeployment.getDeploymentId(), "sshalert-statement");
		sshAlertStatment.addListener( (newData, oldData, statement, runtime) -> {
			String message = (String) newData[0].get("message");
			String timestamp = (String) newData[0].get("timestamp");
			System.out.println( SatisticsManager.getInstance().ANSI_RED +"!!ALERT!!\n message: " +  message + " timestamp: " + timestamp + "\n!!ALERT!!" + SatisticsManager.getInstance().ANSI_RESET);
		});

		// failure listener checks for count of failures
		EPStatement sshFailStatment = epruntime.getDeploymentService().getStatement(sshFailDeployment.getDeploymentId(), "sshfail-statement");
		sshFailStatment.addListener( (newData, oldData, statement, runtime) -> {
			String message = (String) newData[0].get("message");
			String timestamp = (String) newData[0].get("timestamp");
			System.out.println( SatisticsManager.getInstance().ANSI_YELLOW + "ERROR!! message: " +  message + " timestamp: " + timestamp + SatisticsManager.ANSI_RESET);
			if(SatisticsManager.getInstance().cur_failed_events > SatisticsManager.getInstance().max_failed_events){
				epruntime.getEventService().sendEventBean(
						new SSHAlert(
								message,
								timestamp
						),
						"SSHAlert"
				);
			}
		});

		// log listener outputs failure events
		EPStatement sshLogStatement = epruntime.getDeploymentService().getStatement(sshLogDeployment.getDeploymentId(), "sshlog-statement");
		sshLogStatement.addListener( (newData, oldData, statement, runtime) -> {
			String message = (String) newData[0].get("message");
			String timestamp = (String) newData[0].get("timestamp");
			System.out.println(SatisticsManager.getInstance().ANSI_GREEN + "message: " +  message + " timestamp: " + timestamp + SatisticsManager.getInstance().ANSI_RESET);
			if (message.contains("Failed password") || message.contains("authentication failure") ){
				SatisticsManager.getInstance().cur_failed_events++; // increase failed events
				epruntime.getEventService().sendEventBean(
						new SSHFailedLogMessage(
								message,
								timestamp
						),
						"SSHFailedLogMessage"
				);
			}
		});

		//reading in a log file
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/max/log_pwd.systemd-json")); // terribly sorry but I have no idea where the execution binary directory is so I could put it there
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("ssh2")|| line.contains("sshd:auth")){
					String json = line;
					GenericLogObject targetObject = new Gson().fromJson(json, GenericLogObject.class);

					epruntime.getEventService().sendEventBean(
							new SSHLogMessageEvent(
									targetObject.MESSAGE,
									targetObject.SYSLOG_TIMESTAMP
							),
							"SSHLogMessageEvent"
					);
				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}



	}
}
