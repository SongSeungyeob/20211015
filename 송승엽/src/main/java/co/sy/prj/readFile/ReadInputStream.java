package co.sy.prj.readFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class ReadInputStream implements FileRead {
	private File file;
	private String path;
	private InputStream is;
	private	InputStreamReader isr;

	@Override
	public boolean findFile() {
		path = "src/main/resources/Input.txt";
		file = new File(path);
		if(file.exists()) {
			System.out.println("[ SUCCESS ] : " + path + " File을 찾았습니다.");
			return true;
		} else {
			System.out.println("[ ERROR ] : " + path + " File을 찾을 수 없습니다.");
			return false;
		}
	}
	
	@Override
	public char[] read() {
		try {
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, "UTF-8");
			System.out.println("[ SUCCESS ] : 파일을 읽어오는데 성공하였습니다.");
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] : 파일을 읽어올 수 없습니다.");
		}
		
		char[] buffer = new char[1024];
		while(true) {
			try {
				int data = isr.read(buffer);
				if(data == -1) {
					System.out.println("[ SUCCESS ] : " + path + " 파일의 데이터를 모두 읽어왔습니다.");
					is.close();
					isr.close();
					break;
				} 
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("[ ERROR ] : " + path + " 파일의 데이터를 읽어오는 과정에서 Error가 발생하였습니다.");
				break;
			} 
		}
		return buffer;
	}
	
	@Override
	public char[] run() {
		if (findFile()) {
			return read();
		}
		return null;
	}
	
	
}
