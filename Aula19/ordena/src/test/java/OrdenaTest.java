package ordena.src.test.java;
import  ordena.src.test.java.aula19;

public class OrdenaTest {
    public OrdenaTest()
    {
        int proposto [] = new int[]{10,9};
        int esperado [] = new int[]{9,10};
        int inesperado [] = new int[]{9};
        
        Ordena test = new Ordena();
        test.ordenaNumerosDecrescentes(proposto);

    }


    
    // public boolean caso1Test(int tamprop, int tamesp){
    //     boolean resp = true;
    //     if(tamprop != tamesp) resp = false;
    //     return resp;     
    // }
    // public boolean caso2Test(int prop[], int esp[]){
    //     return NumerosIguais(esp, prop);
    // }
    //     public boolean NumerosIguais(int nums1[], int nums2[]){
    //         boolean resp = true;
    //         int j = 0 ;
    //         if(nums1.length != nums2.length) resp = false;
    //         for(int i = 0; i < nums1.length ;i++){
    //             j++;
    //             if(nums1[j]!=nums2[j]){
    //                 resp = false;
    //                 break;
    //             }
    //         }
    //         return resp;
    //     }   
    
}
