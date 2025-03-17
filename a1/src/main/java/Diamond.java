public class Diamond {
    public static void printDiamond(int k) {
        // Upper of diamond
        for (int i = 1; i <= k; i++) {
            // left-side
            for (int j = 0; j <= k - i; j++) {
                System.out.print("#");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            // right-side
            for (int j = 0; j <= k - i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }

        // Lower of diamond
        for (int i = k - 1; i >= 1; i--) {
            // left-side
            for (int j = 0; j <= k - i; j++) {
                System.out.print("#");
            }
            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            //right-side
            for (int j = 0; j <= k - i; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printDiamond(4);
    }
}
