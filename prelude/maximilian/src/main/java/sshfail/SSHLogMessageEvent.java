package sshfail;

public class SSHLogMessageEvent extends App {
	private String message;
	private String timestamp;

	public SSHLogMessageEvent(String message, String timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getTimestamp() {
		return timestamp;
	}
}
