package java_1.lesson_1;


public class Lesson1 {

    public static void main(String[] args) {

        int n = 127000;
        byte bt = 23;
        short sh = 1050;
        long lg = 500456L;
        float fl = 345.23f;
        double db = 57896.11;
        char ch = 'G';
        boolean bl = true;
        String st = "One program";

        System.out.println("Результат " + calculateValue(5, 10, 20, 4));

        System.out.println("Результат " + testDiapazone(5,10));
        System.out.println("Результат " + testDiapazone(20,10));

        testNumber(10);
        testNumber(-10);

        System.out.println("Результат " + testNegative(-50));
        System.out.println("Результат " + testNegative(50));

        welcome("Serg");

        leapYear(2018);
        leapYear(2000);



    }

    private static int calculateValue(int a, int b, int c, int d) {
        return a * (b + c / d);
    }

    private static boolean testDiapazone(int a, int b) {

        if ((a + b >= 10) && (a + b <= 20)) {
            return true;
        } else {
            return false;
        }

    }

    private static void testNumber(int a) {

        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    private static boolean testNegative(int a) {

        if (a < 0) {
            return true;
        }
        return false;
    }

    private static void welcome(String s) {
        System.out.println("Привет " + s);
    }

    private static void leapYear(int year) {

        if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
            System.out.println("Год " + year + " высокосный");
        } else {
            System.out.println("Год " + year + " невысокосный");
        }
    }


}
