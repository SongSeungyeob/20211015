package co.sy.prj.writeFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class WriteWriter implements FileWrite {
	private String path;
	private String fileName;
	private File file;
	private Writer writer;
	
	@Override
	public void makeFile() {
		path = "src/main/resources/";
		fileName = "WriterOutput.txt";
		file = new File(path + fileName);
		try {
			if(file.createNewFile()) {
				System.out.println("[ SUCCESS ] : " + path + "경로에 " + fileName + "를 생성하였습니다.");
			} else {
				System.out.println("[ WARNING ] : " + path + "경로에 " + fileName + " 은(는) 이미 존재하는 파일이므로 덮어쓰겠습니다.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] : 파일을 생성하는 과정에서 Error가 발생하였습니다.");
		}
	}

	@Override
	public void write(char[] buffer) {	
		try {
			writer = new FileWriter(file);
			System.out.println("[ SUCCESS ] : 파일을 읽어, 데이터를 쓸 준비가 되었습니다.");
		} catch (IOException e1) {
			e1.printStackTrace();
			System.out.println("[ ERROR ] : 파일을 읽어, 데이터를 쓸 준비하는 과정에서 Error가 발생하였습니다.");
		}
		
		try {
			writer.write(buffer);
			writer.flush();
			writer.close();
			System.out.println("[ SUCCESS ] : 읽은 Data를 " + path + fileName + "에 Write하였습니다.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("[ ERROR ] : 읽은 Data를 " + path + fileName + "에 Write 하지 못하였습니다.");
		} 
	}

	@Override
	public void run(char[] buffer) {
		if(buffer == null) {
			System.out.println("[ ERROR ] : 파일을 읽지 못하였습니다. 읽은 파일이 없으므로 파일을 쓸 수 없습니다.");
		} else {
			makeFile();
			write(buffer);
		}
	}
}
