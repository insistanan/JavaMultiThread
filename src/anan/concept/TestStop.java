package concept;

public class TestStop implements Runnable{
    //1.设置一个标志位 私有的 保证安全
    private boolean flag = true;
    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("线程正在运行！"+i++);
        }
    }
    //2.设置一个公开的方法停止线程，转换标志位
    public void stop(){
        this.flag = false;
    }
    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("main"+i);
            if (i==100){//100的时候停止
                testStop.stop();//调用stop方法停止运行（自己写的stop方法）
                System.out.println("线程停止运行！");
                //两个i是分别存活在两个线程里的独立参数,两个线程没关系，不需要break
                //注意：这里是主线程到100时，停止子线程
            }
        }
    }
}
