import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }

        wornl(N, 1, 1);
        bw.flush();
    }

    public static void wornl(int N, int X, int Y) throws IOException {
        int checkPoint = arr[X][Y];

        boolean sameCheck = true;
        for (int i = X; i < X + N; i++) {
            for (int j = Y; j < Y + N; j++) {
                if (arr[i][j] != checkPoint) {
                    sameCheck = false;
                    break;
                }
            }
            if (!sameCheck) {
                break;
            }
        }

        if (sameCheck) {
            bw.write(checkPoint + "");
        } else {
            int sliceN = N / 2;
            bw.write("(");
            wornl(sliceN, X, Y);
            wornl(sliceN, X, Y + sliceN);
            wornl(sliceN, X + sliceN, Y);
            wornl(sliceN, X + sliceN, Y + sliceN);
            bw.write(")");
        }
    }
}
