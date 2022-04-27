package IUS;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Datchik {

    Timer timer = new Timer();
    static Random random = new Random();

    public static void main(String[] args) {
        Timer timer = new Timer();
        Random random = new Random();
        while(true) {
            datchik1();datchik2(); datchik3();datchik4(); datchik5();
        }
    }
     public static void datchik1(){
        int min = 22;
        int max = 55;
        int a = 5;
        int r = random.nextInt(max - a - (min-a) + min);
        try {
            Thread.sleep(3000);
            if(r<min || r>max) {
                System.out.println(r);
            }else {
                System.out.println("Всё в норме. Температура: " + r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     }

    public static void datchik2(){
        int min = 36;
        int max = 127;
        int a = 5;
        int r = random.nextInt(max - a - (min-a) + min);
        try {
            Thread.sleep(4000);
            if(r<min || r>max) {
                System.out.println(r);
            }else {
                System.out.println("Всё в норме. Температура: " + r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void datchik3(){
        int min = 38;
        int max = 55;
        int a = 5;
        int r = random.nextInt(max - a - (min-a) + min);
        try {
            Thread.sleep(3000);
            if(r<min || r>max) {
                System.out.println(r);
            }else {
                System.out.println("Всё в норме. Температура: " + r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void datchik4(){
        int min = 10;
        int max = 34;
        int a = 5;
        int r = random.nextInt(max - a - (min-a) + min);
        try {
            Thread.sleep(3000);
            if(r<min || r>max) {
                System.out.println(r);
            }else {
                System.out.println("Всё в норме. Температура: " + r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void datchik5(){
        int min = 54;
        int max = 129;
        int a = 5;
        int r = random.nextInt(max - a - (min-a) + min);
        try {
            Thread.sleep(3000);
            if(r<min || r>max) {
                System.out.println(r);
            }else {
                System.out.println("Всё в норме. Температура: " + r);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
