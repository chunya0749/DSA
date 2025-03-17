import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MultiwayMerge {
    public static class CompareList implements Comparator<LinkedList<Integer>> {

        @Override
        public int compare(LinkedList<Integer> o1, LinkedList<Integer> o2) {
            if (o1.getFirst().equals(o2.getFirst())) {
                return 0; // stay the same
            } else if (o1.getFirst() > o2.getFirst()) {
                return 1; // o1 comes after o2
            } else {
                return -1; // o1 comes before o2
            }
        }
    }

    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists) {
        PriorityQueue<LinkedList<Integer>> pqList = new PriorityQueue<>(new CompareList());
        for (LinkedList<Integer> list : lists) {
            if (list.size() != 0) {
                pqList.add(list);}
        }
        LinkedList<Integer> mergeList = new LinkedList<>();

        //Merge the list
        while (!pqList.isEmpty()) {
            LinkedList<Integer> temp = pqList.poll();
            mergeList.add(temp.removeFirst());
            if (temp.size() != 0) {
                pqList.add(temp);
            }
        }
        return mergeList;

    }

}
