import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.ENGLISH);

        while(true){
            System.out.println("Welcome to agenda, please choose an option");
            System.out.println("  1. Crea un nou contacte.");
            System.out.println("  2. Busca un contacte existent.");
            System.out.println("  3. Actualitza un contacte existent.");
            System.out.println("  4. Elimina un contacte existent.");
            System.out.println("  5. Surtida.");
            int n = sc.nextInt();
            if(n == 1){
                System.out.println("Has escollit l'opció " + n);
                System.out.println("Si us plau creeu el vostre contacte ");


            } else if (n == 2) {
                System.out.println("Has escollit l'opció " + n);
            } else if (n == 3) {

            } else if (n == 4) {

            } else if (n == 5) {
                break;
            }
        }
    }
}
