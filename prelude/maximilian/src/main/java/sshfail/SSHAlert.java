package sshfail;

public class SSHAlert extends App{
    private String message;
    private String timestamp;

    public SSHAlert(String message, String timestamp) {
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
