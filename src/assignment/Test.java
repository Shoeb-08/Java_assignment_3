package assignment;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;
public class Test {

    /*public static void runCom(String c1) {
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
    }*/
    void median(String hostname,int n)throws IOException{
        ProcessBuilder pb=new ProcessBuilder("ping","-c",String.valueOf(n), hostname);
        Process p=pb.start();
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader defect=new BufferedReader(new InputStreamReader(p.getErrorStream()));
        String s="";
        float count[]=new float[n];
        float median = 0;
        /*try {
            String s="";
            Process a1 = Runtime.getRuntime().exec(c1);
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(a1.getInputStream()));
            while ((s=inputStream.readLine())!= null)
            {
                System.out.println(s);
            }
        }*/
        int j=0;
        while((s=br.readLine())!=null )
        {
            int index= s.indexOf("time=");
            if(index!=-1){
                String temp=s.substring(index+5,s.length()-3);
                count[j++]=Float.parseFloat(temp);
            }

        }
        if(n%2==0){
            median=(count[n/2]+count[n/2+1])/2;
        }
        else {
            median = count[n / 2];
        }
        System.out.println("Median: "+median);
        while((s=defect.readLine())!=null) {
            System.out.println("not found" + s);
        }
    }
    public static void main(String[] args) throws IOException {
        Test t=new Test();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<String> a=new ArrayList<>();
      /* for(int i=0;i<n;i++){
           String s=sc.nextLine();
           a.add(s);

        }*/
        a.add("128.0.0.0");
        a.add("127.1.1.1");
        for(String temp:a) {
            t.median(temp,n);
        }


    }
}

