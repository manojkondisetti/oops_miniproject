package sample;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class please {
    public static void main(String args[]){
        try {
            FileWriter f = new FileWriter("C:/Users/manoj/IdeaProjects/Mini/Temp/maths.txt", true);
            BufferedWriter b = new BufferedWriter(f);
            b.write("abc");
            b.newLine();
            b.write("def");
            b.close();
            f.close();
        }
        catch (Exception e){

        }
    }
}
