import java.util.Arrays;

public class Subsel {
    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        if (stride == 0) {
            return new int[0];
        }
        int size = 0;
        if (stride > 0) {
            for (int i = beginWith; i < a.length; i += stride) {
                size= size+1;
            }
        } else {
            for (int i = beginWith; i >= 0; i += stride) {
                size= size+1;
            }
        }
        int[] result = new int[size];
        int index = 0;

        if (stride > 0) {
            for (int i = beginWith; i < a.length; i += stride) {
                result[index++] = a[i];
            }
        } else {
            for (int i = beginWith; i >= 0; i += stride) {
                result[index++] = a[i];
            }
        }

        return result;
    }
    public static int[] takeEvery(int[] a, int stride) {
        return takeEvery(a, stride, 0);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(takeEvery(new int[]{2, 7, 1, 8, 4, 5},3,2)));
    }

}

