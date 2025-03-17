public class Last {
    public static Integer binarySearchLast(int[] a, int k){
        Integer result = null;
        int low =0;
        int high = a.length-1;

        while(low <= high){
            int mid = (low + high)/2;

            if(a[mid] == k){
                result = mid;
                low = mid + 1;
            }
            else if(a[mid] < k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 2)); //3
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 0)); //null
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 4, 5}, 5)); //5
    }
}
