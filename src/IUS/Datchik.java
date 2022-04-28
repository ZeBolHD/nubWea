package IUS;

import java.util.Random;

public class Datchik {

    static Random random = new Random();

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {

        //Заводим датчики в постостоянный цикл

        while(true) {
            datchik1();datchik2(); datchik3();datchik4(); datchik5();
        }
    }

    //Создаём метод, в котором получаем случайное значение r в диапазоне max+a<x<min-a, производится задержка по
    //заданному периоду опроса и проверка температуры


    public static void temp(int min, int max, int a, int time){

        int r = random.nextInt(max + a - (min-a)) + min-a;

        try {
            Thread.sleep(time);
            time /= 1000;
            if (r < min) {
                System.out.println("Температура ниже нормы. Температура: " + r + "°C. Период опроса: " + time + " сек.");
            } else if (r > max) {
                System.out.println("Температура выше нормы. Температура: " + r + "°C. Период опроса: " + time + " сек.");
            } else {
                System.out.println("Всё в норме. Температура: " + r + "°C. Период опроса: " + time + " сек.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Создаём датчики и присваеваем им собственные значения

     public static void datchik1(){
        int min = 22;
        int max = 55;
        int a = 5;

        //Задаём период опроса в мc

         int time = 3000;

         //Обращаемся к методу temp

         temp(min, max, a, time);
     }

    public static void datchik2(){

        int min = 36;
        int max = 127;
        int a = 10;

        int time = 2000;

        temp(min, max, a, time);
    }

    public static void datchik3(){

        int min = 38;
        int max = 55;
        int a = 7;

        int time = 1000;

        temp(min, max, a, time);
    }

    public static void datchik4(){

        int min = 10;
        int max = 34;
        int a = 8;

        int time = 4000;

        temp(min, max, a, time);
    }
    public static void datchik5(){

        int min = 54;
        int max = 129;
        int a = 23;

        int time = 5000;

        temp(min, max, a, time);
    }

}
