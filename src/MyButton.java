import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyButton extends JButton{
    public MyButton(String text, JFrame frame, String[][] seats){
        super(text);
        setBackground(Color.DARK_GRAY);
        setForeground(Color.WHITE);
        setPreferredSize(new Dimension(60,60));
        addActionListener((ActionEvent event) -> {
            int i = this.getText().charAt(0)-65;
            int j = this.getText().charAt(1)-49;
            Object[] options = {"Zarezerwuj",
                    "Zwolnij",
                    "Anuluj"};
            int choice = JOptionPane.showOptionDialog(frame,
                    "Czy chcesz zarezerwować miejsce " + this.getText()+" na seans?",
                    "Rezerwacja",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[2]);
            switch (choice){
                case 0:
                    setBackground(Color.RED);
                    seats[i][j]="1";
                    break;
                case 1:
                    setBackground(Color.DARK_GRAY);
                    seats[i][j]="0";
                    break;
            }
        });
    }
}
