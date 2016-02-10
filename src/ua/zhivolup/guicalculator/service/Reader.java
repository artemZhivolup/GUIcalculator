package ua.zhivolup.guicalculator.service;
import java.io.*;

public class Reader {
    private BufferedReader console;

    public Reader(){
        InputStreamReader stdin = new InputStreamReader(System.in);
        console = new BufferedReader(stdin);
    }

    public int getChoice(){
        int choice = 0;
        try{
            String str = console.readLine();
            choice = Integer.parseInt(str);
        } catch(Exception e){
            e.printStackTrace();
        }
        return choice;
    }

    public double readNumber(){
        double value = 0.0d;
        try{
            String str = console.readLine();
            value = Double.parseDouble(str);
        } catch(Exception e){
            e.printStackTrace();
        }

        return value;
    }

    public char readOperation(){
        char operator = '\u0000';
        try{
            System.out.println("Now, choose operation, please: \n+, -, *, /");
            operator = console.readLine().charAt(0);
        } catch(Exception e){
            e.printStackTrace();
        }
        return operator;
    }

}