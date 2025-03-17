import java.util.Arrays;

public class Happy {
    public static long sumOfDigitsSquared(long n) {
        long sum = 0;
        while (n > 0) {
            long digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;

    }

    public static boolean isHappy(long n) {
        long num = n;
        while (num != 1 && num != 4) {
            num = sumOfDigitsSquared(num);
        }
        return num == 1;
    }

    public static long[] firstK(int k){
        long[] resultArray = new long[k];
        int HappyNum = 1;
        int index = 0;
        while (index < k){
            if (isHappy(HappyNum)){
                resultArray[index] = HappyNum;
                index ++;
            }
            HappyNum++;

            }
        return resultArray;

    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(firstK(11)));
    }
}