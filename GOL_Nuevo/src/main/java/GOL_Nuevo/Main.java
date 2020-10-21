/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOL_Nuevo;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author lucaa
 */
public class Main {

    /**
     * @param args the command line arguments
     *
     */
    public static int[][] status;
    public static int[][] status_aux;
    public static int lignes;
    public static int nb_th = 9;
    public static Lock lock = new ReentrantLock();
    public static Lock lock2 = new ReentrantLock();
    public static colorier col;

    public static void main(String[] args) {
        // TODO code application logic here
        int dim_x_fen = 800;
        int dim_y_fen = 800;
        JFrame Fen = new JFrame();
        Fen.setSize(dim_x_fen, dim_y_fen);
        Fen.setTitle("GAME OF LIFE");
//        lignes = Integer.parseInt(JOptionPane.showInputDialog("Combien des cells par ligne"));
        float n_li = 36;
        lignes = Math.round(n_li / 3) * 3;
        int mat[][] = new int[lignes][lignes];
        int mat2[][] = new int[lignes][lignes];
        JLabel mat_lab[][] = new JLabel[lignes][lignes];
        status = mat;
        status_aux = mat2;
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < lignes; j++) {
                status[i][j] = 0;
                status_aux[i][j] = 0;
            }
        }

        JPanel jp = new JPanel(new GridLayout(lignes, lignes));

        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < lignes; j++) {
                mat_lab[i][j] = new JLabel("");
                mat_lab[i][j].setOpaque(true);
                mat_lab[i][j].setBackground(Color.white);
//                if(i==1){
//                    label.setBackground(Color.black);
//                }
                mat_lab[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                jp.add(mat_lab[i][j]);
            }
        }
        Fen.add(jp);
        Fen.setVisible(true);

        //Condicion inicial
//        int indices[][] = new int[4][2];
//        indices[0][0] = 5;
//        indices[0][1] = 5;
//        indices[1][0] = 5;
//        indices[1][1] = 6;
//        indices[2][0] = 5;
//        indices[2][1] = 7;
//        indices[3][0] = 6;
//        indices[3][1] = 6;
        status[5][5] = 1;
        status[5][6] = 1;
        status[6][5] = 1;
        status[6][6] = 1;
        status[5][8] = 1;
        status[6][8] = 1;
        status[6][9] = 1;
        status[6][10] = 1;
        status[7][11] = 1;
        status[8][10] = 1;
        status[8][9] = 1;
        status[8][8] = 1;
        status[9][8] = 1;
        status[10][8] = 1;
        status[11][7] = 1;
        status[10][6] = 1;
        status[9][6] = 1;
        status[8][6] = 1;
        status[8][5] = 1;

        status[30][30] = 1;
        status[31][29] = 1;
        status[32][29] = 1;
        status[33][29] = 1;
        status[33][30] = 1;
        status[33][31] = 1;
        status[33][32] = 1;
        status[32][33] = 1;
        status[30][33] = 1;

        status[30 - 20][30 - 20] = 1;
        status[31 - 20][29 - 20] = 1;
        status[32 - 20][29 - 20] = 1;
        status[33 - 20][29 - 20] = 1;
        status[33 - 20][30 - 20] = 1;
        status[33 - 20][31 - 20] = 1;
        status[33 - 20][32 - 20] = 1;
        status[32 - 20][33 - 20] = 1;
        status[30 - 20][33 - 20] = 1;

//        status[30][30 - 20] = 1;
//        status[31][29 - 20] = 1;
//        status[32][29 - 20] = 1;
//        status[33 - 20][29] = 1;
//        status[33 - 20][30] = 1;
//        status[33 - 20][31] = 1;
//        status[33 - 20][32 - 20] = 1;
//        status[32][33 - 20] = 1;
//        status[30][33 - 20] = 1;
        col = new colorier(mat_lab);
        col.setcolor();

        int contador = 0;
        while (contador < 10000000) {
            JeuDeLaVie JDLV[] = new JeuDeLaVie[9];
            Thread threads[] = new Thread[9];
            int contar = 0;
            for (int u = 0; u < 3; u++) {
                for (int v = 0; v < 3; v++) {
                    JDLV[contar] = new JeuDeLaVie(u * Main.lignes / 3, (u + 1) * Main.lignes / 3, v * Main.lignes / 3, (v + 1) * Main.lignes / 3);
                    threads[contar] = new Thread(JDLV[contar]);
                    threads[contar].start();
                    contar++;
                }
            }
            for (Thread thread : threads) {

                try {
                    thread.join();

                } catch (InterruptedException ex) {
                    Logger.getLogger(JeuDeLaVie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int p = 0; p < lignes; p++) {
                for (int q = 0; q < lignes; q++) {
                    status[p][q] = status_aux[p][q];
                }
            }
            col.setcolor();
            contador++;
        }

    }
}
