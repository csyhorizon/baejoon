import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] notSelfNumber = new boolean[10001];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 10000; i++) {
            if (!notSelfNumber[i]) {
                bw.write(i + "\n");
            }
            while(true) {
                int ssnumber = i;
                for (int j = i; j > 0;) {
                    ssnumber += j % 10;
                    j = j / 10;
                }
                if (ssnumber > 10000) {
                    break;
                }
                if (notSelfNumber[ssnumber]) {break;}
                notSelfNumber[ssnumber] = true;
            }
        }
        bw.flush();
    }
}
