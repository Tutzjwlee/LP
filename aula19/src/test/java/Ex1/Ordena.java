package Ex1;

public class Ordena {
    public void ordenaVetorDecrescente(int vet[]){

        int menor, maior, aux;
        for( menor = 0; menor < vet.length -1;menor++){
            for( maior = menor +1; maior < vet.length; maior ++){
                if(vet[menor]<vet[maior]){
                    aux = vet[menor];
                    vet[menor] = vet[maior];
                    vet[maior] = aux; 
                }
            }
        }
    }
}
