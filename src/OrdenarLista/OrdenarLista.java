package OrdenarLista;
import java.util.*;

public class OrdenarLista {

    public static void main(String[] args) {
        int [] listaDeNumeros = new int[args.length];
        for (int i = 0; i<= args.length; i++){
            try {
             listaDeNumeros[i] = Integer.parseInt(args[i]);
            }catch (Exception e){
                System.out.println(e);
            }
        }
        Arrays.sort(listaDeNumeros);
        for (int elementSorted: listaDeNumeros) {
            System.out.println(elementSorted);
        }
    }
}
