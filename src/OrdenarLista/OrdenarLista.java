package OrdenarLista;

import java.util.*;

public class OrdenarLista {

    public static void main(String[] args) {

        int [] valores = new int[5]{};
        
        ArrayList<Integer> ListaOrdenada = new ArrayList<>();

        for (var element: args ) {
            try {
                ListaOrdenada.add( Integer.parseInt(element));
            }catch (Exception e){

            }
        }

        Collections.sort(ListaOrdenada);
    }
}
