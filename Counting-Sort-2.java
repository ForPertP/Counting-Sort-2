import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingSort' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> countingSort(List<Integer> arr) {
        if (arr.isEmpty()) return arr;

        int max = Collections.max(arr);
        int min = Collections.min(arr);
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[arr.size()];

        for (int num : arr)
            count[num - min]++;

        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        for (int i = arr.size() - 1; i >= 0; i--) {
            int num = arr.get(i);
            output[count[num - min] - 1] = num;
            count[num - min]--;
        }

        List<Integer> sorted = new ArrayList<>();
        for (int num : output)
            sorted.add(num);

        return sorted;
    }
}
