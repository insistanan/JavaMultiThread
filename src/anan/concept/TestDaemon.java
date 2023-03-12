package concept;

/**
 * 测试守护进程
 * 国家守护你
 * @author insis
 * @date 2023/03/12
 */
public class TestDaemon {
    public static void main(String[] args) {
        China china = new China();
        You you = new You();
        //让国家编程守护线程
        Thread thread = new Thread(china);
        //setDaemon返回值是Boolean 默认是false表示用户线程
        thread.setDaemon(true);
        //守护线程启动
        thread.start();
        //用户线程启动
        new Thread(you).start();
    }
}

//国家
class China implements Runnable{
    //守护线程
    @Override
    public void run() {
        while(true){
            //国家永远存在
            System.out.println("国家保护着你！");
        }
    }
}
class You implements Runnable{
    //用户线程
    @Override
    public void run() {
        // 人生不过三万天
        for (int i = 0; i < 30000; i++) {
            System.out.println("你开心的活着");
        }
        System.out.println("*******goodbye!*******");
    }
}
