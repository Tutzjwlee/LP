package Ex1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdenaTest {

   
        int resp[]=new int[]{10,9,8};
        int proposto[] = new int[]{9,8,10};
        Ordena test = new Ordena();

        @Test
        @DisplayName("Ordena: ")

         public void deveOrdenar(){
            test.ordenaVetorDecrescente(proposto);
            for(int i = 0; i < resp.length;i++){
                assertEquals(resp[i],proposto[i]);
            }
         }
    
}
