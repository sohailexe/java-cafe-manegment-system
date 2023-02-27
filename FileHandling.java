import com.sun.tools.javac.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class FileHandling  {


//    public static String AdminDetail_path="../../Data/AdminLoginDetails.txt";
//    public static String item_path="../../Data/items.txt";
//    public static String price_path="../../Data/price.txt";
//    public static String quantity_path="../../Data/Quantity.txt";
//    public static String pricePerQuantity_path="../../Data/pricePerQuantity.txt";
//    public static String CataGorey_path="../../Data/CataGorey.txt";



    public static String CataGorey_path="data/CataGorey.txt";
    public static String AdminDetail_path="data/AdminLoginDetails.txt";
    public static String item_path="data/items.txt";
    public static String price_path="data/price.txt";
    public static String quantity_path="data/Quantity.txt";
    public static String pricePerQuantity_path="data/pricePerQuantity.txt";




    //       **************************************************************************************************
    static Scanner input=new Scanner(System.in);

    //    **************************************************Check Passworld******************************************************
    public static String printSpaces(){
        return "                       ";
    }

    public static boolean checkInformation(String file_input,String user_input ,String data) throws  Exception{
        String condition="YES";



        do {
            if (Objects.equals(file_input, user_input)) {
                return true;
            }
            else if (!file_input.equals(user_input)){
                System.out.println("                                                ***invalid "+data+" Error(\u274C)***");

                System.out.println();

                System.out.print(printSpaces()+printSpaces()+"   Try again (Yes/No)\uD83D\uDD01-:");



                condition=input.next();
                System.out.println();

                int j=0;
                do {
                    if (j!=0){
                        System.out.print(printSpaces()+"Enter Yes/No  -:");
                        condition=input.next();
                    }
                    j++;
                    condition=condition.toLowerCase();
                }while (!(condition.equals("yes")) && !(condition.equals("no")));


                condition=condition.toLowerCase();

                if (!condition.equals("no")){
                    if (data.equals("Passworld"))
                        System.out.print(printSpaces()+"Enter Correct Passworld \uD83D\uDD12 -:");

                    else
                        System.out.print(printSpaces()+"Enter Correct User Name \uD83D\uDC68 -:");
                    user_input=input.next();
                }
            }
            condition=condition.toLowerCase();
        }while (!condition.equals("no"));
        return false;
    }


    //    **************************************************Check Passworld******************************************************


    public static ArrayList<ArrayList> priceList() throws  Exception{
        File file=new File(CataGorey_path);
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader( fr);
        ArrayList<ArrayList> priceArrayList=new ArrayList<>();

        String line=" ";
        while (line!=null){
            line=br.readLine();
            int i=0;
            if (line!=null){
                ArrayList<Integer> priceList=new ArrayList<>();
                while (line.charAt(i)!='.'){
                    char c=line.charAt(i) ;
                    String s="";

                    if (Character.isDigit(c)){
                        while (Character.isDigit(c)){
                            if (line.charAt(i)==')')
                                break;
                            s+=line.charAt(i++);
                        }
                    }

                    if (s!="")
                        priceList.add(Integer.parseInt(s));
                    i++;
                }
                priceArrayList.add(priceList);

            }
        }
        return priceArrayList;
    }
    public static String removeBrackets(String line){
        String s="";
        int i=0;
        while (line.charAt(i)!='.' ){
            while ((line.charAt(i)==')' || Character.isDigit( line.charAt(i) ) || line.charAt(i)=='(' ) ){
                i++;
            }
            if (line.charAt(i)!='.')
                s+=line.charAt(i++);
        }
        return s+'.';
    }

    public static ArrayList<String> catagaroyListFromFile() throws Exception{
        File file=new File(CataGorey_path);
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader( fr);
        ArrayList<String> catagoreyList=new ArrayList<>();

        String line="";

        while (line!=null){
            line= br.readLine();
            String st="";
            int i=0;
            if (line!=null){
                while (line.charAt(i)!=','){
                    char c=line.charAt(i);
                    st+=c;
                    i++;
                }
                catagoreyList.add(st);
            }
        }
        return catagoreyList;
    }
    public static ArrayList retrieveDatafromFilesINArraylist()throws Exception{
        File file=new File(CataGorey_path);
        ArrayList<ArrayList> itesList=new ArrayList<>();
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader( fr);

        String line="";

        while (line!=null){
            line= br.readLine();
            ArrayList<String> stringList=new ArrayList<>();

            if (line!=null){
                line=removeBrackets(line);
                int i=0;
                while (line.charAt(i)!=','){
                    i++;
                }
                i++;

                while (line.charAt(i)!='.'){
                    String item="";
                    while (line.charAt(i)!='_' && line.charAt(i)!='.'){
                        if (line.charAt(i)!='_' && line.charAt(i)!='.')
                            item+=line.charAt(i++);
                    }
                    stringList.add(item);
                    if (line.charAt(i)!='.')
                        i++;
                }
                itesList.add(stringList);
            }

        }
        return itesList;
    }




//*****************    FILE HANDLING    *****************

    //    READING IN THE FILE


    //    WRITING IN THE FILE
    public static void addItemsInFile(String item) throws  Exception{
        PrintWriter pw=new PrintWriter( new FileWriter(item_path,true));
        pw.println(item);
        pw.close();
    }
    public static void addPriceInFile(int price) throws  Exception{
        PrintWriter pw=new PrintWriter( new FileWriter(price_path,true));
        pw.println(price);
        pw.close();
    }
    public static void addQuantityInFile(int Quantity) throws  Exception{
        PrintWriter pw=new PrintWriter( new FileWriter(quantity_path,true));
        pw.println(Quantity);
        pw.close();
    }
    public static void addPricePerQuantityInFile(int price) throws  Exception{
        PrintWriter pw=new PrintWriter( new FileWriter(pricePerQuantity_path,true));
        pw.println(price);
        pw.close();
    }
    //*****************    FILE HANDLING   End *****************
}
