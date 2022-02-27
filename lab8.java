import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lab8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String calculate = scanner.nextLine();
        Pattern p = Pattern.compile("^(-?\\d{0,10})/(-?\\d{1,10})( )[+*:-]( )(-?\\d{0,10})/(-?\\d{1,10})$");
        Matcher m = p.matcher(calculate);
        if (m.matches()) {
            String[] part = calculate.split("[/( )]+");
            int numerator1 = Integer.parseInt(part[0]);
            int denominator1 = Integer.parseInt(part[1]);
            String operation = part[2];
            int numerator2 = Integer.parseInt(part[3]);
            int denominator2 = Integer.parseInt(part[4]);

            Fractions fraction1 = new Fractions(numerator1, denominator1);
            Fractions fraction2 = new Fractions(numerator2, denominator2);
            
            if (operation.equals("+")) {
                System.out.println(Fractions.sum(fraction1, fraction2));
            }
            if (operation.equals("-")) {
                System.out.println(Fractions.subtract(fraction1, fraction2));
            }
            if (operation.equals("*")) {
                System.out.println(Fractions.multiply(fraction1, fraction2));
            }
            if (operation.equals(":")) {
                System.out.println(Fractions.division(fraction1, fraction2));
            }
        } else {
            System.out.println("Ошибка! Введите выражение заново.");
        }
    }
}