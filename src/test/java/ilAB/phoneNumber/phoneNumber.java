package ilAB.phoneNumber;

import java.util.Random;

public class phoneNumber {

    public String number(){

        //object
        Random rand = new Random();


        int firstNum = 0;
        int[] carrierId = {6,7,8};
        int afterCarrierId = rand.nextInt(10);
        int randomIndexForCarrierId = rand.nextInt(carrierId.length);
        String first3 = firstNum + "" + carrierId[randomIndexForCarrierId] + "" + afterCarrierId;


        int upperBoundForSecondThree = 1000;
        int second3 =  rand.nextInt(upperBoundForSecondThree);

        int upperBoundForLastFour = 10000;
        int last4 = rand.nextInt(upperBoundForLastFour);


        String phoneNum = first3 + " " + second3 + " " + last4;


        return phoneNum;  //return 10 digits num

    }

}
