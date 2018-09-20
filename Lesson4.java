package java_1.lesson_4;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    // размер поля
    static final int SIZE = 5;
    // кол фишек для победы
    static final int SIZE_WIN =4;
    //массив полей
    static final char[][] map =  new char [SIZE][SIZE];

    static final char player_DOT= 'X';
    static final char Ai_DOT= 'O';
    static final char EMPTY_DOT= '.'

    static Scanner scr = new Scanner(System.in);
    static Random rnd = new Random();

    public static void main(String[] args) {
        emtpyMap();
        printMap();
        do {
            playerMove();
            System.out.println("Ваш ход на поле");
            printMap();
            if (checkWin(player_DOT)) {
                System.out.println("Вы выиграли");
                break;
            } else if (fullField()) break;
            AiMove();
            System.out.println("Ход Компа на поле");
            printMap();
            if (checkWin(Ai_DOT)) {
                System.out.println("Выиграли Комп");
                break;
            } else if (fullField()) break;
        } while (true);
        System.out.println("!Конец игры!");
    }


    // инициализация
    private static void emtpyMap () {

        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    //печать поля
    private static void printMap ()     {
        printMapLine ();
        for (int i=0; i<SIZE; i++) {
            System.out.print("|");
            for (int j=0; j<SIZE; j++) {
                System.out.print(map[i][j]+"|");
            }
            System.out.println("");
        }
        printMapLine();
    }

    //линия для поля
    private static void printMapLine () {
        for (int i =0; i<map.length*2+1; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    //запись хода игрока на поле
    private static void dotMap (int y, int x, char dot) {
        map [y][x] = dot;
    }


    //Ход человева
    private static void playerMove () {
        int x, y;
        do {
            System.out.println("Введите координаты вашего хода в диапозоне от 1 до " + SIZE_Y);
            System.out.print ("Координат по строке ");
            y = scr.nextInt()-1;
            System.out.print ("Координат по столбцу ");
            x = scr.nextInt()-1;

        } while (!checkMove(y,x));
        dotMap(y, x, player_DOT);
    }

    //Ход компьютера
    private static void AiMove () {
        int x, y;
        //блокировка ходов человека
        for (int v = 0; v<SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                //анализ наличие поля для проверки
                if (h+SIZE_WIN<=SIZE) {                           //по горизонтале
                    if (checkLineHorisont(v, h, player_DOT) == SIZE_WIN - 1) {
                        if (MoveAiLineHorisont(v, h, Ai_DOT)) return;
                    }

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, player_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaUp(v, h, Ai_DOT)) return;
                        }
                    }
                    if (v + SIZE_WIN <= SIZE) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, player_DOT) == SIZE_WIN - 1) {
                            if (MoveAiDiaDown(v, h, Ai_DOT)) return;
                        }
                    }
                }
                if (v+SIZE_WIN<=SIZE) {                       //по вертикале
                    if (checkLineVertical(v,h,player_DOT) ==SIZE_WIN-1) {
                        if(MoveAiLineVertical(v,h,Ai_DOT)) return;
                    }
                }
            }
        }
        //игра на победу
        for (int v = 0; v<SIZE; v++) {
            for (int h = 0; h < SIZE; h++) {
                //анализ наличие поля для проверки
                if (h+SIZE_WIN<=SIZE) {                           //по горизонтале
                    if (checkLineHorisont(v,h,Ai_DOT) == SIZE_WIN-1) {
                        if (MoveAiLineHorisont(v,h,Ai_DOT)) return;
                    }

                    if (v-SIZE_WIN>-2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, Ai_DOT) == SIZE_WIN-1) {
                            if (MoveAiDiaUp(v,h,Ai_DOT)) return;
                        }
                    }
                    if (v+SIZE_WIN<=SIZE) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, Ai_DOT) == SIZE_WIN-1) {
                            if (MoveAiDiaDown(v,h,Ai_DOT)) return;
                        }
                    }

                }
                if (v+SIZE_WIN<=SIZE) {                       //по вертикале
                    if (checkLineVertical(v,h,Ai_DOT) ==SIZE_WIN-1) {
                        if(MoveAiLineVertical(v,h,Ai_DOT)) return;
                    }
                }
            }
        }

        //случайный ход
        do {
            y = rnd.nextInt(SIZE);
            x = rnd.nextInt(SIZE);
        } while (!checkMove(y,x));
        dotMap(y, x, Ai_DOT);
    }

    //ход компьютера по горизонтале
    private static boolean MoveAiLineHorisont(int v, int h, char dot) {
        for (int j = h; j < SIZE_WIN; j++) {
            if ((map[v][j] == EMPTY_DOT)) {
                map[v][j] = dot;
                return true;
            }
        }
        return false;
    }
    //ход компьютера по вертикале
    private static boolean MoveAiLineVertical(int v, int h, char dot) {
        for (int i = v; i<SIZE_WIN; i++) {
            if ((map[i][h] == EMPTY_DOT)) {
                map[i][h] = dot;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения всей линии по диагонале вверх

    private static boolean MoveAiDiaUp(int v, int h, char dot) {
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((map[v+i][h+j] == EMPTY_DOT)) {
                map[v+i][h+j] = dot;
                return true;
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонале вниз

    private static boolean MoveAiDiaDown(int v, int h, char dot) {

        for (int i = 0; i < SIZE_WIN; i++) {
            if ((map[i+v][i+h] == EMPTY_DOT)) {
                map[i+v][i+h] = dot;
                return true;
            }
        }
        return false;
    }
    //проверка заполнения выбранного для хода игроком
    private static boolean checkMove(int y, int x) {
        if (x<0 || x >=SIZE || y<0 || y>=SIZE) return false;
        else if (!(map[y][x]==EMPTY_DOT)) return false;

        return true;
    }
    //проверка на ничью (все  ячейки поля заполнены ходами)
    private  static boolean fullField() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) return false;
            }
        }
        System.out.println("Игра закончилась в ничью");
        return true;
    }

    //проверка победы
    private static boolean checkWin(char dot) {
        for (int v = 0; v<SIZE; v++){
            for (int h= 0; h<SIZE; h++) {
                //анализ наличие поля для проверки
                if (h + SIZE_WIN <= SIZE) {                           //по горизонтале
                    if (checkLineHorisont(v, h, dot) >= SIZE_WIN) return true;

                    if (v - SIZE_WIN > -2) {                            //вверх по диагонале
                        if (checkDiaUp(v, h, dot) >= SIZE_WIN) return true;
                    }
                    if (v + SIZE_WIN <= SIZE) {                       //вниз по диагонале
                        if (checkDiaDown(v, h, dot) >= SIZE_WIN) return true;
                    }
                }
                if (v + SIZE_WIN <= SIZE) {                       //по вертикале
                    if (checkLineVertical(v, h, dot) >= SIZE_WIN) return true;
                }
            }
        }
        return false;
    }

    //проверка заполнения всей линии по диагонале вверх

    private static int checkDiaUp(int v, int h, char dot) {
        int count=0;
        for (int i = 0, j = 0; j < SIZE_WIN; i--, j++) {
            if ((map[v+i][h+j] == dot)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по диагонале вниз

    private static int checkDiaDown(int v, int h, char dot) {
        int count=0;
        for (int i = 0; i < SIZE_WIN; i++) {
            if ((map[i+v][i+h] == dot)) count++;
        }
        return count;
    }

    private static int checkLineHorisont(int v, int h, char dot) {
        int count=0;
        for (int j = h; j < SIZE_WIN + h; j++) {
            if ((map[v][j] == dot)) count++;
        }
        return count;
    }
    //проверка заполнения всей линии по вертикале
    private static int checkLineVertical(int v, int h, char dot) {
        int count=0;
        for (int i = v; i< SIZE_WIN + v; i++) {
            if ((map[i][h] == dot)) count++;
        }
        return count;
    }



}