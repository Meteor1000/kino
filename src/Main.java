import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class Main {

    private String[][] seats;
    public static void main(String[] args) {
        String[][] seats = new String[9][9];
        MyButton[][] seatsButtons = new MyButton[9][9];
        Cinema cinema = new Cinema();
        MyPanel myPanel = new MyPanel(cinema,seatsButtons,seats);
        cinema.setJMenuBar(new Menu(seatsButtons,seats));
        cinema.setContentPane(myPanel);
        cinema.getContentPane().revalidate();
        cinema.setLayout(new FlowLayout());
        cinema.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                saveData(seats);
            }
        });

    }
    public static void saveData(String[][] seatsArray){
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("matrix.txt"));
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    pw.printf("%s ",String.valueOf(seatsArray[i][j]));
                }
                pw.println();
                pw.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
    }


}

