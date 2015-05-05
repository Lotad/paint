import java.awt.*;
import java.util.*;

public class Elipse extends Figura {
    protected Ponto centro;
    protected int raio1, raio2;
	
    public Elipse (int x, int y, int r1, int r2) {
        this (x, y, r1, r2, Color.BLACK, Color.WHITE);
    }
    
    public Elipse (int x, int y, int r1, int r2, Color cor) {
        this (x, y, r1, r2, cor, Color.WHITE);
    }
    
    public Elipse (int x, int y, int r1, int r2, Color cor, Color preen) {
        super (cor,preen);

        this.centro = new Ponto (x,y);

        this.raio1  = r1;
        this.raio2  = r2;
    }

    public Elipse (String s) {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x   = Integer.parseInt(quebrador.nextToken());
        int   y   = Integer.parseInt(quebrador.nextToken());

        int   r1  = Integer.parseInt(quebrador.nextToken());
        int   r2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.centro = new Ponto (x,y,cor);
        this.raio1  = r1;
        this.raio2  = r2;
        this.cor    = cor;
        //aqui vamos ter que pegar também a cor do preenchimento
    }

    public void setCentro (int x, int y) {
        this.centro = new Ponto (x,y,this.getCor());
    }

    public void setRaio1 (int r1) {
        this.raio1 = r1;
    }

    public void setRaio2 (int r2) {
        this.raio2 = r2;
    }

    public Ponto getCentro () {
        return this.centro;
    }

    public int setRaio1 () {
        return this.raio1;
    }

    public int setRaio2 () {
        return this.raio2;
    }
    
    public void torneSeVisivel (Graphics g) {
        g.setColor (this.preen);
        g.fillOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
        g.setColor (this.cor);
        g.drawOval (this.centro.getX()-raio1, this.centro.getY()-raio2, 2*raio1, 2*raio2);
    }

    public String toString() {
        return "e:" +
               this.centro.getX() +
               ":" +
               this.centro.getY() +
               ":" +
               this.raio1 +
               ":" +
               this.raio2 +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue() +
                ":" +
               this.getPreen().getRed() + //daqui pra baixo pra salvar a cor do preenchimento
                ":" +
               this.getPreen().getGreen() + //sujeito a erros lol
                ":" +
               this.getPreen().getBlue();
    }
}
