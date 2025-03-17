import java.math.BigInteger;

public class Fib {
    public static int firstDigit(int n) {
        BigInteger previous= BigInteger.ONE;
        BigInteger current = BigInteger.ONE;
        int index = 2;
        while(current.toString().length() < n){
            BigInteger next = current.add(previous);
            previous = current;
            current = next;
            index = index +1;

        }
        return index;

    }
    public static void main(String[] args) {
        System.out.println(firstDigit(3));
    }
}
