public class MinMax {
    public static double minMaxAverage(int[] numbers) {
        if (numbers.length == 1) {
            return 0;
        }
        int myMin = 0;
        int myMax = 0;
        int current;

        //for even
        if(numbers.length % 2 ==0 ) {
            if (numbers[0] < numbers[1]) {
                myMin = numbers[0];
                myMax = numbers[1];
            } else {
                myMin = numbers[1];
                myMax = numbers[0];
            }
            current = 2;
        }else{
            myMin=numbers[0];
            myMax=numbers[0];
            current = 1;
        }
        while (current < numbers.length) {
            int firstNum = numbers[current];
            int nextNum = numbers[current+1];

            if(firstNum<nextNum) {
                if (firstNum < myMin) {
                    myMin = firstNum;
                }
            }
            if(nextNum > myMax) {
                myMax = nextNum;
            }
            else{
                if(nextNum < myMin) {
                    myMin = nextNum;
                }
                if(firstNum > myMax) {
                    myMax = firstNum;
                }
            }
            current = current + 2;


        }
        if(current == numbers.length - 1) {
            int lastNum = numbers[current];

            if (lastNum < myMin) {
                myMin = lastNum;
            }
            if(lastNum > myMax) {
                myMax = lastNum;
            }
        }
        return (myMin + myMax) / 2.0;
    }
    public static void main(String[] args) {
        int[] even= {2,3,4,1,5,6,7,8}; //even
        System.out.println(minMaxAverage(even));

        int[] odd ={1,2,3,4,5};//odd
        System.out.println(minMaxAverage(odd));
    }
}

//subtask II
/*
Instead of comparing each element individually to both Minimum and Maximum number, which would take 2 comparison
for each element. Using a paring methode will decrease the number of comparisons by comparing two element at the time.For
each pair we only need 3 comparison instead of 4(2for each element).

For even array:
-The total comparison per pair is 3,
- I did n/2 pair
-Therefore, the total number of comparison would be 3n/2

For odd array:
-I perform 1 comparison for first two element.
-The total comparison per pair is 3, then we process (n-1) elements in pair
making (n-1)/2 pair.
-Lastly, I make 2 comparison for the left over
-Total comparison = 1+3(n-1)/2 +2 which is less than 3n/2
 */



