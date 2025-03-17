import java.util.*;
import java.util.List;


public class RPal {
    // store all the known answers, so we don't have to compute them again
    private Map<Integer, List<List<Integer>>> storageAllRPals;


    // a constructor: creates the above storage and puts in answers
    // for our base cases of n = 0 and n = 1.
    public RPal() {
        storageAllRPals = new HashMap<>();
        storageAllRPals.put(0, Arrays.asList(Arrays.asList()));
        storageAllRPals.put(1, Arrays.asList(Arrays.asList(1)));
    }

    // Specification: return a list of integer lists of all recursively
    // palindromic sequences that sum to n.
    //
    // NOTE: When you implement this and want recursively-palindromic
    // sequences of k < n, you should not call yourself. Instead, you
    // will call allRPals(k).  The difference is that computeAllRPals
    // will compute the sequences every time whereas allRPals will *not*
    // compute the answer again unless it hasn't been computed before.
    private List<List<Integer>> computeAllRPals(int n) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            int leftover = n - (2 * i);
            if (leftover >= 0) {
                List<List<Integer>> middleNum = allRPals(leftover);

                int count = 0;
                while (count < middleNum.size()) {
                    List<Integer> middle = middleNum.get(count);
                    List<Integer> Eachlist = new ArrayList<>();
                    Eachlist.add(i);
                    Eachlist.addAll(middle);
                    Eachlist.add(i);

                    if (isEqual(Eachlist)) {
                        result.add(Eachlist);
                    }

                    count++;
                }
            }
        }
        List<Integer> finalList = new ArrayList<>();
        finalList.add(n);
        result.add(finalList);

        return result;


    }


    public List<List<Integer>> allRPals(int n) {
        // Challenge: if you feel like learning a new trick, how would you
        // rewrite the following using just storageAllRPals.computeIfAbsent(..)?

        List<List<Integer>> answer = storageAllRPals.get(n);
        if (answer == null) {
            answer = computeAllRPals(n);
            storageAllRPals.put(n, answer);
        }

        return answer;
    }

    private boolean isEqual(List<Integer> list){
        int size = list.size();
        int half = size / 2;

        String firstHalf = list.subList(0, half).toString();
        String secondHalf = list.subList(size - half, size).toString();

        return (firstHalf.equals(secondHalf));
    }

    public static void main(String[] args) {
        RPal rPal = new RPal();

        System.out.println(rPal.allRPals(7));
        System.out.println(rPal.allRPals(7).size());

    }
}
