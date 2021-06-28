
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input DOB in the format MM/dd/yyyy");
        String dob = scan.nextLine();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        simpleDateFormat.setLenient(false);
        Date time = new Date();
        long timeMili = time.getTime();
        try {
            Date date = simpleDateFormat.parse(dob);
            long ageMilli = timeMili - date.getTime();
            // System.out.println(ageMilli);
            long days = TimeUnit.MILLISECONDS.toDays(ageMilli);
            int value = (int)days/365;
            System.out.println(value);
            
        } catch (ParseException e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        

        scan.close();
    }
    
}
