public class testChecksum {
    public static byte[] calcularChecksum(char vet[]) {
        byte byVeto[] = new byte[vet.length+1]; 
        int total = 0; 
        int i = 0;

        for (i = 0; i < vet.length; i++) {
            byVeto[i] = (byte) vet[i];
            System.out.println(Integer.toBinaryString(byVeto[i]));
            total = (total + byVeto[i]);
            System.out.println("total local: " +Integer.toBinaryString(total));
        }
        System.out.println("total: " +Integer.toBinaryString(total));
        total = ((byte) ~total);
        System.out.println("total + 1: " +Integer.toBinaryString(total));
        total = (byte) ((total + 1) & 0xFF);

        System.out.println("Checksum: " + Integer.toBinaryString(total));

        byVeto[vet.length] = (byte) total;

        return byVeto;
    }
    public static void main(String[] args) {
        char vet[] = {'A','B','C'};
        
        System.out.println(calcularChecksum(vet));
    }
}
