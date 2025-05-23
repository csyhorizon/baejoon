import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int card = Integer.parseInt(st.nextToken());
        int hp = Integer.parseInt(st.nextToken());

        int[] arr = new int[card];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < card; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int now = 0;

        for (; now < card; now++) {
            hp -= arr[now];
            if (hp <= 0) {
                break;
            }
        }

        System.out.println(hp <= 0 ? now + 1 : "-1");
    }
}