package demo.售票;

public class SellTickets implements Runnable {
    private int tickets = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10);
                //休息10毫秒，模拟机器性能或者网络元音
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj) {
                // 对可能有安全问题的代码加锁,多个线程必须使用同一把锁
                //t1进来后，就会把这段代码给锁起来
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                        //休息10毫秒，买票打印信息
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //窗口1正在出售第100张票
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                    tickets--; //tickets = 99;
                }
                else {break;}
            }
            //t1出来了，这段代码的锁就被释放了
        }
    }
}

class SellTicketDemo {
    public static void main(String[] args) {
        SellTickets st = new SellTickets();

        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}




