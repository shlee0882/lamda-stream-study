package dateTimeTest;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class SalaryDate {
	
	// �� ���޳�(�ſ� 25��)�� ���� ��������?
	public static void main(String[] args) {
		 LocalDate today = LocalDate.now();
//		LocalDate today = LocalDate.of(2019, 2, 26);
		
		// 1. ������ �Ǵ� ��¥�� ���ϱ�
		LocalDate theDay = LocalDate.from(today);
		System.out.println("���ó�¥ : "+theDay);
		
		// 2. ���޳� ���ϱ� �ſ� 25�� 
		int salaryDay = 25;
		int remainDay = 0;

		if(theDay.getDayOfMonth() > salaryDay) {
			LocalDate lastDayOfMonth = theDay
					.with(TemporalAdjusters.lastDayOfMonth());
			remainDay = lastDayOfMonth.getDayOfMonth()-theDay.getDayOfMonth()+salaryDay;
		}else if(theDay.getDayOfMonth() < salaryDay) {
			remainDay = salaryDay-theDay.getDayOfMonth();
		}else {
			remainDay = 0;
		}
		
		System.out.println("���ޱ��� "+remainDay+"�� ���ҽ��ϴ�.");
	}
}
