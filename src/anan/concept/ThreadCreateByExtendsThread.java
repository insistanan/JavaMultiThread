package concept;

public class ThreadCreateByExtendsThread extends Thread{
    @Override
    public void run() {
        Thread.currentThread().setName("子线程");
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程名：" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        //通过继承Thread类完成线程的创建
        ThreadCreateByExtendsThread thread = new ThreadCreateByExtendsThread();
        thread.start();
    }
}
