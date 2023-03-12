package demo.售票;

/**
 * 买票
 * 简单的案例，没有解决同步问题，不安全
 *
 * @author insis
 * @date 2023/03/12
 */
public class BuyTicket implements Runnable{
    //票数
    private int ticketNums = 10;
    @Override
    public void run() {
        while (true){
            if (ticketNums<=0){
                break;
            }
            try {//模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }
    }

    public static void main(String[] args) {
        BuyTicket r = new BuyTicket();
        new Thread(r,"anan").start();
        new Thread(r,"小明").start();
        new Thread(r,"demon").start();
    }
}
