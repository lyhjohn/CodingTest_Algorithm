import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	
	static int solve(String str) {
		int ret = 0;
		String arr[] = str.split("");
		if(arr.length % 2 == 1)
			return ret;
		
		Stack<String> stack = new Stack<String>();
		int tmp = 1;
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals("(")) {
				tmp *= 2;
				stack.push(arr[i]);
			} else if(arr[i].equals("[")) { 
				tmp *= 3;
				stack.push(arr[i]);
			} else if(arr[i].equals(")")) {
				if(stack.isEmpty() || !stack.peek().equals("("))
					return ret = 0;
				if(arr[i-1].equals("("))
					ret += tmp;
				stack.pop();
				tmp /= 2;
			} else if(arr[i].equals("]")) {
				if(stack.isEmpty() || !stack.peek().equals("["))
					return ret = 0;
				if(arr[i-1].equals("["))
					ret += tmp;
				stack.pop();
				tmp /= 3;
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		bw.write(solve(str) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}