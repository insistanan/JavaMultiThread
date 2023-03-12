package concept;

public class ThreadCreateByImplementRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }

    public static void main(String[] args) {
        //创建一个实现了Runnable接口的对象
        ThreadCreateByImplementRunnable thread = new ThreadCreateByImplementRunnable();
        //将该对象传给Thread类的构造函数
        Thread t1 = new Thread(thread);
        Thread t2 = new Thread(thread);
        //thread对象调用start方法，在这里不会调用自身的run方法，它会调用myThread对象的run方法
        t1.start();
        t2.start();
    }
}
