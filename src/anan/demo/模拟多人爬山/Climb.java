package demo.模拟多人爬山;

/**
 * 爬山游戏
 *
 * @author insis
 * @date 2023/03/12
 */
public class Climb {
    public static void main(String[] args) {
        ClimbThread stripling = new ClimbThread("年轻人",500,1);
        ClimbThread oldMan = new ClimbThread("老年人",1500,1);
        System.out.println("*******开始爬山*******");
        stripling.start();
        oldMan.start();
    }
}
class ClimbThread extends Thread{

    /**
     * 爬一百米需要的时间
     */
    private int time;
    /**
     * 需要爬的山有多少个一百米
     */
    private int num = 0;
    public ClimbThread(String name,int time,int kilometer){
        super(name);
        this.time = time;
        this.num = kilometer * 1000/100;
    }
    public void run(){
        while (num>0){
            try {
                Thread.sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"爬完一百米！");
            num--;
        }
    }
}
