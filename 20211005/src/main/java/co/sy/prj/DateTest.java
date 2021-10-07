package co.sy.prj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	private Date date;
	private Calendar now = Calendar.getInstance();
	private SimpleDateFormat sd;
	
	void dateTest() {
		date = new Date();										// 새로운 날짜 객체를 생성
		sd = new SimpleDateFormat("yyyy-MM-dd : hh:mm:ss"); 	// 날짜 표현 형식 정의
		System.out.println(sd.format(date));
		
		sd = new SimpleDateFormat("yyyy년 MM월 dd일");
		System.out.println(sd.format(date));
		
		sd = new SimpleDateFormat("현재시간 = hh:mm:ss");
		System.out.println(sd.format(date));
		
		sd = new SimpleDateFormat("현재시간 = hh시 mm분 ss초");
		System.out.println(sd.format(date));
		System.out.println(date);
		System.out.println("===============================================");
	}
	
	void calenderTest() {
		now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = now.get(Calendar.MONTH) + 1;	// MONTH같은 경우엔 0부터 출력이 된다.
		System.out.println(month);
		
		int day = now.get(Calendar.MONDAY)+ 1;
		System.out.println(day);
	}
}
