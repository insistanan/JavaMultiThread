package concept;

public class soutThreadName {
    public void ThreadName(){
        Thread t1 = Thread.currentThread();
        System.out.println("当前线程是" + t1.getName());
        t1.setName("anan-Thread");
        System.out.println("当前线程是" + t1.getName());
    }

    public static void main(String[] args) {
        new soutThreadName().ThreadName();
    }

}
