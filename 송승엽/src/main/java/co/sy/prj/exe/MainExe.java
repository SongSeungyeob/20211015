package co.sy.prj.exe;

import co.sy.prj.readFile.FileRead;
import co.sy.prj.readFile.ReadBufferedReader;
import co.sy.prj.readFile.ReadInputStream;
import co.sy.prj.readFile.ReadReader;
import co.sy.prj.writeFile.FileWrite;
import co.sy.prj.writeFile.WriteBufferedWriter;
import co.sy.prj.writeFile.WriteOutputStream;
import co.sy.prj.writeFile.WriteWriter;

public class MainExe {
	private static MainExe mainExe = new MainExe();
	private FileRead fileRead;
	private FileWrite fileWrite;
	private char[] buffer = new char[1024];
	
	public static MainExe getInstance() {
		return mainExe;
	}
	
	private void mainMenu() {
		System.out.println("[ InputStream을 이용해서 파일을 읽어온 후, 해당 파일의 내용을 OutputStream으로 쓰겠습니다. ]");
		readFilebyInputStream();
		writeFilebyOutputStream();
		System.out.println("\n===============================================================================");
		
		System.out.println("[ Reader를 이용해서 파일을 읽어온 후, 해당 파일의 내용을 Writer로 쓰겠습니다. ]");
		readFilebyReader();
		writeFilebyWriter();
		System.out.println("\n===============================================================================");
		
		System.out.println("[ BufferedReader를 이용해서 파일을 읽어온 후, 해당 파일의 내용을 BufferedWriter로 쓰겠습니다. ]");
		readFilebyBR();
		writeFilebyBW();
	}
	
	private void writeFilebyBW() {
		fileWrite = new WriteBufferedWriter();
		fileWrite.run(buffer);
	}
	
	private void writeFilebyWriter() {
		fileWrite = new WriteWriter();
		fileWrite.run(buffer);
	}
	private void writeFilebyOutputStream() {
		fileWrite = new WriteOutputStream();
		fileWrite.run(buffer);
	}
	
	private void readFilebyBR() {
		fileRead = new ReadBufferedReader();
		buffer = fileRead.run();
	}
	private void readFilebyReader() {
		fileRead = new ReadReader();
		buffer = fileRead.run();
	}
	private void readFilebyInputStream() { 
		fileRead = new ReadInputStream();
		buffer = fileRead.run();
	}
	
	public void run() {
		mainMenu();
	}
}
