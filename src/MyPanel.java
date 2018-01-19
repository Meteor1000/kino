import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MyPanel extends JPanel {
    public MyPanel(JFrame frame,MyButton[][] seats, String[][] seatsString) {
        setLayout(new FlowLayout());
        for (int i = 0 ; i< 9; i++){
            for (int j = 0 ; j< 9; j++){
                String  row=(char)('A'+i)+"";
                seats[i][j] = new MyButton(row+(j+1),frame,seatsString);
                this.add(seats[i][j]);
            }
        }
        readSeatsFromFile(seats, seatsString);
    }
    public static void readSeatsFromFile(MyButton[][] seats, String[][] seatsString) {
        String filePath = "src/matrix.txt";
        String[] rowElements;
        String line;
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            for(int i=0;i<9;i++){
                line=bufferedReader.readLine();
                if(line.length()==0){
                    line=bufferedReader.readLine();
                }
                rowElements=line.split("\\s+");
                for(int j=0;j<9;j++){
                    switch(rowElements[j]){
                        case "0":
                            seats[i][j].setBackground(Color.DARK_GRAY);
                            break;
                        case "1":
                            seats[i][j].setBackground(Color.RED);
                            break;
                    }
                    seatsString[i][j] = rowElements[j];
                }
            }
        } catch (java.io.IOException e) {

        }
    }

}
