package concept;

public class ThreadState implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("线程t在运行（运行状态）");
            Thread.sleep(2000);
            System.out.println("线程t在短时间休眠后重新运行（阻塞状态）");
            int i = 10/0;
        } catch (Exception e) {
            System.out.println("线程被中断（死亡状态）");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadState());
        System.out.println("线程t1为新建（创建状态）");
        t1.start();
        System.out.println("线程t1为就绪（就绪状态）");
    }
}
