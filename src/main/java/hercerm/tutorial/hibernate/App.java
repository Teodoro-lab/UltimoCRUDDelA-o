package hercerm.tutorial.hibernate;

import hercerm.tutorial.hibernate.view.NewJFrame;

public class App {

    public static void main(String[] args) {
        NewJFrame frame = new NewJFrame();
        frame.setSize(750, 500);
        frame.setVisible(true);
        frame.fillTable();
    }
}