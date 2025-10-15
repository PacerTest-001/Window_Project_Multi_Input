package WindowHandler;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button {
    public JButton button;

    public Button(JFrame window, String text, ActionListener action) {
        button = new JButton(text);
        button.addActionListener(action);
    }

    public void setFunction(ActionListener action) {
        button.addActionListener(action);
    }
}
