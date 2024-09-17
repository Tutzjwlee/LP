package Ex5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrcTest {
char vet[] = new char[]{'C','a','s','a','1'};
Crc crc = new Crc();

@Test
@DisplayName("Ex5:")

public void deveCrc(){
    assertEquals(560253239, crc.calcularCRC32(vet));
}
}
