package demo.售票;

public class BuyTicketSafe {
    public static void main(String[] args) {
        Site site = new Site();
        Thread t1 = new Thread(site,"anan");
        Thread t2= new Thread(site,"demon");
        Thread t3 = new Thread(site,"miku");
        t1.start();
        t2.start();
        t3.start();
    }
}

class Site implements Runnable{
    //定义票的数量
    int count = 100;
    //定义购买了第几张票
    int sum = 0;

    @Override
    public void run() {

        while (true){
            synchronized (this){
                if (count==0)
                {break;}

                count--;
                sum++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"购买了第"+sum+"张票，剩余"+count+"张票");

            }

        }
    }
}