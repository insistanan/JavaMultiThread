package demo.模拟叫号看病;

public class Cure {
    public static void main(String[] args) {
        //开辟线程模拟特区号叫号
        Thread thread = new Thread(new CureThread());
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        //主线程模拟普通医生叫号
        for (int i = 1; i < 21; i++) {
            System.out.println("普通号："+ i +"号病人在看病！");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i==9){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class CureThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println("特需号："+ i +"号病人在看病！");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
