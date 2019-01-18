package inputOutput;

public class OutputConsole implements Outputable {
	
	@Override
	public void write(String countNum){
		System.out.println("출력값은:"+countNum);
	}
}
