package assignment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Test {

    public static void runCom(String c1) {
        try {
            String s="";
            Process a1 = Runtime.getRuntime().exec(c1);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(a1.getInputStream()));
            while ((s=inputStream.readLine())!= null)
            {
                System.out.println(s);
            }
        }
        catch (Exception e) {
           System.out.println("exception caught");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the ip");
        String s =sc.nextLine();
        runCom(s);


    }
}

