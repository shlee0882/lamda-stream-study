package streamTest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTestCode {
    public static void main(String ...args){    
    	// �������� ����� ����
        Developer sanghyun = new Developer("SangHyun", "�븮");
        Developer hyunYoung = new Developer("HyunYoung","���");
        Developer jiSook = new Developer("JiSook","����");
        Developer choa = new Developer("Choa","�븮");
		
        // ����ȸ�翡�� ������ ä���� ���� �������� 
        // ������ ������ �̸�, ������ ȸ���̸�, �������� , �����ѿ��� 
		List<BiddingCompany> company = Arrays.asList(
            new BiddingCompany(sanghyun, "����",2010, 4000), 
            new BiddingCompany(sanghyun, "������",2011, 5000), 
            new BiddingCompany(sanghyun, "sk�÷���",2012, 7000), 
            new BiddingCompany(hyunYoung, "������",2010, 2000),  
            new BiddingCompany(hyunYoung, "sk�÷���",2012, 3000), 
            new BiddingCompany(jiSook, "����",2010, 3500),
            new BiddingCompany(choa, "������",2011, 3800) 
        );	
        
		// ���� 1 : �������� 2012���� ����ȸ�縦 ��� ã�Ƽ� ������ ���������� ū������ ����ض�
		// 2012���̶�� Ư���� ������ �����Ƿ� filter���, ���������� ū�� ���� sorted ���
		
		List<BiddingCompany> t1 = 
				company.stream()
							 .filter(a->a.getYear()==2012)
							 .sorted(Comparator.comparing(b->b.getSalary()))
							 .collect(Collectors.toList());
		
		t1.forEach(System.out::println);
		/* result : {Developer:HyunYoung , ���, companyName: sk�÷���, year: 2012, salary:3000}
					    {Developer:SangHyun , �븮, companyName: sk�÷���, year: 2012, salary:7000} */
		
		// ���� 2 : ����ȸ�� ������ ��Ͽ��� �������� �ߺ����� �ʴ� ���޸� ����ض�.
		// Ư���� ������ �� �־����� �ʾ����Ƿ� map���, �ߺ����� distinct���
		
		List<String>  t2_1 = 	
				company.stream()
							 .map(BiddingCompany::getDeveloper)
							 .map(Developer::getTitle)
							 .distinct()
							 .collect(Collectors.toList());

		System.out.println("map 2�� ���");
		t2_1.forEach(System.out::println);
		/* result : �븮 ��� ���� */
		
		List<String>  t2_2 = 		
				company.stream()
							 .map(tx -> tx.getDeveloper().getTitle()) 
							 .distinct()
							 .collect(Collectors.toList());
		
		System.out.println("map 1�� ���");
		t2_2.forEach(System.out::println);
		/* result : �븮 ��� ���� */
		
        // ���� 3: ������ �߿��� �븮������ ã�� �̸������� �����ض�.
		
		company.stream()
					 .map(a->a.getDeveloper())
					 .filter(b->b.getTitle().equals("�븮"))
					 .distinct()
					 .sorted(Comparator.comparing(c->c.getName()))
					 .forEach(System.out::println);
		/* result : Developer:Choa , �븮 
		 			   Developer:SangHyun , �븮 */
        
		// ���� 4: ���ĺ� ������� �����Ͽ� ������ �̸��� ����ض�
		
		String names = 
				company.stream()
							 .map(a->a.getDeveloper().getName())
							 .distinct()
							 .sorted()
							 .reduce("", (a1,a2) -> a1+a2+" ");
		
		System.out.println(names);
		/* result : Choa HyunYoung JiSook SangHyun */
		
		// ���� 5 : ��� ������ �����ڰ� �ִ°�?
		
		boolean ��� = 
				company.stream()
							 .anyMatch(tx -> tx.getDeveloper().getTitle().equals("���"));
									
		System.out.println(���);
		/* result : true */
		
		// ���� 6 : �븮������ �����ڸ� ������������ ������Ʈ �ض�
		
		System.out.println("������Ʈ ��: "+company);
		company.stream()
					 .map(a->a.getDeveloper())
					 .filter(a->a.getTitle().equals("�븮"))
					 .forEach(a->a.setTitle("����"));
		System.out.println("������Ʈ ��: "+company);
		
		// ���� 7: ������ ���ȸ�� �߿� ���� ���� ������ ������ ���� ���ΰ�?
		
		int highSalary = 
				company.stream()
							 .mapToInt(a->a.getSalary())
							 .max()
							 .getAsInt();
		
		System.out.println(highSalary);
		/* result : 7000 */
    }
}
