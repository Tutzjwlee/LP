package Ex2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetanguloTest {
  
    Retangulo retangulo = new Retangulo(2, 2);

    @Test
    @DisplayName("Ex2: ")
     public void deveRetangulo(){
        assertEquals(4,retangulo.CalcularAre());
        assertEquals(8, retangulo.CalcularPerimetro());
     }
}
