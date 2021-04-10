import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    public static void main(String[] args) {
        iniciarPrograma();
    }

    public static void iniciarPrograma() {
        while (true) {
            mostarMenu();
            var option = leerOpcion();
            switch (option) {
                case "b":
                    var decimal = leerNumero();
                    if (!validarNumero(decimal)) {
                        System.out.println("Numero ingresado se encuentra fuera de rango");
                        continue;
                    }
                    imprimirNumBinario8Bits(convetirBinario8Bits(decimal));
                    break;
                case "d":
                    var binario = leerNumero();
                    var arrBinario = convertirIntBinarioAArray(binario);
                    if (!validarBinario8Bits(arrBinario)) {
                        System.out.println("Error!");
                        continue;
                    }
                    imprimirNumDecimal(convertirEntero(arrBinario));
                    break;
                case "s":
                    return;
                default:
                    System.out.println("La opcion ingresada es incorrecta");
            }
        }

    } // inicializa ejecucion del programa

    public static int[] convertirIntBinarioAArray(int binario) {
        var strBinario = Integer.toString(binario).split("");
        var arrBinario = new int[strBinario.length];
        for (int i = 0; i < strBinario.length; i++) {
            arrBinario[i] = Integer.parseInt(strBinario[i]);
        }
        return arrBinario;
    } // convierte int que representa un numero binario a un arreglo con un numero por elemento

    public static String leerOpcion() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese opcion:");
        return scanner.nextLine();
    } // captura opcion de programa ingresada por el usuario

    public static void mostarMenu() {
        System.out.println("**********************************************************");
        System.out.println("*                      MENÚ                              *");
        System.out.println("*   [b] Mostrar representación binaria (de 8 bits)       *");
        System.out.println("*   [d] Mostrar representación decimal (base 10)         *");
        System.out.println("*   [s]  Salir                                           *");
        System.out.println("**********************************************************");
    } //imprime en pantalla las opciones del programa

    public static int leerNumero() {
        var scanner = new Scanner(System.in);
        System.out.println("Ingrese numero:");
        return scanner.nextInt();
    } //permite capturar el número ingresado por usuario

    public static boolean validarNumero(int numero) {
        return 0 <= numero && numero <= 255;
    } // valida que el número entero ingresado esté en el rango permitido

    public static boolean validarBinario8Bits(int[] numBin) {
        var isInRange = true;
        for (int number : numBin) {
            if (number < 0 || number > 1) {
                isInRange = false;
                return isInRange;
            }
        }
        return isInRange;
    } // valida que el número entero ingresado esté en el rango permitido

    public static int convertirEntero(int[] numBin) {
        AtomicReference<String> str = new AtomicReference<>("");
        Arrays.stream(numBin).forEach(num -> {
            str.set(str + Integer.toString(num));
        });
        var strBin = str.toString();
        return Integer.parseInt(strBin, 2);
    } // convierte el binario ingresado a su representación de número entero (base 10)

    public static int[] convetirBinario8Bits(int num) {
        var strBin = Integer.toBinaryString(num);
        var strArr = strBin.split("");
        var binaryArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            binaryArr[i] = Integer.parseInt(strArr[i]);
        }
        return binaryArr;
    } // convierte el entero (base 10) ingresado a su representación binaria de 8 bits

    public static void imprimirNumBinario8Bits(int[] numBin) {
        StringBuilder strBin = new StringBuilder(Arrays.toString(numBin).replace("[", "")
                .replace(", ", "")
                .replace("]", ""));
        if (strBin.length() < 8) {
            for (int i = 8 - strBin.length(); i > 0; i--) {
                strBin.insert(0, "0");
            }
        }
        System.out.println("el numero en binario es: " + strBin);
    } // imprime un mensaje como String, en el cual se muestra el número en su representación binaria

    public static void imprimirNumDecimal(int numero) {
        System.out.println("El numero en decimal es: " + numero);
    } // imprime un mensaje como String, en el cual se muestra el número en su representación decimalk

}