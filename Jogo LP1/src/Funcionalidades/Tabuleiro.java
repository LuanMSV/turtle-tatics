package Funcionalidades;

import Personagens.Personagem;

public class Tabuleiro {
  private String[][] mapa = new String[255][255];
  private int sizex;
  private int sizey;

  public Tabuleiro(int newx, int newy) {
    int x = 0, y = 0;

    this.sizex = newx;
    this.sizey = newy;
    for (x = 0; x < sizex; x++) {
      for (y = 0; y < sizey; y++) {
        mapa[x][y] = " ";
        if (x == 0 || x == newx - 1 || y == 0 || y == newy - 1) {
          mapa[x][y] = "X";
        }
      }
    }

    if (this.sizex == 10) {
      int i;
      for (i = 0; i < 6; i++) {
        mapa[i + 2][3] = "X";
        mapa[i + 2][6] = "X";
      }

    } else if (this.sizex == 12) {
      int i, j;
      for (i = 0; i < 12; i++) {
        mapa[5][i] = "X";
        mapa[6][i] = "X";
        mapa[i][6] = "X";
        mapa[i][5] = "X";
      }
      for (i = 4; i < 8; i++) {
        for (j = 4; j < 8; j++) {
          mapa[i][j] = " ";
        }
      }
    }

  }

  public int getSizeX() {
    return sizex;
  }

  public int getSizeY() {
    return sizey;
  }

  public String[][] getMapa() {
    return mapa;
  }

  public String getPosMapa(int x, int y) {
    return this.mapa[x][y];
  }

  public void setPosMapa(int x, int y, String novoVal) {
    this.mapa[x][y] = novoVal;
  }

  public void removerDoTabuleiro(Personagem p) {
    this.setPosMapa(p.getX(), p.getY(), " ");
  }

  public void printMapa(Jogador j1, Jogador j2) {
    int x = 0, y = 0;

    for (Personagem p : j1.getPersonagens()) {
      if (p.getX() != -1) {
        this.mapa[p.getX()][p.getY()] = p.getNome().substring(0, 1);
      }
    }
    for (Personagem p : j2.getPersonagens()) {
      if (p.getX() != -1) {
        this.mapa[p.getX()][p.getY()] = p.getNome().substring(0, 1);
      }
    }

    System.out.printf("\n");
    for (x = 0; x < sizex; x++) {
      for (y = 0; y < sizey; y++) {
        System.out.printf(this.mapa[x][y]);
      }
      System.out.printf("\n");
    }
  }

  public String toString() {
    String status = "";
    int x, y;
    for (y = 0; y < sizey; y++) {
      for (x = 0; x < sizex; x++) {
        status += mapa[y][x];
      }
      status += "\n";
    }
    return status;
  }
}
