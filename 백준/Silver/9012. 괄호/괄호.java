import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	/**
	 * 나중에 들어간 것부터 차례대로 꺼내가며 (가 )보다 한개라도 더 많아지는 순간이 있다면 false
	 * 다 꺼냈을 때 (와 )의 개수가 같아야함
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String bracket = "";


		for (int i = 0; i < N; i++) {
			bracket = br.readLine();
			String[] brackets = bracket.split("");
			Stack<String> stack = new Stack<>();

			int openCount = 0;
			int closeCount = 0;

			for (int j = 0; j < brackets.length; j++) {
				stack.push(brackets[j]);
			}

			for (int j = 0; j < brackets.length; j++) {
				String pop = stack.pop();
				if (pop.equals("(")) {
					openCount++;
					if (openCount > closeCount) {
						break;
					}
					continue;
				}

				if (pop.equals(")")) {
					closeCount++;
				}
			}

			if (openCount != closeCount) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
