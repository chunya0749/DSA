// Subtask I answer : This function will loop n steps
public class SumEven {
    public static long sumEven(int n){
        long sum =0;
        for(int i = 0; i<n;i++){
            sum += 2L * i;
        }
        return sum;

    }
    //Subtask II:
//    public static long sumEven(int n) {
//        return (long) n*(n-1);
//}

    public static void main(String[] args) {
        System.out.println(sumEven(4));
    }
}
