import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Custommer extends FileHandling {

    public static String CataGorey_path="data/CataGorey.txt";
    public static String AdminDetail_path="data/AdminLoginDetails.txt";
    public static String item_path="data/items.txt";
    public static String price_path="data/price.txt";
    public static String quantity_path="data/Quantity.txt";
    public static String pricePerQuantity_path="data/pricePerQuantity.txt";



    static Scanner input=new Scanner(System.in);











//******************Exception Handling************************************************


    public static boolean containChar(String st){
        for (int i=0;i<st.length();i++){
            if (!(Character.isDigit(st.charAt(i))) )
                return true;
        }
        return false;
    }







    public static String getValueOnly_In_numbers(String givenString){
        boolean c=true;
        int i=0;
        do {
            if (i!=0){
                givenString=input.next();
            }
            try {
                int n=Integer.parseInt(givenString);
                if (n<0){
                    System.out.println("-ve number error");
                    System.out.println("                                                       *** -ve number Error(\u274C) ***");
                    System.out.print(printSpaces()+"-ve numbers are not allowd Enter again-> ");
                    continue;
                }
                c=false;
                givenString="";
                givenString=givenString+n;

            }catch (Exception e){
                System.out.println("                                                       *** invalid number Error(\u274C) ***");
                System.out.print(printSpaces()+"Enter a proper numbers-> ");
            }
            i++;

        }while (c);
        return givenString;
    }






    //    >>>>>>>>>>>>>>>>>>>>>>>To Check If input String Contain Any number
    public static boolean containNum(String st){
        for (int i=0;i<st.length();i++){
            if (Character.isDigit(st.charAt(i)))
                return true;
        }
        return false;
    }
    public static String getValueOnly_In_latters(String givenString){
        do {
            if (containNum(givenString)){
                System.out.println("                                                       *** Invalid Syntax Error(\u274C) ***");
                System.out.print(printSpaces()+"Enter Proper name without using Numbers.-> ");
                givenString=input.next();
            }
        }while (containNum(givenString));
        return givenString;
    }

//    >>>>>>>>>>>>>>>>>>>>>>>To Check If input String Contain Any number


    public static int numInrangeCheck(int choice,int stNum,int endnum){
        boolean c=true;
        int j=0;
        int num= (stNum==-1)? 0: 1;
        int i=0;
        do {
            if (j!=0){
                String s=input.next();
                choice=checkNum(s);
                i++;
            }
            j++;

            if (!(choice<num)&&(!(choice>stNum) || (choice <= endnum))){
                c=false;
            }else {
                System.out.println("                                                       *** Invalid Range Error(\u274C) ***");
                System.out.print(printSpaces()+"Enter in Range "+(stNum+1)+" - "+endnum+":>");
            }
        }while (c);
        if (i!=0){
            System.out.println("                                              \033[4m        N U M B E R  I N  R A N G E(✔️)        \033[0m");
            System.out.println();
        }
        return choice;
    }
    public static int checkNum(String str){
        boolean c=true;
        int n=-1;
        int i=0;
        do {

            if (i!=0){
                str=input.next();
            }

            int j=0;
            i++;
            try {
                n=Integer.parseInt(str);
                c=false;
            }catch (java.lang.NumberFormatException e){
                System.out.println("                                                       *** Invalid Syntax Error(\u274C) ***");
                j++;
                System.out.print(printSpaces()+"Select a Number from the given option:> ");
            }
        }while (c);
//        System.out.println("                  ✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️✔️️ ");
        return n;
    }
//******************Exception Handling************************************************

    public static void customer() throws Exception{
        ArrayList<String> catagoreyList=catagaroyListFromFile();
        int choice=-1;
        int c=catagoreyList.size()+1;
        do {
            System.out.println();
            System.out.println(printSpaces()+"\033[1m\033[43m\033[4m                                C U S T O M E R  P A N E L (\uD83D\uDED2)                                 \033[0m");
            System.out.println();
            int i=0;
            for (;i<catagoreyList.size();i++){
                int n=i+1;
                System.out.printf(printSpaces()+"*    %-5d  %-14s   *\n",n,catagoreyList.get(i));

//                System.out.println(printSpaces()+"*    "+n+"   "+catagoreyList.get(i)+"  ");
            }
            System.out.printf(printSpaces()+"*    %-5d  %-14s\uD83D\uDD19 *",c,"Exit");
//            System.out.println(printSpaces()+"*    "+c+"   "+"Exit");
            String s=input.next();

            choice=checkNum(s);
            int j=c;
            choice=choice;
            choice=numInrangeCheck(choice,0,j);


            if (choice!=c){
                choice=choice-1;
                custommerChoice(choice);
            }
        }while (choice!=c);
        System.out.println("                                              \033[4m        C U S T O M E R  P A N E L  E X I T(✔️)        \033[0m");
        System.out.println();

    }

    public static void custommerChoice(int n) throws Exception{
        ArrayList<ArrayList> itemsArraysList= retrieveDatafromFilesINArraylist();
        ArrayList<String> stringArray=itemsArraysList.get(n);

        ArrayList<ArrayList> priceArrayList=priceList();
        ArrayList<Integer> integerList=priceArrayList.get(n);



        ArrayList<String> catagoreyList=catagaroyListFromFile();
        String s=catagoreyList.get(n);

        int choice=-1;
        int c=stringArray.size()+1;
        do {
            printHeader(s);
            int i=0;
            System.out.printf(printSpaces()+printSpaces()+"     *\033[43m  %-5s \033[0m|\033[43m %-13s  \033[0m|\033[43m %-8s \033[0m|  *\n","CHOICE","ITEMS","Price($)");
            for (;i< stringArray.size();i++){
                int l=i+1;
                System.out.printf(printSpaces()+printSpaces()+"     *  %-6d  %-15s | $%-8d |  *\n",l,stringArray.get(i),integerList.get(i));
            }
            System.out.printf(printSpaces()+printSpaces()+"     *  %-6d  %-7s\uD83D\uDD19 \n",c,"Exit");

            //            ******************Exception Handling
            String st=input.next();
            choice=checkNum(st);

            int j=c;
            choice=numInrangeCheck(choice,0,j);
            //            ******************Exception Handling

            if (choice!=c)
                itemSelector(n,choice-1);

        }while (choice!=c);

    }

    public static void itemSelector(int i,int j) throws Exception{
        ArrayList<ArrayList> itemsArraysList= retrieveDatafromFilesINArraylist();
        ArrayList<String> stringArray=itemsArraysList.get(i);

        ArrayList<ArrayList> priceArrayList=priceList();
        ArrayList<Integer> integerList=priceArrayList.get(i);
        int price= integerList.get(j);
        String item1=stringArray.get(j);

        itemType(item1,price);


    }

    static int total=0;
    public static void itemType(String str,int itemPrice ) throws Exception{
        System.out.println();
        printHeader("***"+str+"***");
        int itemQuantity;
        System.out.print(printSpaces()+printSpaces()+"Enter quantity = ");
        //            ******************Exception Handling
        String st=input.next();
        itemQuantity=checkNum(st);
        //            ******************Exception Handling

        int itemPriceTotal=itemQuantity*itemPrice;
        System.out.println(printSpaces()+printSpaces()+"***************************************************************");
        System.out.println(printSpaces()+printSpaces()+"*                    *\033[1m    Order Details    \033[0m*                  *");
        System.out.println(printSpaces()+printSpaces()+"*                                                             *");
        System.out.printf(printSpaces()+printSpaces()+"*          * \033[1m\033[4m %-13s | %-8s |  %-6s | \033[0m *         *\n","ITEM","Quantity","Price");
        System.out.printf(printSpaces()+printSpaces()+"*          *  \033[4m%-13s | %-8d | $%-6d |\033[0m  *         *\n",str,itemQuantity,itemPriceTotal);
        System.out.println(printSpaces()+printSpaces()+"*                                                             *");
        System.out.println(printSpaces()+printSpaces()+"*                                                             *");
        System.out.println(printSpaces()+printSpaces()+"*             \033[1m\033[4m  S E L E C T  A  O P T I O N  \033[0m                 *");
        System.out.printf(printSpaces()+printSpaces()+"*             *  %-6d  %-15s  ✔️️ *                *\n",1,"Add to bill");
        System.out.printf(printSpaces()+printSpaces()+"*             *  %-6d  %-15s  \u274C️️ *                *\n",2,"cancel order");
        System.out.print(printSpaces()+printSpaces()+"***************************************************************");

//        System.out.println();
//        System.out.println(printSpaces()+printSpaces()+"             \033[1m\033[44m\033[4m  S E L E C T  A  O P T I O N  \033[0m");
//        System.out.printf(printSpaces()+printSpaces()+"             *  %-6d  %-15s  ✔️ *\n",1,"Add to bill");
//        System.out.printf(printSpaces()+printSpaces()+"             *  %-6d  %-15s  \u274C *",2,"cancel order");

        //            ******************Exception Handling
        String choice=input.next();
        int choi=checkNum(choice);
        choi=numInrangeCheck(choi,0,2);
        //            ******************Exception Handling
        if (choi==1){
            System.out.println();
            System.out.println("                                              \033[4m        O R D E R E D  S U C C E S S F U L L Y(✔️)        \033[0m");
            System.out.println();
            addItemsInFile(str);
            addPriceInFile(itemPriceTotal);
            addPricePerQuantityInFile(itemPrice);
            addQuantityInFile(itemQuantity);
            total+=itemPriceTotal;
        }else {
            System.out.println();
            System.out.println("                                              \033[4m        O R D E R E D  C A N C E L E D(\u274C)        \033[0m");
            System.out.println();
        }



    }

    //    **************************************FORMATTING***********************************
    public static String printSpaces(){
        return "                       ";
    }
    public static void printHeader(String str){
        System.out.println();
        System.out.println(printSpaces()+printSpaces()+"*   \033[1m\033[4m                   "+str+"                   \033[0m   *");
        System.out.println();

    }




    //    ******************************************************************************Admin Pannel
    public static void adminPanel() throws  Exception{

        int choice=-1;
        do {
            System.out.println(printSpaces()+"\033[1m\033[45m\033[4m                                     A D M I N  P A N E L (\uD83D\uDD27)                                      \033[0m");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(printSpaces()+printSpaces()+"         \033[1m\033[42m\033[4m  S E L E C T  A  O P T I O N  \033[0m");
            System.out.println();
            System.out.println(printSpaces()+printSpaces()+"*       1    Change Admin Credentials  \uD83D\uDCDD *");
            System.out.println(printSpaces()+printSpaces()+"*       2    Add Categorey             ➕ *");
            System.out.println(printSpaces()+printSpaces()+"*       3    Delete Categorey          ➖ *");
            System.out.println(printSpaces()+printSpaces()+"*       4    View all Categorey        \uD83D\uDD0D *");
            System.out.println(printSpaces()+printSpaces()+"*       0    Exit                      \uD83D\uDD19 *");
            System.out.print(printSpaces()+printSpaces()+"          \033[4m                              \033[0m");


            //            ******************Exception Handling
            String st=input.next();
            choice=checkNum(st);
            choice=numInrangeCheck(choice,-1,4);
            //            ******************Exception Handling
            switch (choice){
                case 1->{
                    changeAdminDetails();
                }
                case 2->{
                    addCatagorey();
                }
                case 3->{
                    deleteCatagorey();
                }
                case 4->{
                    displayCatagorey();
                }
            }

        }while (choice!=0);
        System.out.println("                                              \033[4m        A D M I N  P A N E L  E X I T(✔️)        \033[0m");
        System.out.println();

    }
    public static void displayCatagorey() throws Exception{
        File f=new File(CataGorey_path);
        BufferedReader br=new BufferedReader( new FileReader(f));
        String line=br.readLine();
        int i=1;
        while (line!=null){

            System.out.println(printSpaces()+i+").........."+line);
            i++;
            line=br.readLine();
        }
    }
    public static void changeAdminDetails() throws Exception{
        System.out.println();
        System.out.println(printSpaces()+printSpaces()+"\033[1m\033[4m      C H A N G E  C R E D E N T I A L S(\uD83D\uDCDD)     \033[0m");

        System.out.println();
        File f=new File(AdminDetail_path);
        BufferedReader br=new BufferedReader(new FileReader(f));
        String pass=br.readLine();
        String userName=br.readLine();
        PrintWriter pw=new PrintWriter( new FileWriter(f));
        System.out.print(printSpaces()+"*  Enter New Passworld-:");
        String passworldInput=input.next();
        System.out.print(printSpaces()+"*  Enter New User Name-:");
        String userNameInput=input.next();
        f.delete();
        br.close();



        System.out.println(printSpaces()+printSpaces()+"       You new passworld: \033[1m\033[4m"+passworldInput+"\033[0m    |   You new User Name: \033[1m\033[4m"+userNameInput+"\033[0m");
        System.out.println();
        System.out.print(printSpaces()+"*  Do you want to save changes(Yes/No)-:");
        String choice=input.next();

        int j=0;
        do {
            if (j!=0){
                System.out.print(printSpaces()+"Enter Yes/No  -:");
                choice=input.next();
            }
            j++;
            choice=choice.toLowerCase();
        }while (!(choice.equals("yes")) && !(choice.equals("no")));


        System.out.println();
        choice=choice.toLowerCase();

        if (choice.equals("yes")){
            pw.println(passworldInput);
            pw.println(userNameInput);
            System.out.println(printSpaces()+printSpaces()+"          ****Password Changed(✔️️)****");
            System.out.println();
            pw.close();
        }else {
            pw.println(pass);
            pw.println(userName);
            System.out.println(printSpaces()+printSpaces()+"       **** Password Not Changed(\u274C) ****");
            System.out.println();
            pw.close();
        }

    }
    public static void addCatagorey() throws Exception{
        System.out.println(printSpaces()+printSpaces()+"         \033[1m\033[4m      A D D  C A T E G O R E Y(\uD83D\uDCDD)     \033[0m");
        System.out.println();
        Scanner sc=new Scanner(System.in);
        Scanner sc1=new Scanner(System.in);

        File f=new File(CataGorey_path);
        ArrayList<String> itemList=new ArrayList<>();
        ArrayList<Integer> priceList=new ArrayList<>();
        PrintWriter pw=new PrintWriter(new FileWriter(f,true));
        BufferedWriter br=new BufferedWriter(pw);
        System.out.print(printSpaces()+"*  Add Categorey name-:");
        String catagorey= sc1.nextLine();
        catagorey=getValueOnly_In_latters(catagorey);//a****************************************This confirm that omly are Latters
        boolean condition=true;
        int i=1;
        do {
            System.out.print(printSpaces()+"*  Add "+i+" item name-:");
            String item= sc1.nextLine();
            item=getValueOnly_In_latters(item);//a****************************************This confirm that omly are Latters
            itemList.add(item);
            System.out.print(printSpaces()+"*  Add "+i+" item price-:");
            //            ******************Exception Handling
            String s=input.next();
            s=getValueOnly_In_numbers(s);//a****************************************This confirm that omly are Numbers
            int price= checkNum(s);
            //            ******************Exception Handling
            priceList.add(price);
            System.out.println(printSpaces()+"                    \033[1m\033[4m   Add more Categorey (Yes/No)-: \033[0m");
            String c=sc1.nextLine();

            int j=0;
            do {
                if (j!=0){
                    System.out.print(printSpaces()+"Enter Yes/No  -:");
                    c=input.next();
                }
                j++;
                c=c.toLowerCase();
            }while (!(c.equals("yes")) && !(c.equals("no")));

            i++;
            c=c.toLowerCase();
            if (c.equals("no"))
                condition=false;

        }while (condition);

        String concat=catagorey+',';
        for (int j=0;j<priceList.size();j++){
            String str="";
            if (j==0)
                str=itemList.get(j)+'('+priceList.get(j)+')';
            else
                str='_'+itemList.get(j)+'('+priceList.get(j)+')';

            concat+=str;
        }
        concat+='.';

//        System.out.println(concat);
//        System.out.println("1........Yes");
//        System.out.println("2........No");
//        String ch=input.next();
//        int cal=checkNum(ch);
//        cal=numInrangeCheck(cal,0,2);

        pw.println(concat);
        br.flush();
        br.close();
        pw.flush();
        pw.close();
    }


    //****************************************************************************************************Delete Catagorey
    public static void deleteCatagorey() throws Exception{
        ArrayList<ArrayList> itemsArraysList= retrieveDatafromFilesINArraylist();
        ArrayList<ArrayList> priceArrayList=priceList();
        ArrayList<String> catagoreyList=catagaroyListFromFile();






        System.out.println(printSpaces()+"\033[1m\033[42m\033[4m                                D E L E T E  C A T E G O R E Y                                  \033[0m");
        System.out.println();
        for (int i=0;i<catagoreyList.size();i++){
            int n=i+1;
            System.out.printf(printSpaces()+"*    %-5d  %-14s   *\n",n,catagoreyList.get(i));
        }
        System.out.printf(printSpaces()+"*    %-5d  %-14s\uD83D\uDD19 *",catagoreyList.size()+1,"Exit");

        //            ******************Exception Handling
        String s=input.next();
        int n=checkNum(s);
        n=numInrangeCheck(n,0,catagoreyList.size()+1);
        if (n==catagoreyList.size()+1){
            System.out.println("                                              \033[4m        C A T E G O R E Y  N O T  D E L E T E D(\u274C)        \033[0m");
            System.out.println();
            return;
        }
        delcatagorey(n-1);

        //            ******************Exception Handling

    }
    public static void delcatagorey(int n) throws Exception{
        ArrayList<ArrayList> itemsArraysList= retrieveDatafromFilesINArraylist();
        ArrayList<ArrayList> priceArrayList=priceList();
        ArrayList<String> catagoreyList=catagaroyListFromFile();

        File f=new File(CataGorey_path);

        PrintWriter pw=new PrintWriter(new FileWriter(f));
        BufferedWriter br=new BufferedWriter(pw);
        itemsArraysList.remove(n);
        priceArrayList.remove(n);
        catagoreyList.remove(n);

        System.out.println();


        for (int i=0;i<catagoreyList.size();i++){
            ArrayList<String> stringArray=itemsArraysList.get(i);
            ArrayList<Integer> integerList=priceArrayList.get(i);

            String line=catagoreyList.get(i)+',';
            for (int j=0;j<integerList.size();j++){
                String str="";
                if (j==0)
                    str=stringArray.get(j)+'('+integerList.get(j)+')';

                else
                    str='_'+stringArray.get(j)+'('+integerList.get(j)+')';
                line+=str;
            }
            line+='.';
            pw.println(line);
        }
        pw.flush();
        pw.close();
        System.out.println("                                              \033[4m        C A T E G O R E Y  D E L E T E D(✔️️)        \033[0m");
        System.out.println();

    }
}