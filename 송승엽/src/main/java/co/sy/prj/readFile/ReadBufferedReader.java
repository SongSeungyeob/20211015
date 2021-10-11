package co.sy.prj.readFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadBufferedReader implements FileRead{
	private File file;
	private String path;
	private BufferedReader br;
	
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
			br = new BufferedReader(new FileReader(file));
			System.out.println("[ SUCCESS ] : 파일을 읽어오는데 성공하였습니다." );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] : 파일을 읽어올 수 없습니다.");
		}
		
		String Str = "";
		while(true) {
			try {
				String data = br.readLine();
				if(data == null) {
					System.out.println("[ SUCCESS ] : " + path + " 파일의 데이터를 모두 읽어왔습니다.");
					br.close();
					break;
				} else {
					Str += data;
					Str += "\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("[ ERROR ] : " + path + " 파일의 데이터를 읽어오는 과정에서 Error가 발생하였습니다.");
				break;
			}
		}
		return Str.toCharArray();
	}

	@Override
	public char[] run() {
		if (findFile()) {
			return read();
		}
		return null;
	}

}
