import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class Menu extends JMenuBar {

    public Menu(MyButton[][] buttons, String[][] seatsString) {
        JMenu menu = new JMenu("Menu");
        JMenu about= new JMenu("O autorze");
        about.setMnemonic(KeyEvent.VK_A);
        menu.setMnemonic(KeyEvent.VK_M);
        JMenuItem menuItemFree = new JMenuItem("Zwolnij wszystkie miejsca");
        JMenuItem menuItemReserve = new JMenuItem("Zajmij wszystkie miejsca");
        JMenuItem menuItemExit = new JMenuItem("Wyjdź");
        JMenuItem menuItemDesighner = new JMenuItem("Twórcy aplikacji");
        menuItemExit.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        menuItemFree.addActionListener((ActionEvent event) -> {
            for(int i=0; i<9 ; i++){
                for(int j=0; j<9; j++){
                    buttons[i][j].setBackground(Color.DARK_GRAY);
                    seatsString[i][j]="0";
                }
            }
        });
        menuItemReserve.addActionListener((ActionEvent event) -> {
            for(int i=0; i<9 ; i++){
                for(int j=0; j<9; j++){
                    buttons[i][j].setBackground(Color.RED);
                    seatsString[i][j]="1";
                }
            }
        });
        menuItemDesighner.addActionListener((ActionEvent event) -> {
           JOptionPane.showMessageDialog(null, "Laboratorium programowania: technologie internetowe \n" +
                   "Wykonali: Mariusz Karasek & Paweł Ławnik\n" +
                   "Informatyka KUL 01.2018", "Informacje o autorach", JOptionPane.INFORMATION_MESSAGE);
        });

        menu.add(menuItemFree);
        menu.add(menuItemReserve);
        menu.add(menuItemExit);
        about.add(menuItemDesighner);
        add(menu);
        add(about);
    }
}