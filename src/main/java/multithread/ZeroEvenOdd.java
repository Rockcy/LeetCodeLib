package multithread;

import java.util.Scanner;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private boolean ifZeroDone = false;
    private boolean ifOddEvenDone = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {

        synchronized (this) {
            for (int i = 0; i < n; i++){
                while (ifZeroDone) {
                    this.wait();
                }
                printNumber.accept(0);
                this.notifyAll();
                ifZeroDone = true;
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        synchronized (this) {
            for (int i = 2; i <= n; i+=2) {
                while (!ifZeroDone || !ifOddEvenDone) {
                    this.wait();
                }
                printNumber.accept(i);
                ifOddEvenDone = false;
                ifZeroDone = false;
                this.notifyAll();
            }
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {


        synchronized (this) {
            for (int i = 1; i <= n; i+=2) {
                while (ifOddEvenDone || !ifZeroDone) {
                    this.wait();
                }
                printNumber.accept(i);
                this.notifyAll();
                ifOddEvenDone = true;
                ifZeroDone = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            System.out.println("传入n: " + input);
            ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(input);
            IntConsumer intConsumer = value -> System.out.println(value);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.zero(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.odd(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        zeroEvenOdd.even(intConsumer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
