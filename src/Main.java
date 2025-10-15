import WindowHandler.Button;
import WindowHandler.ScreenPositions;

public class Main {
    public static int currentWindows = 0;

    public static void main(String[] args) {
        Window window = new Window();
        window.canFullScreen(false);
        window.setWindowName("Blue Collar Job");

        Window window1 = new Window(500, 500, ScreenPositions.RIGHT);
        window1.setWindowName("Thugin type shit.");

        Button button = window1.createButton("WOW", e -> {
            System.out.println("This WOW button actually works. COOL!");
        });

        while (currentWindows > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.exit(0);
    }
}
