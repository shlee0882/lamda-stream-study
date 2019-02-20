package streamTest;

import java.util.Arrays;
import java.util.List;

public class MyStreamTest {

	public static void main(String[] args) {
		int count1 = 0;
		 List<String> names = Arrays.asList("1", "2", "3", "4", "5");
		 
		 // 기존의 for문
		for (String w : names) {
			if(w.length() > 0) {
				count1++;
			}
		}
		
		// stream 방식
		long count2 = 
				names.stream()
						 .filter(a->a.length()>0)
						 .count();
		
		// 병렬 stream 방식
		long count3 = 
				names.parallelStream()
						 .filter(a->a.length()>0)
						 .count();
		
		System.out.println(count1);
		System.out.println(count2);
		System.out.println(count3);
	}

}
