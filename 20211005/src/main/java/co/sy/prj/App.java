package co.sy.prj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import co.sy.prj.member.Member;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Exam01 ex = new Exam01();
//    	ex.stringTest();
    	
//    	DateTest dateTest = new DateTest();
//    	dateTest.dateTest();
//    	dateTest.calenderTest();
//    	System.out.println("===============================================");
//    	SqlDateTest sqlDateTest = new SqlDateTest();
//    	sqlDateTest.sqlDate();
    	    	
    	Member member;
    	List<Member> members = new ArrayList<Member>();
    	member = new Member("홍길동","대구광역시",20);
    	members.add(member);
    	member = new Member("박승리","대구광역시",24);
    	members.add(member);
    	member = new Member("이기자","대구광역시",20);
    	members.add(member);
    	member = new Member("김기자","대구광역시",24);
    	members.add(member);
    	
    	for(Member m : members) {
    		m.toString();
    	}
    }
}
