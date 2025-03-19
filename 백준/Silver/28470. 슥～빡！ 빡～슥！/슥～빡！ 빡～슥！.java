import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] A, B;
    static double[] K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        K = new double[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            K[i] = Double.parseDouble(st.nextToken());
        }

        long result = 0;
        for(int i = 0; i < N; i++) {
            int KA = A[i] * (int)(K[i] * 10) / 10;
            int KB = B[i] * (int)(K[i] * 10) / 10;

            if (K[i] >= 1) {
                result += KA - B[i];
            }
            else {
                result += A[i] - KB;
            }
        }
        System.out.println(result);
    }
}