package Hex2IP;

public class Hex2Ip {

    public static void main(String[] args) {

        boolean Hex2Ip = args[0].toUpperCase().equals("-HEX") ? true : args[0].toUpperCase().equals("-IP") ? true : false;
        String ResultHex = "";
        boolean banderaError = false;

        if (Hex2Ip && args.length == 2) {

            switch (args[0].toUpperCase()) {
                case "-HEX":
//                    if( Integer.parseInt( args[1].substring(0,2),16 ) > 255 || Integer.parseInt( args[1].substring(2,4),16 ) > 255
//                                    || Integer.parseInt( args[1].substring(4,6),16 ) > 255 || Integer.parseInt( args[1].substring(6,8),16 ) > 255){
//
//                    }
                    try {
                        int primerParDeNumeors = Integer.parseInt(args[1].substring(0, 2), 16);
                        int segundoParDeNumeors = Integer.parseInt(args[1].substring(2, 4), 16);
                        int tercerParDeNumeors = Integer.parseInt(args[1].substring(4, 6), 16);
                        int cuartoParDeNumeors = Integer.parseInt(args[1].substring(6, 8), 16);
                        System.out.println(primerParDeNumeors + "." + segundoParDeNumeors + "." + tercerParDeNumeors + "." + cuartoParDeNumeors);
                    } catch (Exception e) {
                        System.out.println("Eror de formato!");
                    }

            break;
            case "-IP":

                for (var item : args[1].split("\\.")) {
                    if (Integer.parseInt(item) > 255)
                        banderaError = true;
                    ResultHex += Integer.toHexString(Integer.parseInt(item)).toUpperCase();
                }
                if (!banderaError)
                    System.out.println(ResultHex);
                else
                    System.out.println("Error de formato!");
                break;
        }
    } else

    {
        System.out.println("Opcion invalida");
    }
}
}
