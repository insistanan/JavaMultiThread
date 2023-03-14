package demo.售票;

import java.util.concurrent.locks.ReentrantLock;

public class TicketLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        // 需要保证用的是同一把锁，所以用的都是一个Ticket对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
class Ticket implements Runnable {
    //票的数量
    private int ticket = 100;
    private Object obj = new Object();
    // Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket <= 0) {
                    //卖完了
                    break;
                } else {
                    Thread.sleep(100);
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

