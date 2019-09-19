import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;
    private int i = 0;
    private int num = 0;
    // private byte[] lock = new byte[0];
    private boolean ifZeroDone = false;
    private boolean ifOddDone = false;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i1 = 0; i1 < n; i1++) {
            synchronized (this) {
                while (num % 2 != 0 || ifZeroDone) {
                    this.wait();
                }
                printNumber.accept(0);
                ifZeroDone = true;
                num++;
                this.notifyAll();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i1 = 0; i1 < n; i1++) {
            synchronized (this) {
                while (num % 2 == 0 || !ifOddDone) {
                    this.wait();
                }
                i++;
                printNumber.accept(i);
                num++;
                ifOddDone = false;
                ifZeroDone = false;
                this.notifyAll();
            }
        }

    }
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i1 = 0; i1 < n; i1++) {

            synchronized (this) {
                while (num % 2 == 0 || !ifZeroDone) {
                    this.wait();
                }
                i++;
                printNumber.accept(i);
                ifOddDone = true;
                ifZeroDone = false;
                num++;
                this.notifyAll();
            }
        }
    }


}
