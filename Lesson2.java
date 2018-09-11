package java_1.lesson_2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {


        replaceZero(); // Задание 1
        fullArray();   // 2
        changeArray(); // 3
        fullMatrix();  // 4
        minAndMax();   // 5

        int[] arrc = {2, 1, 1, 2 , 1};
        System.out.println("Результат для массива " + Arrays.toString(arrc) + " " + checkBalance(arrc)); // 6

        int[] rolA = {1, 2, 3, 4, 5};
        rollArray(rolA, -1); // 7

        fullSpiral(5, 7); // Дополнительное задание
    }

    // Задание 1
    private static void replaceZero() {

        int[] mass = {0, 1, 0, 1, 1, 0, 0, 1};

        for (int i = 0; i < mass.length; i++) {
            mass[i] = (mass[i] == 0) ? 1 : 0;
        }
        System.out.println("преобразованный массив " + Arrays.toString(mass));
    }

    // Задание 2
    private static void fullArray() {

        int[] arr = new int[8];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = j;
            j += 3;
        }
        System.out.println(Arrays.toString(arr));
    }

    // Задание 3
    private static void changeArray() {

        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    // Задание 4 (В один цикл)
    private static void fullMatrix() {

        int[][] matrix = new int[5][5];
        int gl = matrix.length;
        int pl = 0;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][--gl] = 1;
            matrix[i][pl++] = 1;
            System.out.println(Arrays.toString(new String[] {Arrays.toString(matrix[i])}));
        }


    }

    // Задание 5
    private static void minAndMax() {
        int[] arr = {3, 10, 8, 9, 67, -20, 111, -50, 0, 88, 245};
        int minv = arr[0];
        int maxv = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            if (minv > arr[i]) {
                minv = arr[i];
            }
            if (maxv < arr[i]) {
                maxv = arr[i];
            }
        }
        System.out.println("Мин. знач " + minv + " Макс. значение " + maxv);
    }

    // Задание 6
    private static boolean checkBalance(int mass[]) {
        boolean result = false;
        int count = 0;
        int lcount = 0;
        int left  = mass[lcount++];
        count++;
        if (count == mass.length) {
            return result;
        }
        int right = mass[mass.length - 1];
        count++;
        int l = mass.length - 1;

        while (count < mass.length) {
            if (left <= right) {
                left += mass[lcount++];
                count++;
                continue;
            } else {
                right += mass[--l];
                count++;
                continue;
            }
        }

        if (left == right) {
            result = true;
        }

        return result;
    }

    // Задание 7
    private static void rollArray(int mass[], int n ) {

        if (n == 0 || mass.length <= 1 || Math.abs(n) == mass.length) {
            return;
        }

        if (Math.abs(n) > mass.length) {
            n = (n + mass.length) % mass.length;
            if (n == 0) {
                return;
            }
        }

        int tmp;
        if (n > 0) {

            while (n > 0) {
                int st = mass[0];

                for (int i = 0; i < mass.length ; i++) {
                    tmp = st;
                    if (i + 1 < mass.length){
                        st = mass[i + 1];
                        mass[i + 1] = tmp;
                    } else {
                        mass[0] = tmp;
                    }
                }
                n--;
            }

        } else {
            while (n < 0) {
                int st = mass[mass.length - 1];
                for (int i = mass.length - 1; i >= 0 ; i--) {
                    tmp = st;
                    if (i - 1 >= 0) {
                        st = mass[i - 1];
                        mass[i - 1] = tmp;
                    } else {
                        mass[mass.length - 1] = tmp;
                    }
                }
                n++;
            }
        }
        System.out.println(Arrays.toString(mass));
    }


    // Дополнительное задание
    private static void fullSpiral(int row, int col) {

        if (row <= 0 || col <= 0) return;




        int [][] matrix = new  int[row][col];





        int n = 1;
        int endNumber = row * col;

        if (endNumber == 1) return;

        int rowTopLeft = 0;
        int rowTopRight = col - 1;
        int rowBottomLeft = col - 1;
        int rowBottomRight = 0;
        int colLeftUp = row - 1;
        int colLeftDown = 0;
        int colRightUp = 0;
        int colRightDown = row - 1;

        int rowTop = 0;
        int rowBottom = row - 1;
        int colLeft = 0;
        int colRight = col - 1;

        while (true) {

            // верхняя строка
            for (int i = rowTopLeft; i <= rowTopRight; i++) {
                matrix[rowTop][i] = n;
                n++;
            }
            if (n >= endNumber) {
                break;
            }

            colLeftDown++;
            colRightUp++;
            rowTop++;

            // правый столбец
            for (int i = colRightUp; i <=  colRightDown; i++) {
                matrix[i][colRight] = n;
                n++;
            }
            if (n >= endNumber) {
                break;
            }

            rowTopRight--;
            rowBottomLeft--;
            colRight--;

            // нижняя строка
            for (int i = rowBottomLeft; i >= rowBottomRight ; i--) {
                matrix[rowBottom][i] = n;
                n++;
            }
            if (n >= endNumber) {
                break;
            }

            rowBottom--;
            colLeftUp--;
            colRightDown--;

            // левый столбец
            for (int i = colLeftUp; i >= colLeftDown ; i--) {
                matrix[i][colLeft] = n;
                n++;
            }
            if (n >= endNumber) {
                break;
            }

            rowTopLeft++;
            rowBottomRight++;
            colLeft++;

        }
        for (int i = 0; i < matrix.length ; i++) {
            System.out.println(Arrays.toString(new String[] {Arrays.toString(matrix[i])}));

        }

    }
}
