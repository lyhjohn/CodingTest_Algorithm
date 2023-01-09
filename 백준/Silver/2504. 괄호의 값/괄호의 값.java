import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int sum = 0;

		String[] arr = input.split("");

		if (arr.length % 2 == 1) {
			System.out.println(sum);
			return;
		}



		Stack<String> stack = new Stack<>();
		int tmp = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("(")) {
				tmp *= 2;
				stack.push(arr[i]);
			} else if (arr[i].equals("[")) {
				tmp *= 3;
				stack.push(arr[i]);
			} else if (arr[i].equals(")")) {
				if (stack.isEmpty() || !stack.peek().equals("(")) {
					System.out.println(0);
					return;
				}
				if (arr[i - 1].equals("(")) {
					sum += tmp;
				}
				stack.pop();
				tmp /= 2;
			} else if (arr[i].equals("]")) {
				if (stack.isEmpty() || !stack.peek().equals("[")) {
					System.out.println(0);
					return;
				}
				if (arr[i - 1].equals("[")) {
					sum += tmp;
				}
				stack.pop();
				tmp /= 3;
			}
		}
		System.out.println(sum);
	}

}
