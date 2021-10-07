package co.sy.prj;

import java.sql.Date;

public class SqlDateTest {
	private Date date;	
	/* java.sql.Date 객체는 년-월-일 만 처리한다. */
	
	void sqlDate() {
		date = Date.valueOf("2021-10-05");	
		// sql date는 new로 선언할 시, 기존에 이미 저장되어 있는 시간을하나 넣어줘야 한다.
		// 위의 방법은, String 객체를 Date객체로 변환.
		System.out.println(date);		
		System.out.println(date.toString());
		System.out.println(date);
	}
}
