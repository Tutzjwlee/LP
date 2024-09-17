package Ex3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChecksumTest {
char vet[] = new char[]{'C','a','s','a','1'};
Checksum checkSum = new Checksum();

@Test
@DisplayName("Ex3")

public void deveChecksum(){

    assertEquals('W',checkSum.calcularChecksum(vet));
}

}
