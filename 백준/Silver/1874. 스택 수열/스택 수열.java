import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();

		int start = 0;

		total:
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > start) {
				for (int j = start + 1; j <= num; j++) {
					start = stack.push(j);
					sb.append("+\n");
					if (num == j) {
						stack.pop();
						sb.append("-\n");
						continue total;
					}
				}
			}

			if (!stack.isEmpty()) {
				if (stack.peek() == num) {
					stack.pop();
					sb.append("-\n");
				}
			}

		}

		System.out.println(stack.isEmpty() ? sb : "NO");
	}
}
