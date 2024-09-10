    public class Checksum {

        public byte[] calcularChecksum(char vet[]) {
            byte byVeto[] = new byte[vet.length+1]; 
            byte total = 0; 
            int i = 0;

            for (i = 0; i < vet.length; i++) {
                byVeto[i] = (byte) vet[i];
                total = (byte) ((total + byVeto[i]) & 0xFF);
            }
            total = (byte) ~total;
            total = (byte) ((total + (byte) 1) & 0xFF);
            System.out.println("Checksum: " + total);
            byVeto[i+1] = total;
            return byVeto;
        }
        
    }