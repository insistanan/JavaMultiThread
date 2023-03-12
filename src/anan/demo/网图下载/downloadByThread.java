package demo.网图下载;

/**
 * 多线程下载Thread
 *
 * @author insis
 * @date 2023/03/12
 */
public class downloadByThread extends Thread{
    //网络图片地址
    private String url;
    //保存的文件名
    private String name;
    public downloadByThread(String url,String name){
        this.url = url;
        this.name = name;
    }
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为："+name);
    }

    public static void main(String[] args) {
        downloadByThread t1 = new downloadByThread("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao1.png","1.jpg");
        downloadByThread t2 = new downloadByThread("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao2.png","2.jpg");
        downloadByThread t3 = new downloadByThread("https://dgss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1848053418,1608633216&fm=173&app=49&f=JPEG?w=312&h=208&s=A10BDE1442585DCE0642B4C2030050BA","3.jpg");
        downloadByThread t4 = new downloadByThread("https://dgss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2303065390,19508065&fm=173&app=49&f=JPEG?w=312&h=208&s=E8720DD7568066E40838C97203008033","4.jpg");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

