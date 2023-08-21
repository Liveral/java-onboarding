package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static int[] arr=new int[2];
    public static  List<String> answer=new ArrayList<>();
    public static List<String> solution(List<List<String>> forms) {

        combination(0,0,forms.size(),forms);
        answer=answer.stream().distinct().collect(Collectors.toList()); //중복제거
        Collections.sort(answer); //오름차순 정렬
        return answer;
    }
    public static void combination(int start, int cnt,int size,List<List<String>> forms){
        if(cnt==2){
            check(forms);
            return;
        }

        for(int i=start;i<size;i++){
            arr[cnt]=i;
            combination(i+1,cnt+1,size, forms);
        }
    }
   public static void check(List<List<String>> forms){
        String str1=forms.get(arr[0]).get(1);
        String str2=forms.get(arr[1]).get(1);
        for(int i=0;i<str1.length()-1;i++){
            for(int j=0;j<str2.length()-1;j++){
                if(str1.charAt(i)==str2.charAt(j)&&str1.charAt(i+1)==str2.charAt(j+1)){
                    answer.add(forms.get(arr[0]).get(0));
                    answer.add(forms.get(arr[1]).get(0));
                }
            }
        }
   }
}
