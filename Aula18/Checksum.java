public class Checksum {

    public void calcularChecksum(char vet[]) {
        byte byVeto[] = new byte[vet.length]; 
        byte total = 0; 

        for (int i = 0; i < vet.length; i++) {
            byVeto[i] = (byte) vet[i];
            total = (byte) (total + byVeto[i]); 
        }

        System.out.println("Checksum: " + total);
    }
}