import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer=new ArrayList<>();
        
        //오늘날짜의 일수
        String[] t=today.split("\\.");
        int todayCnt=Integer.parseInt(t[0])*12*28+Integer.parseInt(t[1])*28+Integer.parseInt(t[2]);
        
        Map<String, Integer> map=new HashMap<>();
        for(String i:terms){
            String [] a=i.split("\\s");
            map.put(a[0], Integer.parseInt(a[1]));
        }
        for(int i=0;i<privacies.length;i++){
            int year=Integer.parseInt(privacies[i].substring(0, 4));//년
            int month=Integer.parseInt(privacies[i].substring(5, 7));//월
            int day=Integer.parseInt(privacies[i].substring(8,10));//일
            String level=privacies[i].substring(11, 12);//약관종류

            Integer lev=map.get(level); //HashMap에서 해당 약관종류의 유효기간을 가져오기
            month+=lev;

            int temp=year*12*28+month*28+day-1;//유효기간 마지막 날짜

            if(todayCnt>temp){
                answer.add(i+1)  ;
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}