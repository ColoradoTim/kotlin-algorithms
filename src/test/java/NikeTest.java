import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.*;

public class NikeTest {
    @Test
    public void nikeDaysOfWeek() {
        System.out.println(new Nike().solution("Sun", 24));
    }

    @Test
    public void nikeSort() {
        System.out.println(new Nike().solution("SMLMLSMSLMSLM"));
    }
}


class Nike {
    public String solution(String T) {
        String[] array = T.split("");
        Arrays.sort(array, new Sorter());

        return String.join("", array);
    }


    private final String[] array = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    public String solution(String S, int K) {
        List<String> list = asList(array);
        if (K == 0) {
            return S;
        }

        int delta = K % 7;

        int currIndex = list.indexOf(S);
        if (currIndex + delta <= 6) {
            return array[currIndex + delta];
        } else {
            return array[currIndex + delta - 7];
        }
    }

    public static void main(String[] a) {
        System.out.println(new Nike().solution("Sun", 24));
        System.out.println(new Nike().solution("LSMLMLSMSLMSLM"));
    }
}


class Sorter implements Comparator<String> {
    static List<String> list = new ArrayList<>();

    static {
        list.add("S");
        list.add("M");
        list.add("L");
    }

    @Override
    public int compare(String o1, String o2) {
        if (o1.equals(o2)) return 0;
        int index1 = list.indexOf(o1);
        int index2 = list.indexOf(o2);

        if (index1 > index2) return 1;
        else return -1;
    }
}

