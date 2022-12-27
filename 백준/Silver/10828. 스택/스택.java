import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
				case "top":
					System.out.println(stack.empty() ? -1 : stack.peek());
					continue;
				case "size":
					System.out.println(stack.size());
					continue;
				case "pop":
					System.out.println(stack.empty() ? -1 : stack.pop());
					continue;
				case "empty":
					System.out.println(stack.empty() ? 1 : 0);
					continue;
			}

			if (st.hasMoreTokens()) {
				stack.push(st.nextToken());
			}
		}
	}
}
