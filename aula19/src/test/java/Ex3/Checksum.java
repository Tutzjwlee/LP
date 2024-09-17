package Ex3;

public class Checksum {
    public static char calcularChecksum(char vet[]) {
        byte byVeto[] = new byte[vet.length+1]; 
        int total = 0; 
        int i = 0;

        for (i = 0; i < vet.length; i++) {
            byVeto[i] = (byte) vet[i];
           
            total = (total + byVeto[i]);
            
        }
        
        total = ((byte) ~total);
        
        total = (byte) ((total + 1) & 0xFF);

        

        byVeto[vet.length] = (byte) total;

        return (char)  byVeto[vet.length];
        
    }

}
