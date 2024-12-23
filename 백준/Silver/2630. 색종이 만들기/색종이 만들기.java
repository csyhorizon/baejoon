import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int[][] arr;

    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // nSize = 현재 사이즈, nPosition
        int[] result = checkBox(N, new int[]{1, 1}, new int[]{N, N});
        System.out.println(result[0] + "\n" + result[1]);
    }

    public static int[] checkBox(int nSize, int[] start, int[] end) {
        int[] result = new int[2];
        boolean check = true;

        int ck = arr[start[0]][start[1]];
        if (nSize == 1) {
            result[ck] ++;
            return result;
        }

        for (int i = start[0]; i <= end[0]; i++) {
            for (int j = start[1]; j <= end[1]; j++) {
                if (ck != arr[i][j]) {
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }

        if (check) {
            result[ck] ++;
        }
        else {
            int resize = nSize / 2;
            int[] A = checkBox(resize, new int[]{start[0], start[1]}, new int[]{end[0] - resize, end[1] - resize});
            int[] B = checkBox(resize, new int[]{start[0] + resize, start[1]}, new int[]{end[0], end[1] - resize});
            int[] C = checkBox(resize, new int[]{start[0], start[1] + resize}, new int[]{end[0] - resize, end[1]});
            int[] D = checkBox(resize, new int[]{start[0] + resize, start[1] + resize}, new int[]{end[0], end[1]});

            result[0] += A[0] + B[0] + C[0] + D[0];
            result[1] += A[1] + B[1] + C[1] + D[1];
        }

        return result;
    }
}
