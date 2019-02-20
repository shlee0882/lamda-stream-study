package dateTimeTest;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDateTimeTest {

	public static void main(String[] args) {

		// 1. LocalDate 사용
		LocalDate today = LocalDate.now();
		System.out.println(today);
		/* result : 2019-02-20 */
		
		System.out.println("년월일"+today.getYear() + "/" + today.getMonth() + " "+today.getMonthValue() 
		+"/"+today.getDayOfMonth() + " 지난일자 " + today.getDayOfYear());
		/* result : 년월일2019/FEBRUARY 2/20 지난일자 51*/
		
		System.out.println("요일 " + today.getDayOfWeek()+" "+today.getDayOfWeek().getValue());
		/* 요일 WEDNESDAY 3*/
		
		// 특정 날짜를 지정해서 LocalDate 생성
		LocalDate endDay = LocalDate.of(2019, 12, 31);
		System.out.println("현재 기준 몇일 남아 있는지 "+ today.until(endDay, ChronoUnit.DAYS));
		/* 현재 기준 몇일 남아 있는지 314 */
		
		System.out.println("현재 기준 1개월 후 "+today.plusMonths(1));
		/* 현재 기준 1개월 후 2019-03-20 */

		System.out.println(DayOfWeek.TUESDAY.plus(3));
		/* FRIDAY */
		
		// LocalTime 사용
		LocalTime now = LocalTime.now();
		System.out.println(now);
		/* 19:41:50.647622500 */

		System.out.println("시분초나노초" + now.getHour() + " " + now.getMinute()
										+ " " + now.getSecond() + " " +now.getNano());
		/* 시분초나노초19 41 50 647622500 */
		
		// 특정 시간을 지정해서 LocalTime 생성
		LocalTime bedTime = LocalTime.of(23, 40);
		LocalTime wakeTime = bedTime.plusHours(8);
		System.out.println(wakeTime);
		/* 07:40 */
		
		// LocalDateTime 사용
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		/* 2019-02-20T19:41:50.647622500 */
		
		LocalDate date = dt.toLocalDate();
		System.out.println(date);
		/* 2019-02-20 */
		
		LocalTime time = dt.toLocalTime();
		System.out.println(time);
		/* 19:41:50.647622500 */
		
		// 특정 날짜와 시간을 지정해서 LocalDateTime 생성
		LocalDateTime dt2 = LocalDateTime.of(2019,2,19,13,20,50);
		System.out.println(dt2);
		System.out.println(dt2.getMonth());
		
		dt2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		// 포맷을 직접 설정한 Formatter 생성
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a", Locale.KOREAN);
		System.out.println(dt2.format(myFormat));	
	}
}