import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] arr;
    static int N, M;

    public static void main(String[] args) throws IOException {
        // 공기 접촉면이 2가 나오면 종료, 제거
        // Q 형태로 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        // 기본 배열 생성 : 치즈는 배열에 담기
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) q.addLast(new int[] {i, j, 0});
            }
        }

        // BFS 외부 공기
        airPort(new int[] {0, 0});

        int count = 0;
        ArrayDeque<int[]> removeQ = new ArrayDeque<>();

        while (!q.isEmpty()) {
            int[] ck = q.removeFirst();
            int x = ck[0];
            int y = ck[1];
            int cost = ck[2];

            if (count != cost) {
                int ckq = removeQ.size();;
                for (int i = 0; i < ckq; i++) {
                    int[] removes = removeQ.removeFirst();
                    arr[removes[0]][removes[1]] = -1;
                    airPort(removes);
                }
            }

            int ckSize = 0;
            for (int i = 0; i < 4; i++) {
                int arrX = x + dx[i];
                int arrY = y + dy[i];

                if (arr[arrX][arrY] == -1) {
                    ckSize ++;

                    if (ckSize == 2) {
                        removeQ.add(new int[] {x, y});
                        count = cost;
                        break;
                    }
                }
            }
            if (ckSize != 2) {
                q.addLast(new int[] {x, y, cost + 1});
            }
        }
        System.out.println(count + 1);
    }

    static ArrayDeque<int[]> outAir = new ArrayDeque<>();

    public static void airPort(int[] ck) {
        outAir.add(ck);
        arr[ck[0]][ck[1]] = -1;

        while (!outAir.isEmpty()) {
            int[] noo = outAir.removeFirst();
            for (int i = 0; i < 4; i++) {
                int x = noo[0] + dx[i];
                int y = noo[1] + dy[i];

                if (x >= 0 && y >= 0 && x < N && y < M && arr[x][y] == 0) {
                    arr[x][y] = -1;
                    outAir.addLast(new int[] {x, y});
                }
            }
        }
    }
}