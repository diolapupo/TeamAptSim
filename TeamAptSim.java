import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class TeamAptSim{

    private static int mtn = 0;
    private static int airtel = 0;
    private static int glo = 0;
    private static int nineMobile = 0;
    private static int mtel = 0;

    static void readFile(String file){

        String PhoneNum = "";
        String NetworkId = "";

        try
        {
            
            FileInputStream fis = new FileInputStream(file);
            Scanner sc = new Scanner(fis);

            while(sc.hasNextLine())
            {
                PhoneNum = sc.nextLine();
                NetworkId = PhoneNum.substring(0,4);
			    checkPhoneNum(PhoneNum, NetworkId);
            }

            sc.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    static void checkPhoneNum(String PhoneNum, String phoneId){

        List<String> mtnId = Arrays.asList("0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","0702","0704");
        List<String> airtelId = Arrays.asList("0701","0708","0802","0808","0812","0901","0902","0904","0907","0912");
        List<String> gloId = Arrays.asList("0705","0805","0807","0811","0815","0905","0915");
        List<String> nineMobileId = Arrays.asList("0809","0817","0818","0909","0908");
        List<String> mtelId = Arrays.asList("0804");

        if(mtnId.contains(phoneId)){
            mtn += 1;
        }
        else if (airtelId.contains(phoneId)){
            airtel += 1;
        }
        else if(gloId.contains(phoneId)){
            glo += 1;
        }
        else if(nineMobileId.contains(phoneId)){
            nineMobile += 1;
        }
        else if(mtelId.contains(phoneId)){
            mtel += 1;
        }

    }

    public static void main(String args[]){
		
	int sum;

        TeamAptSim.readFile("PhoneNumbers.txt");

        System.out.println("The number MTN phone numbers is: " + mtn);
        System.out.println("The number AIRTEL phone numbers is" + airtel);
        System.out.println("The number GLO phone numbers is" + glo);
        System.out.println("The number 9Mobile phone numbers is" + nineMobile);
        System.out.println("The number MTEL phone numbers is" + mtel);
		
	sum = mtn + glo + airtel + nineMobile +mtel;
		
	System.out.println("Total numbers available: " + sum); 
    }
}
