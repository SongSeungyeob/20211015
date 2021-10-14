package co.micol.prject.board.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardVO {
	private int bId;
	private String bWriter;
	private Date bWriteDate;
	private String bTitle;
	private String bContents;
	private int bHit;
	
	public void toListString() {
		System.out.printf("%-2d | %-6s | %-10s | %-13s\t | %-2d |\n", 
				bId, bWriter, bWriteDate, bTitle, bHit);
//		System.out.print(bId + "\t : ");
//		System.out.print(bWriter + "\t\t : ");
//		System.out.print(bWriteDate + "\t : ");
//		System.out.print(bTitle + "\t\t : ");
//		System.out.print(bHit + "\n");
	}
	
	public String toString() {
		System.out.println("글번호 : " + bId);
		System.out.println("작성자 : " + bWriter);
		System.out.println("작성일자 : " + bWriteDate);
		System.out.println("제 목 : " + bTitle);
		System.out.println("내 용 : " + bContents);
		System.out.println("조회수 : " + bHit);
		return null;
	}
}
