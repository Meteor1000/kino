import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Cinema extends JFrame {

    public Cinema(){
        setBackground(Color.black);
        this.getContentPane().setBackground(Color.black);
        setSize(600,645);
        setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
        show();
    }

}
