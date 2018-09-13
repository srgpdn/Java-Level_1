package java_1.lesson_3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {

    static private Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        //gameFindNumber();     // 1
        //gameFindWord();       // 2
        consoleCalculator();  // доп. задание
    }


    private static int inputRange(String msg, int min, int max) {

        int result;

        do {
            System.out.println(msg);
            result = in.nextInt();
        } while (result < min || result > max);

        return result;

    }

    // Задание 1
    private static void gameFindNumber() {

        int x;

        Random rnd = new Random();
        int number = rnd.nextInt(10);

        while (true){

            for (int i = 0; i < 3; i++) {
                x = inputRange("Угадайте число от 0 до 9", 0, 9);
                if (x < number) {
                    System.out.println("Загаданное число больше чем " + x);
                } else if ( x > number) {
                    System.out.println("Загаданное число меньше чем " + x);
                } else {
                    System.out.println("Вы угадали число");
                    break;
                }
            }

            if (inputRange("Повторить игру еще раз? 1 – да / 0 – нет", 0, 1) == 0) {
                break;
            }

        }

    }

    // Задание 2
    private static void gameFindWord() {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rnd = new Random();
        String word = words[rnd.nextInt(words.length)];
        String s;

        while (true) {
            System.out.println("Угадайте слово");
            s = in.nextLine().toLowerCase();
            if (s.equals(word)) {
                System.out.println("Вы угадали слово - " + word);
                break;
            } else {
                String outS = "";
                int len;
                if (s.length() < word.length()) {
                    len = s.length();
                } else {
                    len = word.length();
                }
                for (int i = 0; i < len ; i++) {
                    if(word.charAt(i) == s.charAt(i)) {
                       outS += word.valueOf(word.charAt(i));
                    } else {
                       outS += "#";
                    }
                }
                while (outS.length() < 15) {
                    outS += "#";
                }
                System.out.println(outS);
            }

        }
    }

    // Дополнительное задание
    private static void consoleCalculator() {

        String WRONGNUMBER = "Некорректное число - ";
        int result = 0;
        System.out.println("Введите выражение для вычисления");

            String[] line = in.nextLine().split(" ");

            if (line.length < 3 || wrongNumber(line[line.length - 1])) {
                System.out.println("Выражение некорректно");
                return;
            }

            switch (line[1]) {
                case "+":
                    for (int i = 0; i < line.length; i += 2) {
                        if (wrongNumber(line[i])) {
                            System.out.println(WRONGNUMBER + line[i]);
                            return;
                        } else {
                            result += Integer.parseInt(line[i]);
                        }

                    }
                    break;
                case "-":
                    if (wrongNumber(line[0])) {
                        System.out.println(WRONGNUMBER + line[0]);
                        return;
                    }
                    result = Integer.parseInt(line[0]);
                    for (int i = 2; i < line.length; i += 2) {
                        if (wrongNumber(line[i])) {
                            System.out.println(WRONGNUMBER + line[i]);
                            return;
                        } else {
                            result -= Integer.parseInt(line[i]);
                        }

                    }
                    break;
                case "*":
                    result = 1;
                    for (int i = 0; i < line.length; i += 2) {
                        if (wrongNumber(line[i])) {
                            System.out.println(WRONGNUMBER + line[i]);
                            return;
                        } else {
                            result *= Integer.parseInt(line[i]);
                        }

                    }
                    break;

                case "/":
                    if (wrongNumber(line[0])) {
                        System.out.println(WRONGNUMBER + line[0]);
                        return;
                    }
                    result = Integer.parseInt(line[0]);
                    for (int i = 2; i < line.length; i += 2) {
                        if (wrongNumber(line[i]) || line[i].equals("0")) {
                            if (line[i].equals("0")){
                                System.out.println("Деление на нуль");
                            } else {
                                System.out.println(WRONGNUMBER + line[i]);
                            }
                            return;
                        } else {
                            result /= Integer.parseInt(line[i]);
                        }

                    }
                    break;

                default:
                    System.out.println("Некорректный знак операции - " + line[1]);

            } // switch
            System.out.println("Результат: " + result);

        }


    private static boolean wrongNumber(String s) {
        boolean res = false;
        boolean flgZnak = false;

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            flgZnak = true;
        }

        for (int i = (flgZnak == true) ? 1 : 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                res = true;
                break;
            }

        }
        return res;
    }
}
