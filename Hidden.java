public class Hidden {
    public static boolean isHidden(String s, String t){
        char[] ArrayOfs = s.toCharArray();
        char[] ArrayOft = t.toCharArray();

        int currentT = 0;

        for (int i = 0; i < ArrayOfs.length; i++) {
            if (ArrayOfs[i] == ArrayOft[currentT]) {
                currentT++;
            }

            if (ArrayOft.length == currentT) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHidden("VhHTdipc07","htc"));
        System.out.println(isHidden("welcometothehotelcalifornia","space"));
        System.out.println(isHidden("TQ89MnQU3IC7t6","MUIC"));
        System.out.println(isHidden("VhHTdipc07","hTc"));
    }
}
