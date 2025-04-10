import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BigInteger big;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        big = new BigInteger(n + "");

        for(int i = n - 1; i >= 1; i--) {
            big = big.multiply(BigInteger.valueOf(i));
        }

        String s = big.toString();
        int count = 0;
        if (!s.equals("0")) {
            for(int i = s.length() - 1; i >= 0; i--) {
                if(s.charAt(i) == '0') {
                    count++;
                }
                else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}