package demo.取钱;

/**
 * 不安全银行
 * 不安全取钱
 * 两个人去银行取钱，账户
 * @author insis
 * @date 2023/03/12
 *///
public class UnsafeBank {
    public static void main(String[] args) {
        //账户
        Account account = new Account(1000,"生活费");
        Drawing you = new Drawing(account,500,"你");
        Drawing son = new Drawing(account,1000,"儿子");
        you.start();
        son.start();
    }
}
//账户
class Account{
    int money; //余额
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}
//银行：模拟取款
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;
    //现在手里还有多少钱
    int nowMoney;
    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;

    }
    //取钱
    @Override
    public void run(){
        //判断有没有钱
        if (account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"钱不够取不了");
            return;
        }
        try {
            //sleep放大问题的发生性
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //卡里的余额=余额-你取的钱
        account.money=account.money-drawingMoney;
        //你手里的钱
        nowMoney=nowMoney+drawingMoney;
        System.out.println(account.name+"余额为："+account.money);
        //Thread.currentThread().getName()=this.getName()
        System.out.println(this.getName()+"手里的钱："+nowMoney);
    }

}
