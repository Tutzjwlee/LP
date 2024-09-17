package Ex2;

public class Retangulo {
    int altura;
    int base;

    public Retangulo( int base, int altura){
        this.altura = altura;
        this.base = base;
    }

    public int CalcularAre(){
        return altura*base;
    }

    public int CalcularPerimetro(){
        return 2*altura + 2*base;
    }
}
