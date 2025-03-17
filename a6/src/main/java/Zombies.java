public class Zombies {
    public static int countBad(int[] hs) {
        return mergeSortAndCount(hs, 0, hs.length - 1);
    }

    public static int mergeSorted(int[] arr, int left, int mid, int right) {
        int i = 0;
        int j = 0;
        int k = left;
        int count = 0;

        int[] l = new int[mid - left + 1];
        int[] r = new int[right - mid];

        for (int index = 0; index < l.length; index++) {
            l[index] = arr[left + index];
        }

        for (int index = 0; index < r.length; index++) {
            r[index] = arr[mid + 1 + index];
        }

        int len_left = l.length;
        int len_right = r.length;

        while (i + j < len_left + len_right) {
            if (i >= len_left) { // Left end
                arr[k++] = r[j++];
            } else if (j >= len_right) { // Right end
                arr[k++] = l[i++];
            } else if (l[i] >= r[j]) {
                arr[k++] = l[i++];
            } else { // Count bad pairs
                arr[k++] = r[j++];
                count += (mid + 1) - (left + i);
            }
        }

        return count;
    }

    private static int mergeSortAndCount(int[] arr, int l, int r) {
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m); // badpair in left
            count += mergeSortAndCount(arr, m + 1, r); // bad pair Right
            count += mergeSorted(arr, l, m, r); // Merge step
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 2};
        int[] arr2 = {5, 4, 11, 7};
        int[] arr3 = {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
        int[] arr4 = {35, 22, 10};

        System.out.println(countBad(arr4)); // Output: 0
        System.out.println(countBad(arr1)); // Output: 3
        System.out.println(countBad(arr2)); // Output: 4
        System.out.println(countBad(arr3)); // Output: 49

    }
}
