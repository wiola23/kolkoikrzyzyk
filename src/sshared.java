import javax.swing.*;

public class sshared {
    public static JFrame okno = new JFrame("OX");
    public static bboard board = new bboard();
    //public static int[] plansza = new int[9];

    public static void start() {
        okno.setBounds(100, 100, 300+14, 300+37);
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        okno.add(board);

        okno.setVisible(true);
    }
}
