package concept;

public class Priority implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"正在运行："+i);
        }
    }

    public static void main(String[] args) {
        //通过构造方法指定线程名
        Thread t1 = new Thread(new Priority(),"线程a");
        Thread t2 = new Thread(new Priority(),"线程b");
        //设置线程的优先级
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("********线程的优先级*********");
        System.out.println("线程A的优先级："+t1.getPriority());
        System.out.println("线程B的优先级："+t2.getPriority());
        System.out.println("************************");
        t1.start();
        t2.start();
    }
}
