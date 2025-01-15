import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static boolean[] pick;
    static int[] recheck;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        pick = new boolean[N];
        recheck = new int[N];

        back(0);
        bw.close();
    }

    public static void back(int picks) throws IOException {
        if (picks == N) {
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!pick[i]) {
                pick[i] = true;
                recheck[picks] = i;
                back(picks + 1);
                pick[i] = false;
            }
        }
    }

    public static void print() throws IOException {
        for(int i = 0; i < N; i++) {
            bw.write((recheck[i] + 1) + " ");
        }
        bw.write("\n");
    }
}
