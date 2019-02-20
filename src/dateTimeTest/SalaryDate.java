package dateTimeTest;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class SalaryDate {
	
	// 내 월급날(매월 25일)은 몇일 남았을까?
	public static void main(String[] args) {
		 LocalDate today = LocalDate.now();
//		LocalDate today = LocalDate.of(2019, 2, 26);
		
		// 1. 기준이 되는 날짜를 구하기
		LocalDate theDay = LocalDate.from(today);
		System.out.println("오늘날짜 : "+theDay);
		
		// 2. 월급날 구하기 매월 25일 
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
		
		System.out.println("월급까지 "+remainDay+"일 남았습니다.");
	}
}
