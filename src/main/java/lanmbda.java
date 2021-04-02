import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author dxy
 * @date 2021/3/17 - 16:34
 */
public class lanmbda implements Runnable{


    public static void main(String[] args) throws InterruptedException {
     System.out.println(Thread.currentThread().getPriority());

        Thread thread = new Thread(new lanmbda(),"插队");
       // thread.setPriority();
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"+"+i+"+"+thread.getPriority());
            if (i==50) {
                thread.join();
            }
        }
        String a="ads";
        System.out.println(a.toUpperCase());
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new Date());

        System.out.println(date);

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println(Thread.currentThread().getName()+"+"+i+"+"+Thread.currentThread().getPriority());
        }
    }
}

