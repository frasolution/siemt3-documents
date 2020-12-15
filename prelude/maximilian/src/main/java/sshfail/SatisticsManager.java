package sshfail;

public class SatisticsManager {
    private static SatisticsManager instance;
    public int max_failed_events = 2; // everything above 2 is an alert
    public int cur_failed_events = 0;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public SatisticsManager(){
    }

    public static SatisticsManager getInstance(){
        if (SatisticsManager.instance == null) {
            SatisticsManager.instance = new SatisticsManager();
        }
        return instance;
    }
}
