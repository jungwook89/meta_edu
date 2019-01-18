package inputOutput;

public class OutputFile extends File implements Outputable{
	
	@Override
	public void write(String contents){
		String savePath = getFilePath();
		saveFile(contents, savePath);
	}
}
