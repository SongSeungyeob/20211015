package co.sy.bootstrap.notice.service;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NoticeVO {
	private int no;
	private String id;
	private String name;
	private Date wdate;
	private String title;
	private String subject;
	private String fileName;
	private String pfileName;
}
