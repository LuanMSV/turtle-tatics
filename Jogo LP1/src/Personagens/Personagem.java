package Personagens;

import java.util.Random;

import Funcionalidades.*;

public abstract class Personagem {
  private String nome;
  private double quantVital;
  private double valorDefesa;
  private int alcance;
  private double quantAtaque;
  private int x;
  private int y;
  private int cargaEspecial;

  public Personagem(String nome, double quantVital, double valorDefesa, int alcance, double ataque) {
    this.alcance = alcance;
    this.nome = nome;
    this.quantVital = quantVital;
    this.valorDefesa = valorDefesa;
    this.quantAtaque = ataque;
    this.cargaEspecial = 0;
    this.x = this.y = -1;
  }

  public void printStatus() {
    System.out.println("========================================");
    System.out.println("Quantidade Vital: " + this.quantVital);
    System.out.println("Defesa: " + this.valorDefesa);
    System.out.println("Ataque: " + this.quantAtaque);

  }

  public void setQuantAtaque(double n) {
    this.quantAtaque = n;
  }

  public void setQuantVital(double vida) {
    if(vida<0)
    vida=0;
    this.quantVital = vida;
  }

  public void setValorDefesa(double defesa) {
    this.valorDefesa = defesa;
  }

  public void setCargaEspecial(int carga) {
    this.cargaEspecial = carga;
  }

  public int getCargaEspecial() {
    return this.cargaEspecial;
  }

  public void SetAlcance(int alcance) {
    this.alcance = alcance;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public double getQuantAtaque() {
    return this.quantAtaque;
  }

  public String getNome() {
    return this.nome;
  }

  public double getQuantVital() {
    return this.quantVital;
  }

  public double getValorDefesa() {
    return this.valorDefesa;
  }

  public int getAlcance() {
    return this.alcance;
  }

  public void atkBasico(Personagem Patacado) {
    Random gerador = new Random();
    double numReal = gerador.nextDouble() * 0.4;
    double multiAleatorio = 0.8 + numReal;

    double dano = (this.quantAtaque - Patacado.getValorDefesa()) * multiAleatorio;

    if (dano <= 0)
      dano = this.quantAtaque / 10;

    Patacado.setQuantVital(Patacado.getQuantVital() - dano);
  }

  public void atkEspecial() {

  }

  public void atkEspecial(Personagem pAtacado) {

  }

  public int atkEspecial(Jogador aliados) {
    return 0;
  }

  public void atkEspecial(Personagem pAtacado, Personagem pAliado) {

  }

  public void atkEspecial(Personagem pAtacado, ExplosaoAtomica explosao) {

  }

  public int atkEspecial(Jogador inimigos, Jogador aliados) {
    return 0;
  }
}
