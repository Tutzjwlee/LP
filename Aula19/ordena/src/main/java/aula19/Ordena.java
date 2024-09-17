package ordena.src.test.java.aula19;
import ordena.src.test.java.OrdenaTest; 
public class Ordena {
    public void ordenaNumerosDecrescentes(int vetor[]){
        int menor, maior, aux;
        for(menor = 1; menor< vetor.length;menor++){
            for(maior = 0;maior<menor; maior++){
                if(vetor[menor]>vetor[maior]){
                    aux = vetor[menor];
                    vetor[menor] = vetor[maior];
                    vetor[maior] = aux;
                }
            }
        }
    }
}
