package ilAB.phoneNumber;

import java.util.Random;

public class phoneNumber {

    public String number(){


        Random number = new Random();


        int firstNum = 0;
        int[] carrierId = {6,7,8};
        int afterCarrierId = number.nextInt(10);
        int randomIndexForCarrierId = number.nextInt(carrierId.length);
        String first3 = firstNum + "" + carrierId[randomIndexForCarrierId] + "" + afterCarrierId;


        int upperBoundForSecondThree = 1000;
        int second3 =  number.nextInt(upperBoundForSecondThree);

        int upperBoundForLastFour = 10000;
        int last4 = number.nextInt(upperBoundForLastFour);


        String phoneNum = first3 + " " + second3 + " " + last4;


        return phoneNum;

    }

}
