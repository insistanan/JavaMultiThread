package demo.网图下载;

import java.util.concurrent.*;

/**
 * 通过runnanle实现多线程下载
 *
 * @author insis
 * @date 2023/03/12
 */
public class downloadByCallableThread implements Callable<Boolean> {
    //网络图片地址
    private String url;
    //保存的文件名
    private String name;
    public downloadByCallableThread(String url, String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        downloadByCallableThread c1 = new downloadByCallableThread("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao1.png","1.jpg");
        downloadByCallableThread c2 = new downloadByCallableThread("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao2.png","2.jpg");
        downloadByCallableThread c3 = new downloadByCallableThread("https://dgss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1848053418,1608633216&fm=173&app=49&f=JPEG?w=312&h=208&s=A10BDE1442585DCE0642B4C2030050BA","3.jpg");
        downloadByCallableThread c4 = new downloadByCallableThread("https://dgss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2303065390,19508065&fm=173&app=49&f=JPEG?w=312&h=208&s=E8720DD7568066E40838C97203008033","4.jpg");
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(4);
        //提交执行
        Future<Boolean> result1 = ser.submit(c1);
        Future<Boolean> result2 = ser.submit(c2);
        Future<Boolean> result3 = ser.submit(c3);
        Future<Boolean> result4 = ser.submit(c4);
        //获取结果
        boolean a1 = result1.get();
        boolean a2 = result2.get();
        boolean a3 = result3.get();
        boolean a4 = result4.get();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        //关闭服务
        ser.shutdownNow();
    }
}
