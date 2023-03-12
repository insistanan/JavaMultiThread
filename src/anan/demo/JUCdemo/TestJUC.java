package demo.JUCdemo;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 测试juc
 * java.util.concurrent （缩写 JUC）并发编程包是专门为 Java 并发编程设计的，里面有一个关于List安全的集合
 * @author insis
 * @date 2023/03/12
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
