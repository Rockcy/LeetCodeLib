package multithread;

public class FooBar {
    private int n;
    private boolean ifFooDone = false;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (ifFooDone) {
                    this.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                ifFooDone = true;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (!ifFooDone) {
                    this.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                ifFooDone = false;
                this.notifyAll();
            }
        }
    }
}
