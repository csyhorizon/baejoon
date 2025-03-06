import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static boolean[] one = new boolean[1001];

    public static void main(String[] args) throws Exception {
        for(int i = 1; i <= 1000; i++) {
            HashSet<Integer> set = new HashSet<>();
            int test = i % 10;
            for(int j = i / 10; j > 0;) {
                set.add(test - (j % 10));
                test = j % 10;
                j /= 10;
            }
            if (set.isEmpty() || set.size() == 1) {
                one[i] = true;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i <= test; i++) {
            if (one[i]) {
                count ++;
            }
        }
        System.out.println(count);
    }
}
