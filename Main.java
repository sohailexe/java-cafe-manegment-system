import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
public class Main extends Custommer{


    public static void main(String[] args) throws Exception {
        // **********************************If Already Exist Then Remove
        System.out.println();
        File f=new File(item_path);
        File f1=new File(price_path);
        File f2=new File(pricePerQuantity_path);
        File f3=new File(quantity_path);
        if (f.exists()){
            f.delete();
        }
        if (f1.exists()){
            f1.delete();
        }
        if (f2.exists()){
            f2.delete();
        }
        if (f3.exists()){
            f3.delete();
        }
        // **********************************If Already Exist Then Remove

        int choice=-1;
        do {
            System.out.println("      * * * *   \033[1m\033[41m\033[4m                                              M A I N  P A N E L                                                 \033[0m   * * * *");
            System.out.println();
            System.out.println();
            System.out.println(printSpaces()+printSpaces()+"        \033[1m\033[41m\033[4m  S E L E C T  A  O P T I O N  \033[0m");
            System.out.println(printSpaces()+printSpaces()+"        *       1    Customer        *");
            System.out.println(printSpaces()+printSpaces()+"        *       2    Admin           *");
            System.out.println(printSpaces()+printSpaces()+"        *       3    Print BIll      *");
            System.out.println(printSpaces()+printSpaces()+"        *       4    Delete BIll     *");
            System.out.println(printSpaces()+printSpaces()+"        *       0    Exit        \uD83D\uDD19  *");
            System.out.print(printSpaces()+printSpaces()+"        \033[4m                              \033[0m");


            String s=input.next();
            choice= checkNum(s);
            choice=numInrangeCheck(choice,-1,4);
            switch (choice){
                case 1 -> {
                    customer();
                }
                case 2 -> {
//("\uD83D\uDCCE");
                    System.out.println(printSpaces()+"\033[1m\033[45m\033[4m                                L O G  I N  P A N E L (\uD83D\uDCDA)                                 \033[0m");
                    File file=new File(AdminDetail_path);
                    BufferedReader br=new BufferedReader( new FileReader(file));

                    String passFromFile= br.readLine();
                    String usernameFromFile= br.readLine();

                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.print(printSpaces()+"Enter Passworld \uD83D\uDD12 -:");
                    String passworld=input.next();

                    boolean c1=checkInformation(passFromFile,passworld,"Passworld");

                    String userName="";
                    boolean c2=false;
                    if (c1){
                        System.out.print(printSpaces()+"Enter User Name \uD83D\uDC68 -:");
                        userName=input.next();
                        c2=checkInformation(usernameFromFile,userName,"User Name");

                    }

                    if (c1 && c2){
                        adminPanel();
                    }
                }
                case 3 -> {
                    if (!f.exists()) {
//                        System.out.println("\033[4mThis text is underlined\033[0m");
                        System.out.println(printSpaces() + printSpaces() + "        \033[1m\033[42m\033[4m     Y O U R  B I L L        \033[0m");
                        System.out.println(printSpaces() + printSpaces() + "        *                            *");
                        System.out.println(printSpaces() + printSpaces() + "        * You did not have any bill  *");
                        System.out.println(printSpaces() + printSpaces() + "        *                            *");
                    } else {
                        System.out.println();
                        System.out.println(printSpaces()+"\033[1m\033[42m\033[4m                                     B I L L  P R I N T E D                                                \033[0m");
                        System.out.println(printSpaces()+"***********************************************************************************************************");
                        printBill(total);
                        System.out.println(printSpaces()+"***********************************************************************************************************");
                        System.out.println();
                    }
                }
                case 4 -> {
                    detelePreviousBill();
                    System.out.println(printSpaces() + printSpaces() + "        \033[1m\033[46m\033[4m    B I L L  D E L E T E D    \033[0m");
                    System.out.println(printSpaces() + printSpaces() + "        *                             *");
                    System.out.println(printSpaces() + printSpaces() + "         You bill Deleted Successfully ");
                    System.out.println(printSpaces() + printSpaces() + "        *                             *");
                }

            }
        }while(choice!=0);


        // **********************************       Deleting Files After Using So That BAck Data WILL remove
        if (f.exists()){
            f.delete();
        }
        if (f1.exists()){
            f1.delete();
        }
        if (f2.exists()){
            f2.delete();
        }
        if (f3.exists()){
            f3.delete();
        }


    }

    public static String[] getFileLoginDetails(String pass,String username){
        String s[]= {pass,username};
        return s;
    }

    public static void detelePreviousBill(){
        // **********************************If Already Exist Then Remove
        File f=new File(item_path);
        File f1=new File(price_path);
        File f2=new File(pricePerQuantity_path);
        File f3=new File(quantity_path);
        if (f.exists()){
            f.delete();
        }
        if (f1.exists()){
            f1.delete();
        }
        if (f2.exists()){
            f2.delete();
        }
        if (f3.exists()){
            f3.delete();
        }
    }






    public static void printBill(int totalBill) throws Exception{


        File item=new File(item_path);
        File price=new File(price_path);
        File quantity=new File(quantity_path);
        File pricePerQuantity=new File(pricePerQuantity_path);


        BufferedReader itemReader=new BufferedReader( new FileReader(item));
        BufferedReader priceReader=new BufferedReader( new FileReader(price));
        BufferedReader quantityReader=new BufferedReader( new FileReader(quantity));
        BufferedReader pricePerQuantityReader=new BufferedReader( new FileReader(pricePerQuantity));

        ArrayList<String> itemList=new ArrayList<>();
        ArrayList<Integer> priceList=new ArrayList<>();
        ArrayList<Integer> quantityList=new ArrayList<>();
        ArrayList<Integer> pricePerQuantityList=new ArrayList<>();


        String line0=itemReader.readLine();
        while (line0!=null){
            itemList.add(line0);
            line0=itemReader.readLine();
        }

        String line1=priceReader.readLine();
        while (line1!=null){
            int n=Integer.parseInt(line1);
            priceList.add(n);
            line1=priceReader.readLine();
        }

        String line2=quantityReader.readLine();
        while (line2!=null){
            int n=Integer.parseInt(line2);
            quantityList.add(n);
            line2=quantityReader.readLine();
        }

        String line3=pricePerQuantityReader.readLine();
        while (line3!=null){
            int n=Integer.parseInt(line3);
            pricePerQuantityList.add(n);
            line3=pricePerQuantityReader.readLine();
        }
        String a= "Items";
        String b="Price/tem";
        String c="Quantity";
        String d="Total";

        System.out.printf(printSpaces()+"*              %-15s | %-15s | %-15s | %-15s |                    *\n" ,a,b,c,d);
        System.out.println(printSpaces()+"*              -----------------------------------------------------------------------                    *");
        for (int i=0;i<itemList.size();i++){
            System.out.printf(printSpaces()+"*              %-15s | $%-14s | %-15s | $%-14s |                    *\n" ,itemList.get(i),pricePerQuantityList.get(i),quantityList.get(i),priceList.get(i));
        }
        System.out.println(printSpaces()+"*              -----------------------------------------------------------------------                    *");
        System.out.printf(printSpaces()+"*              %-15s   %-15s   %-15s | $%-14s |                    *\n" ,"Grand Total"," "," ",totalBill);

        itemReader.close();
        priceReader.close();
        quantityReader.close();
        pricePerQuantityReader.close();
    }

}