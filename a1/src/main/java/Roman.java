public class Roman {
    private static int translate(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static int romanToInt(String num) {
        int total = 0;

        for (int i = 0; i < num.length(); i++) {
            int currentNum = translate(num.charAt(i));

           //check range
            if (i + 1 < num.length()) {
                int nextNum = translate(num.charAt(i + 1));
                if (currentNum < nextNum) {
                    total -= currentNum;
                } else {
                    total += currentNum;
                }
            } else {
                total += currentNum;
            }
        }

        return total;
    }
    //Test
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMLIV"));
        System.out.println(romanToInt("VII"));
        System.out.println(romanToInt("MCMXC"));
    }
}
