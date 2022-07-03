public class Loader {
    private static final double PROGRESS_STEP = 0.5;
    private static final int PROGRESS_BAR_LENGTH = 10;
    private static final String PROGRESS_BAR_SYMBOL = "#";
    private static final long PAUSE_TIME_MILLIS = 200;
    private static final String PRINT_FORMAT = "Loading %c %5.2f%% (%-" + PROGRESS_BAR_LENGTH + "s)\r";

    public static void main(String[] args) {
        double progress = 0.0;
        for (int i = 0; progress <= 100; i++) {
            String progressBar = getProgressBar(progress);
            char progressIndicator = i % 2 == 0 ? '.' : '*';
            System.out.printf(PRINT_FORMAT, progressIndicator, progress, progressBar);
            progress = PROGRESS_STEP * i;
            stop();
        }
        System.out.println("\nDane wczytano pomyœlnie.");
    }

    private static String getProgressBar(double progress) {
        int numberOfHashes = (int) (progress / 10);
        return PROGRESS_BAR_SYMBOL.repeat(numberOfHashes);
    }

    private static void stop() {
        try {
            Thread.sleep(PAUSE_TIME_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}