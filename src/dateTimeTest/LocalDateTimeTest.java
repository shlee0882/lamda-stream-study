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

		// 1. LocalDate ���
		LocalDate today = LocalDate.now();
		System.out.println(today);
		/* result : 2019-02-20 */
		
		System.out.println("�����"+today.getYear() + "/" + today.getMonth() + " "+today.getMonthValue() 
		+"/"+today.getDayOfMonth() + " �������� " + today.getDayOfYear());
		/* result : �����2019/FEBRUARY 2/20 �������� 51*/
		
		System.out.println("���� " + today.getDayOfWeek()+" "+today.getDayOfWeek().getValue());
		/* ���� WEDNESDAY 3*/
		
		// Ư�� ��¥�� �����ؼ� LocalDate ����
		LocalDate endDay = LocalDate.of(2019, 12, 31);
		System.out.println("���� ���� ���� ���� �ִ��� "+ today.until(endDay, ChronoUnit.DAYS));
		/* ���� ���� ���� ���� �ִ��� 314 */
		
		System.out.println("���� ���� 1���� �� "+today.plusMonths(1));
		/* ���� ���� 1���� �� 2019-03-20 */

		System.out.println(DayOfWeek.TUESDAY.plus(3));
		/* FRIDAY */
		
		// LocalTime ���
		LocalTime now = LocalTime.now();
		System.out.println(now);
		/* 19:41:50.647622500 */

		System.out.println("�ú��ʳ�����" + now.getHour() + " " + now.getMinute()
										+ " " + now.getSecond() + " " +now.getNano());
		/* �ú��ʳ�����19 41 50 647622500 */
		
		// Ư�� �ð��� �����ؼ� LocalTime ����
		LocalTime bedTime = LocalTime.of(23, 40);
		LocalTime wakeTime = bedTime.plusHours(8);
		System.out.println(wakeTime);
		/* 07:40 */
		
		// LocalDateTime ���
		LocalDateTime dt = LocalDateTime.now();
		System.out.println(dt);
		/* 2019-02-20T19:41:50.647622500 */
		
		LocalDate date = dt.toLocalDate();
		System.out.println(date);
		/* 2019-02-20 */
		
		LocalTime time = dt.toLocalTime();
		System.out.println(time);
		/* 19:41:50.647622500 */
		
		// Ư�� ��¥�� �ð��� �����ؼ� LocalDateTime ����
		LocalDateTime dt2 = LocalDateTime.of(2019,2,19,13,20,50);
		System.out.println(dt2);
		System.out.println(dt2.getMonth());
		
		dt2.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		
		// ������ ���� ������ Formatter ����
		DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss E a", Locale.KOREAN);
		System.out.println(dt2.format(myFormat));	
	}
}