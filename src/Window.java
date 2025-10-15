import WindowHandler.Button;
import WindowHandler.ScreenPositions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window {
    JFrame frame;

    public Window() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main.currentWindows += 1;

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Main.currentWindows -= 1;
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setBasedLayout(ScreenPositions.CENTER);
    }

    public void test(){
        System.out.println("test");
    }

    public Window(int width, int height, ScreenPositions setScreenPos) {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(width, height);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main.currentWindows += 1;
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                Main.currentWindows -= 1;
            }
        });
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setBasedLayout(setScreenPos);
    }

    public void canFullScreen(boolean enabled) {
        frame.setResizable(enabled);
    }

    public void setWindowName(String text){
        frame.setTitle(text);
    }

    public void setBasedLayout(ScreenPositions positions) {
        int width = frame.getWidth();
        int height = frame.getHeight();

        if (positions == null) {
            positions = ScreenPositions.CENTER;
        }

        Dimension screenDimensions = Toolkit.getDefaultToolkit().getScreenSize();
        switch (positions) {
            case TOP -> {
                frame.setLocation((screenDimensions.width / 2) - (width / 2), 0);
            }
            case LEFT -> {
                frame.setLocation(0, (screenDimensions.height/2) - (height/2));
            }
            case RIGHT -> {
                frame.setLocation((screenDimensions.width) - (width), (screenDimensions.height/2) - (height/2));
            }
            case BOTTOM -> {
                frame.setLocation((screenDimensions.width / 2) - (width / 2), screenDimensions.height - height);
            }
            case CENTER -> {
                frame.setLocation((screenDimensions.width / 2) - (width / 2), (screenDimensions.height/2) - (height/2));
            }
        }
    }

    public WindowHandler.Button createButton(String text, ActionListener action) {
        WindowHandler.Button button = new Button(frame, text, action);

        return button;
    }
}
