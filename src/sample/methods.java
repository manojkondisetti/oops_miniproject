package sample;

import javafx.scene.control.ListView;

import java.io.*;


public class methods {
    public static void delete(ListView l,String url,String sub){
        BufferedReader c = null;
        try {
            c = new BufferedReader(new FileReader(new File(url)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = l.getSelectionModel().getSelectedItem().toString();
        //String text = getDisplayText(s);


        String[] result = s.split("\r\n|\r|\n", 2);
        String m = "",k="";
        try {
                    m = c.readLine();
                    String q = result[0].substring(4, result[0].length());
                    k = m.replaceAll("\\s+", "");
                    System.out.println(m);
                    System.out.println(q);
                    System.out.println((q.replaceAll("\\s+", "")).equals(k));
                    //if ((q.replaceAll("\\s+", "")).equals(k))
                    //if(true){
                        String present="";
                        File t = new File(url);
                        File o;
                        if(sub.equals("maths")) {
                            o = new File("C:/Users/manoj/IdeaProjects/Mini/Temp/maths.txt");
                        }
                        else if(sub.equals("physics")) {
                            o = new File("C:/Users/manoj/IdeaProjects/Mini/Temp/physics.txt");
                        }
                        else {
                            o = new File("C:/Users/manoj/IdeaProjects/Mini/Temp/chemistry.txt");
                        }
                        BufferedReader b = null;
                        BufferedWriter w = null;
                        c.close();
                        try {
                            b = new BufferedReader(new FileReader(t));
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        try {
                            w = new BufferedWriter(new FileWriter(o));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            //System.out.println(b.readLine());
                            String abcd;
                            while ((present = b.readLine()) != null) {

                                if (present.equals(q)) {
                                    System.out.println(present);
                                    abcd = present;
                                    while (!("".equals(abcd))) {
                                        if (abcd == null) break;
                                        {
                                            System.out.println(abcd);
                                            abcd = b.readLine();
                                            continue;
                                        }
                                    }
                                } else {
                                    try {
                                        w.write(present);
                                        w.newLine();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            w.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        //try {
                            b.close();
                       // } catch (IOException e) {
                           // e.printStackTrace();
                        //}

                        copy(o,t);
                        Pool p = new Pool();
                        p.show(url,sub);
                        c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(File a,File b){
        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream(a);
            out = new FileOutputStream(b);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();

            System.out.println("File copied successfully!!");

        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static void add(String q,String o0,String o1,String o2,String o3,String url,String sub,int a){
        //File a = new File(url);
        FileWriter f = null;
        try {
            f = new FileWriter(url,true);
             BufferedWriter b = new BufferedWriter(f);
            System.out.println(q);
            //if(a==1){
            b.newLine();//}
            b.write(q);
            b.newLine();
            b.write(o0);
            b.newLine();
            if(!"".equals(o1)) {
                System.out.println("741258963");
                b.write(o1);
                b.newLine();
                if(!"".equals(o2)) {
                    b.write(o2);
                    b.newLine();
                    if(!"".equals(o3)) {
                        b.write(o3);
                        b.newLine();
                    }
                    else {
                        //b.newLine();
                    }
                }
                else{
                    //b.newLine();
                }
            }
            else {
                //b.newLine();
            }

            b.close();
            f.close();
            Pool p = new Pool();
            p.show(url,sub);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("hello");
    }
    public static void generate(int n,String url){
        /*FileWriter fw = null;
        BufferedWriter bw = null;
        FileReader fr = null;
        BufferedReader br = null;
    try{
        fw = new FileWriter("C:/Users/manoj/IdeaProjects/Mini/Generated Test/test.txt",false);
        bw = new BufferedWriter(fw);

        fr = new FileReader(url);
        br = new BufferedReader(fr);
        String present;
        int count=0;
        while (count < n) {
            present = br.readLine();
            if("".equals(present)) count++;
            System.out.println(present);
            bw.write(present);
            bw.newLine();
        }
        }catch(IOException ioe){
        //System.out.println("1478523");
            ioe.printStackTrace();
        }
        try {
            fw.close();
            bw.close();
            fr.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File a = new File(url);
        File b = new File("C:/Users/manoj/IdeaProjects/Mini/Generated Test/test.txt");
        copy(a,b);
    }
}
