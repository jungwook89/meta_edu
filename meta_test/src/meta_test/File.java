package meta_test;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class File {
	private String filePath;
	private String fileContent;

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String roadFile(String roadPath) {
		Path path = Paths.get(roadPath);
		// 캐릭터셋 지정
		Charset cs = StandardCharsets.UTF_8;
		// 파일 내용담을 리스트
		List<String> list = new ArrayList<String>();
		String concatLine = "";
		try {
			list = Files.readAllLines(path, cs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (String readLine : list) {
			concatLine += readLine;
		}
		return concatLine;

	}

	public void saveFile(String contents, String savePath) {
		try {
			Writer writer = new FileWriter(savePath);
			writer.write(contents);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
