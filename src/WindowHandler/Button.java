package WindowHandler;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button {
    public JButton interactable;

    public Button(JFrame window, String text, ActionListener action) {
        interactable = new JButton(text);
        interactable.addActionListener(action);
        window.add(interactable);
    }

    public Button(JFrame window) {
        interactable = new JButton("-Not enough Info Provided-");
        window.add(interactable);
    }

    public void setFunction(ActionListener action) {
        interactable.addActionListener(action);
    }
}
