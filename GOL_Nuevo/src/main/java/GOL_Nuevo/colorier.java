/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOL_Nuevo;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author lucaa
 */
public class colorier {

    private JLabel mat_lab[][] = new JLabel[Main.lignes][Main.lignes];
    private int lignes;

    public colorier(JLabel m_l[][]) {
        mat_lab = m_l;
        lignes = Main.lignes;
    }

    public void setcolor() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < lignes; j++) {
                if (Main.status[i][j]==1) {
                    mat_lab[i][j].setBackground(Color.black);
                }else{
                    mat_lab[i][j].setBackground(Color.white);
                }
            }
        }
    }
}
