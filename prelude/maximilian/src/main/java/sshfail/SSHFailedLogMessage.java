package sshfail;

public class SSHFailedLogMessage extends App {
    private String message;
    private String timestamp;

    public SSHFailedLogMessage(String message, String timestamp) {
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
