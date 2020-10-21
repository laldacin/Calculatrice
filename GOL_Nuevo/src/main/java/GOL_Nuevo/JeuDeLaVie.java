/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GOL_Nuevo;

import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucaa
 */
public class JeuDeLaVie implements Runnable {

    private int l;
//    private colorier c;
    private int l_c;
    private int l_f;
    private int c_c;
    private int c_f;

    public JeuDeLaVie(int lc, int lf, int cc, int cf) {
        l = Main.lignes - 1;
//        c = col;
        l_c = lc;
        l_f = lf;
        c_c = cc;
        c_f = cf;
    }

    public void Jouer() {
        int mat_aux[][] = new int[l_f - l_c][c_f - c_c];
        for (int i = 0; i < l_f - l_c; i++) {
            for (int j = 0; j < c_f - c_c; j++) {
                mat_aux[i][j] = 0;
            }
        }
        for (int i = 0 + l_c; i < l_f; i++) {
            for (int j = 0 + c_c; j < c_f; j++) {
                if (i == 0 || i == l) {
                    if (i == 0) {
                        if (j == 0) {
                            int cont = 0;
                            for (int m = i; m <= i + 1; m++) {
                                for (int n = j; n <= j + 1; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
//                                        System.out.println("Entra");
//                                        System.out.println("Cont antes"+cont);
                                        cont++;
//                                        System.out.println("Cont despues"+cont);
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        } else if (j == l) {
                            int cont = 0;
                            for (int m = i; m <= i + 1; m++) {
                                for (int n = j - 1; n <= j; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        } else if (j != 0 && j != l) {
                            int cont = 0;
                            for (int m = i; m <= i + 1; m++) {
                                for (int n = j - 1; n <= j + 1; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        }

                    } else if (i == l) {
                        if (j == 0) {
                            int cont = 0;
                            for (int m = i - 1; m <= i; m++) {
                                for (int n = j; n <= j + 1; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        } else if (j == l) {
                            int cont = 0;
                            for (int m = i - 1; m <= i; m++) {
                                for (int n = j - 1; n <= j; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        } else if (j != 0 && j != l) {
                            int cont = 0;
                            for (int m = i - 1; m <= i; m++) {
                                for (int n = j - 1; n <= j + 1; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        }
                    }
                } else if (j == 0 || j == l) {
                    if (i != j) {
                        if (j == 0) {
                            int cont = 0;
//                            System.out.println("Coordenada i y j: " + i + " " + j);
                            for (int m = i - 1; m <= i + 1; m++) {
                                for (int n = j; n <= j + 1; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }

                        } else if (j == l) {
                            int cont = 0;
                            for (int m = i - 1; m <= i + 1; m++) {
                                for (int n = j - 1; n <= j; n++) {
//                                    System.out.println(m + " " + n + " " + Main.status[m][n]);
                                    if ((m != i || n != j) && Main.status[m][n] == 1) {
                                        cont++;
                                    }
                                }
                            }
//                            System.out.println(cont);
                            if (cont == 3) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                                mat_aux[i - l_c][j - c_c] = 0;
                            } else if (cont == 2 && Main.status[i][j] == 1) {
                                mat_aux[i - l_c][j - c_c] = 1;
                            }
                        }
                    }
                } else if (i != 0 && i != l && j != 0 && j != l) {
                    int cont = 0;
                    for (int m = i - 1; m <= i + 1; m++) {
                        for (int n = j - 1; n <= j + 1; n++) {
//                            System.out.println(m + " " + n + " " + Main.status[m][n]);
                            if ((m != i || n != j) && Main.status[m][n] == 1) {
                                cont++;
                            }
                        }
                    }
//                    System.out.println(cont);
                    if (cont == 3) {
                        mat_aux[i - l_c][j - c_c] = 1;
                    } else if ((cont < 3 || cont > 3) && Main.status[i][j] == 0) {
                        mat_aux[i - l_c][j - c_c] = 0;
                    } else if (cont == 2 && Main.status[i][j] == 1) {
                        mat_aux[i - l_c][j - c_c] = 1;
                    }

                }
            }
        }
        Main.lock.lock();
        for (int q = 0; q < l_f - l_c; q++) {
            for (int r = 0; r < c_f - c_c; r++) {
                Main.status_aux[q + l_c][r + c_c] = mat_aux[q][r];
            }
        }
//        ecrireMat();
        try {
            Thread.sleep(10);

        } catch (InterruptedException ex) {
            Logger.getLogger(JeuDeLaVie.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
//        c.setcolor();
//        Main.nb_th++;
        Main.lock.unlock();

    }

    @Override
    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Main.lock2.lock();
        System.out.println("Entrando a comparar");
        Main.lock2.unlock();
        Jouer();
        Main.lock2.lock();
        System.out.println("Acabado de comparar");
        Main.lock2.unlock();
    }

}