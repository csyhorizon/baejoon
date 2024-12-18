import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static HashSet<Character> hashSet = new HashSet<>();
    static ArrayList<Character> arr;

    static StringTokenizer st;
    static int size, N;

    public static void main(String[] args) throws IOException {
        // size = 조합의 수 4, N = 단어의 수 6, 중복 X
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 단어 가져오기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hashSet.add(st.nextToken().charAt(0));
        }
        arr = new ArrayList<>(hashSet);
        Collections.sort(arr);

        // 여기까지 O(n) * 3
        findValue(new Vector<>(), size, 0, 0, 0);
        bw.close();
    }

    // 모음, 자음..
    static void findValue(Vector<String> vector, int toPick, int now, int m, int j) throws IOException {
        if (toPick == 0) {
            if (m >= 1 && j >= 2) {
                bw.write(String.join("", vector) + "\n");
            }
            return;
        }

        for (int i = now; i < arr.size(); ++i) {
            vector.add(String.valueOf(arr.get(i)));
            int mplus = arr.get(i) == 'a' || arr.get(i) == 'e' || arr.get(i) == 'i'
                        || arr.get(i) == 'o' || arr.get(i) == 'u' ? 1 : 0;
            int jplus = mplus == 0 ? 1 : 0;
            findValue(vector, toPick - 1, i + 1, m + mplus, j + jplus);
            vector.remove(vector.size() - 1);
        }
    }
}
