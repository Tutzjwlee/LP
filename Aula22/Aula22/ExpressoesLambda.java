import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressoesLambda {


/* Usando uma expressão lambda para criar uma função que adiciona dois números inteiros */
    @FunctionalInterface
    interface Operacao {
        int executar(int a, int b);
    }


    public static void main(String[] args) {
        // Usando uma expressão lambda para criar uma função que adiciona dois números inteiros
        Operacao soma = (a, b) -> a + b;

        int resultado = soma.executar(5, 3); // resultado é 8
        System.out.println("Resultado: " + resultado);
     //---------------------------------------------------------------------------------------------------------------------------------//
        
        // Usando uma expressão lambda para criar um comparador de Strings
        Comparator<String> comparador = (String s1,String s2) -> s1.compareTo(s2);
        
        // Comparar duas strings
        int resultadoComparacao2 = comparador.compare("maçã", "banana");
        System.out.println("Resultado da comparação: " + resultadoComparacao2);
        

        //---------------------------------------------------------------------------------------------------------------------------------//

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtrar os números pares usando stream e coletar em uma nova lista
        List<Integer> pares = numeros.stream()
                                    .filter(n -> n % 2 == 0) // Filtra os números pares
                                    .collect(Collectors.toList()); // Coleta os resultados em uma lista

        // Exibir a lista de números pares
        System.out.println("Números pares: " + pares);


    }
}

