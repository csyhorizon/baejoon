import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int[] ck = new int[2];
    static boolean cked;
    static int R, C, T;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        // 기본 배열 생성
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 공기 청정기 체크
                if (arr[i][j] == -1) {
                    if (!cked) {
                        ck[0] = i;
                        cked = true;
                    }
                    else {
                        ck[1] = i;
                    }
                }
            }
        }

        // T만큼 반복
        for (int i = 0; i < T; i++) {
            // 1. 미세먼지 확산
            arr = dirtyWindy();
            // 2. 공기 청정기 작동
            clearWindy();
        }

        // 전체 합 출력
        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] > 0) result += arr[i][j];
            }
        }
        System.out.println(result);
    }

    static void clearWindy() {
        int top = ck[0];
        int bottom = ck[1];
        // 우 -> 상 -> 좌 -> 하
        for (int x = top - 1; x > 0; x--) {
            arr[x][0] = arr[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[0][y] = arr[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            arr[x][C - 1] = arr[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[top][y] = arr[top][y - 1];
        }
        arr[top][1] = 0;

        // 우 -> 하 -> 좌 -> 상
        for (int x = bottom + 1; x < R - 1; x++) {
            arr[x][0] = arr[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[R - 1][y] = arr[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            arr[x][C - 1] = arr[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[bottom][y] = arr[bottom][y - 1];
        }
        arr[bottom][1] = 0;
    }

    static int[][] dirtyWindy() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        // 재작성 방지
        int[][] result = new int[R][C];

        // 확산 범위 생성
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                result[i][j] = arr[i][j];
                if (arr[i][j] > 0) {
                    q.add(new int[] {i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] aa = q.removeFirst();
            int i = aa[0];
            int j = aa[1];

            int pp = arr[i][j] / 5;
            // 4방향 체크
            for (int k = 0; k < 4; k++) {
                int xx = dx[k] + i;
                int yy = dy[k] + j;

                if(xx >= 0 && yy >= 0 && xx < R && yy < C) {
                    if (arr[xx][yy] >= 0) {
                        result[xx][yy] += pp;
                        result[i][j] -= pp;
                    }
                }
            }
        }
        return result;
    }
}