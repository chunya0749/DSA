public class Rank {

    public static int rank(int[] A, int[] B, int e) {
        int rankA = BinarySearch(A, 0, A.length, e);
        int rankB = BinarySearch(B, 0, B.length, e);
        return rankA+rankB;
    }

    public static Integer select(int[] A, int[] B, int k) {
        int size = A.length + B.length - 1;
        if (size < k || k < 0) {
            return null;
        } else {

            int rankEltA = selectSearch(A, B, k, 0, A.length - 1, A);
            if (rankEltA > -1) {
                return rankEltA;
            } else return selectSearch(A, B, k, 0, B.length - 1, B);
        }
    }

    public static int BinarySearch(int[] m, int L, int H, int k) {
        if (H == L) return L;
        int middleEle = (H + L) / 2;
        if (m[middleEle] < k) {
            return BinarySearch(m, middleEle + 1, H, k);
        } else {
            return BinarySearch(m, L, middleEle, k);
        }
    }


    public static int selectSearch(int[] arrayA, int[] arrayB, int k, int low, int high, int[] searching) {
        while (low < high) {
            int middleEle = (high + low) / 2;
            int midRank = rank(arrayA, arrayB, searching[middleEle]);

            if (midRank < k) {
                low = middleEle + 1; // right half
            } else {
                high = middleEle; //  left half
            }
        }
        if (rank(arrayA, arrayB, searching[low]) == k) {
            return searching[low];
        } else {
            return -1;
        }

    }

    public static void main(String[] args) {


        int[] C = {10, 21, 32};
        int[] B = {11, 15, 40};

        System.out.println(Rank.select(C, B, 0)); // Output: 10
        System.out.println(Rank.select(C, B, 5)); // Output: 40
        System.out.println(Rank.select(C, B, 6)); // Output: NULL
    }
}
