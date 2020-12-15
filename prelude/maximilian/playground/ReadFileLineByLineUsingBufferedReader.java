//https://www.journaldev.com/709/java-read-file-line-by-line

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReader {

	public static void main(String[] args) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("./log.json"));
			String line = reader.readLine();
			while (line != null) {
				if(line.contains("password")){
					System.out.println(line);
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

