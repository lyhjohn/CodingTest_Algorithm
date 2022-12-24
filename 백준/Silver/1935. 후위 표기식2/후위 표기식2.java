import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();

		Stack<Double> stack = new Stack<>();
		Map<String, Double> map = new HashMap<>();
		String[] arr = str.split("");

		for (String s : arr) {
			if (!s.equals("*") && !s.equals("/") && !s.equals("+")
				&& !s.equals("-") && !map.containsKey(s)) {
				map.put(s, Double.parseDouble(br.readLine()));
			}
		}


		for (int i = 0; i < str.length(); i++) {

			if (arr[i].equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} else if (arr[i].equals("/")) {
				Double pop1 = stack.pop();
				Double pop2 = stack.pop();
				stack.push(pop2 / pop1);
			} else if (arr[i].equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (arr[i].equals("-")) {
				stack.push((stack.pop() - stack.pop()) * -1);
			} else {
				stack.push(map.get(arr[i]));
			}
		}

		System.out.printf("%.2f", stack.pop());
	}


}
