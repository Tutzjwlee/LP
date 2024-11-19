// Definindo uma interface funcional com um único método abstrato 
interface Operacao 
{   int executar(int a, int b);
}

public class ExemploFuncaoAnonima2 {
    public static void main(String[] args) {
        // Usando uma expressão lambda para criar uma função anônima 
        Operacao adicao = (a, b) -> a + b;

        // Usando a função anônima
        int resultado = adicao.executar(5, 3); // resultado é 8 
        System.out.println("Resultado: " + resultado);
    }
}
