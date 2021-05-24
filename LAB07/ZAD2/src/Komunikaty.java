import java.time.LocalDateTime;
import java.util.TimeZone;

public class Komunikaty {
    public static void giveMessage(String trescWiadomosci){

        int miliTime = LocalDateTime.now().getNano()/1000000;
        String time = LocalDateTime.now().getHour()+":"+LocalDateTime.now().getMinute()+":"+LocalDateTime.now().getSecond()+"."+miliTime;
        System.out.println("["+time+"] "+trescWiadomosci);
    }
}
