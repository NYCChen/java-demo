package nyc.thread;

/**
 * 设计 4 个线程，其中两线程每次对 j 增加 1 ，另外两线程对 j 每次减少 1 。
 */
public class ThreadTest1 {
    private int j;
    public static void main(String args[]) {
        ThreadTest1 tt = new ThreadTest1();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }
    }
    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }
    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }
    class Inc implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }
    class Dec implements Runnable {
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}


//--------随手再写的一个------------
class A {
    JManager j = new JManager();

    public static void main() {
        new A().call();
    }

    void call()
    {
        for (int i = 0; i < 2; i++) {
            new Thread(
                    new Runnable() {
                        public void run() {
                            while (true) {
                                j.accumulate();
                            }
                        }
                    }
            ).start();
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        j.subtract();
                    }
                }
            }).start();
        }
    }
}

class JManager {
    private int j =0;

    public synchronized void subtract() {
        j--;
    }

    public synchronized void accumulate() {
        j++;
    }
}
