
// Definindo uma interface funcional com um único método abstrato
interface Operacao
{ int executar (int a, int b);
}
public class ExemploFuncaoAnonima{ 
    public static void main(String[] args)
    {
        // Criando uma instância da interface funcional usando uma classe anônima 
        Operacao adicao = new Operacao()
    {@Override
  
        public int executar (int a, int b)
        {    return a + b;
        
        }
    };
    // Usando a função anônima
    int resultado = adicao.executar (5, 3);
    System.out.println("Resultado:" + resultado);
    }
}
