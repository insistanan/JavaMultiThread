package demo.网图下载;

/**
 * 通过runnanle实现多线程下载
 *
 * @author insis
 * @date 2023/03/12
 */
public class downloadByRunnanle implements Runnable{
    //网络图片地址
    private String url;
    //保存的文件名
    private String name;
    public downloadByRunnanle(String url,String name){
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
        downloadByRunnanle r1 = new downloadByRunnanle("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao1.png","1.jpg");
        downloadByRunnanle r2 = new downloadByRunnanle("https://dss2.bdstatic.com/5bVYsj_p_tVS5dKfpU_Y_D3/res/r/image/2022-10-16/toutiao2.png","2.jpg");
        downloadByRunnanle r3 = new downloadByRunnanle("https://dgss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=1848053418,1608633216&fm=173&app=49&f=JPEG?w=312&h=208&s=A10BDE1442585DCE0642B4C2030050BA","3.jpg");
        downloadByRunnanle r4 = new downloadByRunnanle("https://dgss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=2303065390,19508065&fm=173&app=49&f=JPEG?w=312&h=208&s=E8720DD7568066E40838C97203008033","4.jpg");
        new Thread(r1).start();
        new Thread(r2).start();
        new Thread(r3).start();
        new Thread(r4).start();
    }
}
