package Ex5;

import java.util.zip.CRC32;

public class Crc {
     public static long calcularCRC32(char[] texto) {
        CRC32 crc = new CRC32();
        for (char c : texto) {
            crc.update((byte) c); 
        }
        return crc.getValue(); 
    }
}
