import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

public class Solutions {
    //There will be temporary variables for recursive functions
    static int temp1 = 0;

    public static void problem1(){
        final int MAXVAL = 1000;//Sett  ing the max value
        int count = 0;//The sum that is counted
        for(int i = 3; i < MAXVAL; i += 3){
            count += i;//We add all the numbers that are multiple of 3
        }
        for(int i = 5; i < MAXVAL; i += 15){
            count += i;//We add all the numbers multiple of 5 EXCLUDING those that are divisible by both 5 and 3
        }
        for(int i = 10; i < MAXVAL; i+= 15){
            count += i;
        }
        System.out.println("The sum is equal to " + count);
    }

    public static void problem2(){
        final int MAX = 4 * (int)Math.pow(10, 6);
        int prev1 = 0;
        int prev2 = 1;
        int current = 0;
        int count = 0;//The current sum
        while(current < MAX){//Enumerating through all fibonacci numbers that are smaller than 4 million
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
            if(current % 2 == 0){//Add to the count if it is even
                count += current;
            }
        }
        System.out.println("The sum is " + count);
    }

    public static void problem3(){
        long val = 600851475143L;//THe number we want
        int divisor = 2;
        long holder = 1;
        ArrayList<Long> arr = new ArrayList<>();//To hold the products(not needed)
        while(divisor < val){
            if(val % divisor == 0){//while it is possible to be divided we try to find a number we can divide
                arr.add((long)divisor);
                if(divisor % 2 == 1){
                    holder = divisor;
                }
                val = val / divisor;
            }else{
                divisor++;
            }
        }
        holder = (holder > val) ? holder : val;//Seeing if the remainder is bigger than our biggest divisor
        System.out.println("The biggest prime factor is " + holder);
        System.out.println(arr + " " + val);
    }

    public static void problem4(){
        String retVal = "0";
        int[] products = new int[2];
        int len = 0;
        for(int i = 999; i >= 1; i--){//Testing all possible numbers
            for(int j = 999; j >= 1; j--){
                String val = String.valueOf(i * j);
                len = val.length();
                String temp = new String();
                for(int z = len - 1; z >= 0; z--){//reversing the number
                    temp += val.substring(z, z + 1);
                }
                if(temp.equals(val) && Integer.valueOf(val) > Integer.valueOf(retVal)){//if it is pallindrome and bigger than current
                    products[0] = i;
                    products[1] = j;
                    retVal = val;
                }
            }
        }
        System.out.println("The value is " + retVal);
        System.out.println("And consists of " + products[0] + " " + products[1]);
    }
    public static void problem5(){
        //We will multiply all numbers from 1 to 20 EXCLUDING every number that can me
        //a product of a bigger one etc we will use 20 so
        //If it is divisable by 20 then it also is by 10, 5, 4, 2
        //19, 17, 13 and 11 are prime numbers
        //if it is divisable by 18 then it also is by 9, 6, 3 and 2
        //if it is divisable by 16 then it also is by 8, 4, 2 and 1
        //if it is divisable by 15 then it also is by 5 and 3
        //if it is divisable by 14 then it also is by 7
        //if is divisable by 12 then it also is by 6, 4, 2 and 113
        int val = 2520;
        while(true){
            if(val % 20 == 0 && val % 19 == 0 && val % 18 == 0 && val % 17 == 0 & val % 16 == 0 && val % 15 == 0 && val % 14 == 0 && val % 13 == 0 && val % 12 == 0 && val % 11 == 0){
                break;
            }
            val++;
        }
        System.out.println("The number is " + val);
    }

    public static void problem6(){
        final int MAXVAL = 100;
        int val1 = 0;
        int val2 = 0;
        for(int i = 1; i <= MAXVAL; i++){//Calculating the sum of powers
            val1 += (int)Math.pow(i, 2);
            val2 += i;
        }
        val2 = (int)Math.pow(val2, 2);//Calculating the power of sums
        int diff = val2 - val1;
        System.out.println("The difference is " + diff);
    }

    public static void problem7(){
        long val = 0L;
        int primes = 4;//We skip 2, 3, 5 and 7 prime numbers
        long currentNum = 11;//straight to the next know prime number
        while(true){
            boolean isPrime = true;
            for(int i = 3; i <= Math.sqrt(currentNum); i = i + 2){//Check if is prime
                if(currentNum % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){//If prime increase amount
                primes++;
            }
            if(primes >= 10001){
                val = currentNum;
                break;
            }
            currentNum = currentNum + 2;//Skipping even numbers by adding 2 instead of one
        }
        System.out.println("The number is " + val);
    }
    public static void problem8(){
        long max = Long.MIN_VALUE;
        String val = "73167176531330624919225119674426574742355349194934";
        val += "96983520312774506326239578318016984801869478851843";
        val += "85861560789112949495459501737958331952853208805511";
        val += "12540698747158523863050715693290963295227443043557";
        val += "66896648950445244523161731856403098711121722383113";
        val += "62229893423380308135336276614282806444486645238749";
        val += "30358907296290491560440772390713810515859307960866";
        val += "70172427121883998797908792274921901699720888093776";
        val += "65727333001053367881220235421809751254540594752243";
        val += "52584907711670556013604839586446706324415722155397";
        val += "53697817977846174064955149290862569321978468622482";
        val += "83972241375657056057490261407972968652414535100474";
        val += "82166370484403199890008895243450658541227588666881";
        val += "16427171479924442928230863465674813919123162824586";
        val += "17866458359124566529476545682848912883142607690042";
        val += "24219022671055626321111109370544217506941658960408";
        val += "07198403850962455444362981230987879927244284909188";
        val += "84580156166097919133875499200524063689912560717606";
        val += "05886116467109405077541002256983155200055935729725";
        val += "71636269561882670428252483600823257530420752963450";
        int len = val.length();
        for(int i = 0; i < len - 13; i++){//For each 13 products moving one by one
            long tempVal = 1;
            for(int j = i; j < i + 13; j++){//Calculating sum
                tempVal = tempVal * Long.valueOf(val.substring(j, j + 1));
            }
            if(tempVal > max){//If bigger than curret Max we update max
                max = tempVal;
            }
        }
        System.out.println("The biggest number is " + max);
    }

    public static void problem9(){
        int a = 1;
        int b = 1;
        double c = 0;
        boolean found = false;
        while(!found){
            c = Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)));//Getting C
            double val = a + b + c;
            if(val == 1000){//If we found the triplet
                found = true;
                break;
            }
            if(val < 1000){//increase 2nd number if val < 1000
                b++;
            }else{
                b = 1;//reset and try again with bigger a
                a++;
            }
        }
        System.out.println("The triplet is " + a + " " + b + " " + c);
        System.out.println("And the product is " + a * b * (int)c);
    }

    public static void problem10(){
        long count = 17;//Starting with 2, 3, 5, 7 found
        for(long i = 11; i <= 2000000; i = i + 2){//Skipping all even numbers as they can be divided by 2
            boolean prime = true;
            for(long j = 3; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    prime = false;
                    break;
                }
            }
            if(prime){
                count+= i;
            }
        }
        System.out.println("The final sum is " + count);
    }

    public static void problem11() throws Exception{
        //First we will read and filter the input
        String site = "https://projecteuler.net/minimal=11";
        String val = "";
        int[][] table = new int[20][20];
        
        URL url = new URL(site);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String input;
        int line = 1;
        while((input = in.readLine()) != null && line <= 22){
            if(line >= 9 && line <= 12){
                input = input.replace("<span class=\"red\"><b>", "");
                input = input.replace("</b></span>", "");
            }
            if(line > 2){
                val = val + input.replaceAll("<br>", " ");

            }
            line++;
        }
        in.close();
        System.out.println(val);
        val.replaceAll("br", "");
        //System.out.println(val);
        int curLen = 0;
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){
                table[i][j] = Integer.valueOf(val.substring(curLen, curLen + 2));
                curLen = curLen + 3;
            }
        }


        int max = Integer.MIN_VALUE;
        
        //Now we find the biggest product available
        for(int i = 0; i < 20; i++){
            for(int j = 0; j < 20; j++){

                if(j <= 16){//Downwards product
                    int tempVal = table[i][j] * table[i][j + 1] * table[i][j + 2] * table[i][j + 3];
                    if(tempVal > max){
                        max = tempVal;
                    }

                    if(i <= 16){//downwards right product
                        tempVal = table[i][j] * table[i + 1][j + 1] * table[i + 2][j + 2] * table[i + 3][j + 3];
                        if(tempVal > max){
                            max = tempVal;
                        }
                    }

                    if(i >= 3){//downwards left product
                        tempVal = table[i][j] * table[i - 1][j + 1] * table[i - 2][j + 2] * table[i - 3][j + 3];
                        if(tempVal > max){
                            max = tempVal;
                        }
                    }
                }

                if(j >= 3){//upwards product
                    int tempVal = table[i][j] * table[i][j - 1] * table[i][j - 2] * table[i][j - 3];
                    if(tempVal > max){
                        max = tempVal;
                    }

                    if(i <= 16){//upwards right product
                        tempVal = table[i][j] * table[i + 1][j - 1] * table[i + 2][j - 2] * table[i + 3][j - 3];
                        if(tempVal > max){
                            max = tempVal;
                        }
                    }

                    if(i >= 3){
                        tempVal = table[i][j] * table[i - 1][j - 1] * table[i - 2][j - 2] * table[i - 3][j - 3];
                        if(tempVal > max){
                            max = tempVal;
                        }
                    }
                }

                if(i <= 16){
                    int tempVal = table[i][j] * table[i + 1][j] * table[i + 2][j] * table[i + 3][j];
                    if(tempVal > max){
                        max = tempVal;
                    }
                }

                if(i >= 3){
                    int tempVal = table[i][j] * table[i - 1][j] * table[i - 2][j] * table[i - 3][j];
                    if(tempVal > max){
                        max = tempVal;
                    }
                }

            }
        }
        System.out.println("The max value is " + max);
    }

    public static void problem12(){
        //We will check each number individually to see if it has
        //at least 500 divisors
        int divisors = 0;
        boolean numFound = false;
        int currentNum = 1;
        int increment = 2;
        while(!numFound){
            divisors = 2;
            currentNum += increment;
            increment++;
            int div = 2;
            int temp = currentNum;
            while(temp > div){
                if(temp % div == 0){
                    divisors++;
                    temp = temp / div;
                }else{
                    div++;
                }
            }

            if(divisors > 500){
                numFound = true;
            }
        }
        System.out.println("The number is " + currentNum);
    }

    public static void problem13() throws Exception{
        //first we read and filter the input
        String site = "https://projecteuler.net/minimal=13";
        String input = "";
        String numbers = "";
        URL url = new URL(site);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));
        int line = 1;
        while((input = in.readLine()) != null){
            if(line >= 3){
                numbers += input;
            }
            line++;
        }
        in.close();
        numbers = numbers.replaceAll("<br>", "");
        numbers = numbers.replace("</div>", "");
        System.out.println(numbers + " " + numbers.length());
        //Now we will save the number whole sum here
        //and we will add each number to its respective array position
        int[] finalNum = new int[152];
        for(int i = 0; i < numbers.length(); i = i + 50){
            for(int j = 0; j < 50; j++){
                finalNum[49 - j] = finalNum[49 - j] + Integer.valueOf(numbers.substring(i + j, i + j + 1));
            }
        }

        //Now we normalize the array
        for(int i = 0; i < finalNum.length - 1; i++){
            finalNum[i + 1] = finalNum[i + 1] + finalNum[i] / 10;
            finalNum[i] = finalNum[i] % 10;
        }
        String answer = "";
        //Lastly we convert the final product to a string
        //and we hold the first 10 non zero numbers
        for(int i = 0; i < finalNum.length; i++){
            answer = finalNum[i] + answer;
        }
        while(answer.substring(0, 1).equals("0")){
            answer = answer.substring(1);
        }
        answer = answer.substring(0, 10);
        System.out.println(answer);
    }

    public static void problem14(){
        final int  limit = 1000000;
        //We create an array that will hold all previous number
        //values so we minimize function repetition for already
        //found numbers
        int[] cache = new int[1000000];
        int max = Integer.MIN_VALUE;
        int savedVal = 0;
        //Now we check each number individually
        for(int i = 3; i < limit; i++){
            System.out.println(i);
            int count = 0;
            long val = i + 0;
            while(val != 1){
                if(val < 1000000){
                    if(cache[(int)val] != 0){
                    count+= cache[(int)val];
                    break;
                    }
                }
                if(val % 2 == 0){
                    val = val / 2;
                }else{
                    val = 3 * val + 1;
                }
                count++;
            }
            cache[i] = count;
            if(count > max){
                max = count;
                savedVal = i;
            }
        }
        System.out.println("Number " + savedVal + " with count " + max);
    }

    public static void problem15(){
        //In order to calculate the number of routes we can do the following:
        //as we need to get to position x=20 y=20 we can calculate the number
        //routes there are to get the adjacent available tiles and add them
        //So all we need to do is create an array with all the tiles that x = 0 or y = 0
        //to be 1 and then calculate the other positions by adding the know adjacent tiles
        //This problem took me a couple of times as recursion methods are simply too proccesing heavy
        //It reminds me of the Pascal's Triangle
        final int arrX = 21;
        final int arrY = 21;
        //We first initiate the array
        long[][] arr = new long[arrY][arrX];
        //then we fill its upper and left sides with 1's
        for(int i = 0; i < arrX; i++){
            arr[0][i] = 1;
        }
        for(int j = 0; j < arrY; j++){
            arr[j][0] = 1;
        }
        //Now we set each tile's number equivalent to the sum
        //of this above and left
        for(int i = 1; i < arrX; i++){
            for(int j = 1; j < arrY; j++){
                arr[j][i] = arr[j - 1][i] + arr[j][i - 1];
            }
        }
        long answer = arr[arrY - 1][arrX - 1];
        System.out.println("The number is " + answer);
    }
}
