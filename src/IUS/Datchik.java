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

    //Создаём метод, чтобы сверить температуру

    public static void temp(int min, int max, int r, int time){
        time /= 1000;
        if(r<min) {
            System.out.println("Темпетура ниже нормы. Температура: " + r + "°C. Период опроса: " + time + "сек.");
        }else if(r>max){
            System.out.println("Темпетаруа выше нормы. Температура: " + r + "°C. Период опроса: " + time + "сек.");
        } else {
            System.out.println("Всё в норме. Температура: " + r + "°C. Период опроса: " + time + "сек.");
        }
    }

    //Создаём датчики и присваеваем им собственные значения

     public static void datchik1(){

        int min = 22;
        int max = 55;
        int a = 5;

         //Задаём период опроса в мс

         int time = 3000;

         //Получаем случайное число в диапозоне: min-a<x<max+a

        int r = random.nextInt(max + a - (min-a)) + min-a;
        try {

            Thread.sleep(time);

            //Обращаемся к методу temp

            temp(min, max, r, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }

    public static void datchik2(){

        int min = 36;
        int max = 127;
        int a = 10;
        int r = random.nextInt(max + a - (min-a)) + min-a;

        int time = 2000;

        try {
            Thread.sleep(time);

            temp(min, max, r, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void datchik3(){

        int min = 38;
        int max = 55;
        int a = 7;
        int r = random.nextInt(max + a - (min-a)) + min-a;

        int time = 1000;

        try {
            Thread.sleep(time);

            temp(min, max, r, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void datchik4(){

        int min = 10;
        int max = 34;
        int a = 8;
        int r = random.nextInt(max + a - (min-a)) + min-a;

        int time = 4000;

        try {
            Thread.sleep(time);

            temp(min, max, r, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void datchik5(){

        int min = 54;
        int max = 129;
        int a = 23;
        int r = random.nextInt(max + a - (min-a)) + min-a;

        int time = 5000;

        try {
            Thread.sleep(time);
            temp(min, max, r, time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
