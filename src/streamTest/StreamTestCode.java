package streamTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTestCode {
    public static void main(String ...args){    
    	// 개발자의 성명과 직급
        Developer sanghyun = new Developer("SangHyun", "대리");
        Developer hyunYoung = new Developer("HyunYoung","사원");
        Developer jiSook = new Developer("JiSook","주임");
        Developer choa = new Developer("Choa","대리");
		
        // 입찰회사에서 개발자 채용을 위해 연봉제시 
        // 입찰한 개발자 이름, 참여한 회사이름, 설립연도 , 제시한연봉 
		List<BiddingCompany> company = Arrays.asList(
            new BiddingCompany(sanghyun, "쿠팡",2010, 4000), 
            new BiddingCompany(sanghyun, "위메프",2011, 5000), 
            new BiddingCompany(sanghyun, "sk플래닛",2012, 7000), 
            new BiddingCompany(hyunYoung, "위메프",2010, 2000),  
            new BiddingCompany(hyunYoung, "sk플래닛",2012, 3000), 
            new BiddingCompany(jiSook, "쿠팡",2010, 3500),
            new BiddingCompany(choa, "위메프",2011, 3800) 
        );	
        
		// 쿼리 1 : 설립일이 2012년인 입찰회사를 모두 찾아서 연봉이 작은값부터 큰값으로 출력해라
		// 2012년이라는 특정한 조건이 있으므로 filter사용, 작은값부터 큰값 정렬 sorted 사용
		
		List<BiddingCompany> t1 = 
				company.stream()
							 .filter(a->a.getYear()==2012)
							 .sorted(Comparator.comparing(b->b.getSalary()))
							 .collect(Collectors.toList());
		
		t1.forEach(System.out::println);
		/* result : {Developer:HyunYoung , 사원, companyName: sk플래닛, year: 2012, salary:3000}
					    {Developer:SangHyun , 대리, companyName: sk플래닛, year: 2012, salary:7000} */
		
		// 쿼리 2 : 입찰회사 개발자 목록에서 개발자의 중복되지 않는 직급만 출력해라.
		// 특정한 조건이 딱 주어지지 않았으므로 map사용, 중복제거 distinct사용
		
		List<String>  t2_1 = 	
				company.stream()
							 .map(BiddingCompany::getDeveloper)
							 .map(Developer::getTitle)
							 .distinct()
							 .collect(Collectors.toList());

		System.out.println("map 2번 사용");
		t2_1.forEach(System.out::println);
		/* result : 대리 사원 주임 */
		
		List<String>  t2_2 = 		
				company.stream()
							 .map(tx -> tx.getDeveloper().getTitle()) 
							 .distinct()
							 .collect(Collectors.toList());
		
		System.out.println("map 1번 사용");
		t2_2.forEach(System.out::println);
		/* result : 대리 사원 주임 */
		
        // 쿼리 3: 개발자 중에서 대리직급을 찾아 이름순으로 정렬해라.
		
		company.stream()
					 .map(a->a.getDeveloper())
					 .filter(b->b.getTitle().equals("대리"))
					 .distinct()
					 .sorted(Comparator.comparing(c->c.getName()))
					 .forEach(System.out::println);
		/* result : Developer:Choa , 대리 
		 			   Developer:SangHyun , 대리 */
        
		// 쿼리 4: 알파벳 순서대로 정렬하여 개발자 이름만 출력해라
		
		String names = 
				company.stream()
							 .map(a->a.getDeveloper().getName())
							 .distinct()
							 .sorted()
							 .reduce("", (a1,a2) -> a1+a2+" ");
		
		System.out.println(names);
		/* result : Choa HyunYoung JiSook SangHyun */
		
		// 쿼리 5 : 사원 직급의 개발자가 있는가?
		
		boolean 사원 = 
				company.stream()
							 .anyMatch(tx -> tx.getDeveloper().getTitle().equals("사원"));
									
		System.out.println(사원);
		/* result : true */
		
		// 쿼리 6 : 대리직급의 개발자를 과장직급으로 업데이트 해라
		
		System.out.println("업데이트 전: "+company);
		company.stream()
					 .map(a->a.getDeveloper())
					 .filter(a->a.getTitle().equals("대리"))
					 .forEach(a->a.setTitle("과장"));
		System.out.println("업데이트 후: "+company);
		
		// 쿼리 7: 입찰한 모든회사 중에 가장 높은 연봉을 제시한 값은 얼마인가?
		
		int highSalary = 
				company.stream()
							 .mapToInt(a->a.getSalary())
							 .max()
							 .getAsInt();
		
		System.out.println(highSalary);
		/* result : 7000 */
    }
}
