import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuffer sb = new StringBuffer();

		Stack<String> leftStack = new Stack<>();
		Stack<String> rightStack = new Stack<>();

		int M = Integer.parseInt(br.readLine());

		Arrays.stream(input.split("")).forEach(leftStack::push);

		for (int i = 0; i < M; i++) {
			String cmd = br.readLine();
			if (cmd.equals("L") && !leftStack.isEmpty()) {
				rightStack.push(leftStack.pop());
				continue;
			}

			if (cmd.equals("D") && !rightStack.isEmpty()) {
				leftStack.push(rightStack.pop());
				continue;
			}

			if (cmd.equals("B") && !leftStack.isEmpty()) {
				leftStack.pop();
				continue;
			}

			if (cmd.startsWith("P")) {
				leftStack.push(String.valueOf(cmd.charAt(cmd.length() - 1)));
			}
		}

		for (String s : leftStack) {
			sb.append(s);
		}

		while (!rightStack.isEmpty()) {
			sb.append(rightStack.pop());
		}

		System.out.println(sb);
	}

}
