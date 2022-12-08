import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N <= 7) {
            if (N == 3 || N == 5) System.out.println(1);
            else if (N == 6) System.out.println(2);
            else System.out.println(-1);
            return;
        }
        dp = new int[N + 1];
        dp[3] = dp[5] = 1;
        dp[1] = dp[2] = dp[4] = dp[7] = -1;
        count(N);
        System.out.println(dp[N]);
    }

    static int count(int n) {
        if (dp[n] == 0) {
            if (dp[n - 5] != -1 && dp[n - 3] != -1) {
                dp[n] = Math.min(count(n - 5), count(n - 3)) + 1;
            } else if (dp[n - 5] != -1 && dp[n - 3] == -1) {
                dp[n] = count(n - 5) + 1;
            } else if (dp[n - 5] == -1 && dp[n - 3] != -1) {
                dp[n] = count(n - 3) + 1;
            }
        }
        return dp[n];
    }
}