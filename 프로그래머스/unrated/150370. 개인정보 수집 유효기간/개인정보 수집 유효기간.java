import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 개인정보 수집 유효기간 2023 카카오 공채문제 난이도 1
 */
public class Solution {

	public int[] solution(String today, String[] terms, String[] privacies) {
//		int[] answer = {};

		List<Integer> answer=new ArrayList<>();

		StringBuilder result = new StringBuilder();
		String[] todayArr = today.split("\\.");
		int todayYear = Integer.parseInt(todayArr[0]) * 12 * 28;
		int todayMonth = Integer.parseInt(todayArr[1]) * 28;
		int todayDay = Integer.parseInt(todayArr[2]);

		int totalToday = todayYear + todayMonth + todayDay;

		Map<String, Integer> termsMap = new HashMap<>();
		for (String s : terms) {
			termsMap.put(s.substring(0, 1), Integer.parseInt(s.substring(2)));
		}

		for (int i = 0; i < privacies.length; i++) {

			String privacy = privacies[i];
			String term = privacy.substring(privacy.length() - 1);
			int period = termsMap.get(term); // 유효기간

			String[] date = privacy.substring(0, 10).split("\\.");
			int year = Integer.parseInt(date[0]) * 12 * 28;
			int month = (Integer.parseInt(date[1]) + period) * 28;
			int day = Integer.parseInt(date[2]) - 1;

			int totalDay = year + month + day;

			if (totalToday > totalDay) {
//				result.append(i + 1);
				answer.add(i + 1);
			}
		}

//		answer = new int[result.length()];
		return answer.stream().mapToInt(i -> i).toArray();

//		for (int i = 0; i < answer.length; i++) {
//			answer[i] = Integer.parseInt(String.valueOf(result.charAt(i)));
//		}
//		Arrays.sort(answer);
//		return answer;
	}
}
