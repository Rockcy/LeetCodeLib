package multithread;

public class Foo {

    public Foo() {

    }
    private boolean ifFirstDone;
    private boolean ifSecondDone;
    private final Object lock=new Object();
    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        synchronized(lock){
            printFirst.run();
            ifFirstDone=true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock){
            while(!ifFirstDone){
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            ifSecondDone=true;
            lock.notifyAll();

        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized(lock){
            // printThird.run() outputs "third". Do not change or remove this line.
            while(!ifSecondDone){
                lock.wait();
            }
            printThird.run();
        }
    }
}
