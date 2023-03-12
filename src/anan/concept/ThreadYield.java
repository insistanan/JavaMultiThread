package concept;

public class ThreadYield implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"正在运行"+i);
            if (i==3){
                System.out.println("线程礼让：");
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("*******线程的礼让*******");
        ThreadYield r = new ThreadYield();
        Thread t1 = new Thread(r,"线程A");
        Thread t2 = new Thread(r,"线程B");
        t1.start();
        t2.start();
    }
}
