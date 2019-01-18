package meta_test;

public class OutputConsole implements Outputable {
	
	@Override
	public void write(String countNum){
		System.out.println(countNum);
	}
}
