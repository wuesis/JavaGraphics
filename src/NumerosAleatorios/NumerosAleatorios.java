package NumerosAleatorios;

import java.util.Random;

public class NumerosAleatorios {

    public static void main(String[] args) {

        Random random = new Random();
        int FirstValue = random.nextInt(10-1)+1;
        int SecondValue = random.nextInt(10-1)+1;

        System.out.println("Numero uno: " + FirstValue+ "\nSegundo valor: "+ SecondValue);

        String Resultado =  FirstValue > SecondValue ? "El primer numero es mayor" :  FirstValue < SecondValue ? "El segundo es mayor": "Son iguales";
        System.out.println(Resultado);

    }
}
