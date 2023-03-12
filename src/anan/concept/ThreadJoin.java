package concept;

public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //输出当前线程信息
            System.out.println(Thread.currentThread().getName()+"运行"+i);
        }
    }

    public static void main(String[] args) {
        System.out.println("*******线程强制执行********");
        //创建子线程并启动
        Thread t = new Thread(new ThreadJoin());
        t.start();
        for (int i = 0; i < 20; i++) {
            if (i==5){
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"运行"+i);
        }

    }
}
