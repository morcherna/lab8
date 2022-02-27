public class Fractions {
    private int denominator;
    private int numerator;

    public Fractions(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fractions() {
        this.numerator = 1;
        this.denominator = 1;
    }

    public static int EuclideanAlgorithm(int a, int b) {
        while (b != 0) {
            int с = a % b;
            a = b;
            b = с;
        }
        return a;
    }

    public static int LeastMultiple(int a, int b) {
        return a * b / EuclideanAlgorithm(a, b);
    }

    public static Fractions sum(Fractions fraction1, Fractions fraction2) {
        int denominator = LeastMultiple(fraction1.denominator, fraction2.denominator);
        int numerator = fraction1.numerator * (denominator / fraction1.denominator) + fraction2.numerator * (denominator / fraction2.denominator);
        int largestMultiple = EuclideanAlgorithm(denominator, numerator);
        denominator = denominator / largestMultiple;
        numerator = numerator / largestMultiple;
        Fractions result = new Fractions(numerator, denominator);
        return result;
    }

    public Fractions sum2(Fractions fraction) {
        Fractions result = new Fractions();
        result.numerator = (this.numerator * fraction.denominator) + (fraction.numerator * this.denominator);
        result.denominator = this.denominator * fraction.denominator;
        return result;
    }

    public static Fractions subtract(Fractions fraction1, Fractions fraction2) {
        int denominator = LeastMultiple(fraction1.denominator, fraction2.denominator);
        int numerator = fraction1.numerator * (denominator / fraction1.denominator) - fraction2.numerator * (denominator / fraction2.denominator);
        int largestMultiple = EuclideanAlgorithm(denominator, numerator);
        denominator = denominator / largestMultiple;
        numerator = numerator / largestMultiple;
        Fractions result = new Fractions(numerator, denominator);
        return result;
    }

    public Fractions subtract2(Fractions fraction) {
        Fractions result = new Fractions();
        result.numerator = (this.numerator * fraction.denominator) - (fraction.numerator * this.denominator);
        result.denominator = this.denominator * fraction.denominator;
        return result;
    }

    public static Fractions multiply(Fractions fraction1, Fractions fraction2) {
        int denominator = fraction1.denominator * fraction2.denominator;
        int numerator = fraction1.numerator * fraction2.numerator;
        int largestMultiple = EuclideanAlgorithm(denominator, numerator);
        denominator = denominator / largestMultiple;
        numerator = numerator / largestMultiple;
        Fractions result = new Fractions(numerator, denominator);
        return result;
    }

    public Fractions multiply2(Fractions fraction) {
        Fractions result = new Fractions();
        result.numerator = fraction.numerator * fraction.numerator;
        result.denominator = this.denominator * fraction.denominator;
        return result;
    }

    public static Fractions division(Fractions fraction1, Fractions fraction2) {
        int denominator = fraction1.denominator * fraction2.numerator;
        int numerator = fraction1.numerator * fraction2.denominator;
        int largestMultiple = EuclideanAlgorithm(denominator, numerator);
        denominator = denominator / largestMultiple;
        numerator = numerator / largestMultiple;
        Fractions result = new Fractions(numerator, denominator);
        return result;
    }

    public Fractions division2(Fractions fraction) {
        Fractions result = new Fractions();
        result.numerator = fraction.denominator * this.numerator;
        result.denominator = this.denominator * fraction.numerator;
        return result;
    }

    public String toString() {
        return numerator + "/" + denominator + "\n" + "числитель = " + numerator + ", знаменатель = " + denominator;
    }
}