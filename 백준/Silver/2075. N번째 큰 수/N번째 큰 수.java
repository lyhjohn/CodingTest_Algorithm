import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[(int) Math.pow(N, 2)];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nums.length; i++) {
			if (i != 0 && i >= N && i % N == 0) {
				st = new StringTokenizer(br.readLine());
			}
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);
		System.out.println(nums[nums.length - N]);
	}

}
