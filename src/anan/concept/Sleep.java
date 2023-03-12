package concept;

public class Sleep {
    public static void main(String[] args) {
        System.out.println("Wait");
        Wait.bySet(5);//让主线程等待5秒后在执行
        System.out.println("start");
    }
}

/**
 * 等待
 *
 * @author insis
 * @date 2023/03/12
 */
class Wait{
    public static void bySet(long s){
        for (int i = 1; i < s+1; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i+"秒");
        }


    }
}

/**
 * 倒计时
 *
 * @author insis
 * @date 2023/03/12
 */
class CountDown{
    public static void main(String[] args) {
        try {
            tenDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void tenDown() throws InterruptedException {
        int a =10;
        while (true){
            Thread.sleep(1000);
            System.out.println(a--);
            if (a<=0){
                break;
            }
        }
    }

}
