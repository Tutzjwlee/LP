import java.util.Random;

public class SimpleThreadExample {
    // Geração de um bilhão de números aleatórios...
    private static final long TOTAL_NUMEROS = 1_000_000_000L;

    public static void main(String[] args) {
        final int threads = 1; // Criar apenas 1 Thread
        System.out.println("Missao: Gerar um bilhao de numeros aleatorios!");
        System.out.printf("- Criando %d Thread(s) para isso!\n", threads);

        // Inicia a execução da thread principal
        new SimpleThreadExample().run(); // Executa a lógica sequencialmente
    }

    public void run() {
        System.out.println("- Iniciando Thread Principal...");

        // Lê o tempo do sistema no início do processamento
        final double startTime = System.currentTimeMillis();

        // Sorteia um número (aleatório)
        Random rand = new Random();

        // Eleva à 10ª potência cada número para o processamento mais complexo
        for (int i = 0; i < TOTAL_NUMEROS; i++) {
            Math.pow(rand.nextDouble(), 10);
        }

        // Tempo de processamento em segundos
        final double totalSecs = (System.currentTimeMillis() - startTime) / 1000.0;
        System.out.println("- Encerrando o processamento...");
        System.out.printf("Missao cumprida em %.2f segundos!\n", totalSecs);
    }
}
