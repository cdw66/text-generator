import java.util.ArrayList;
import java.util.HashMap;

public class TGRunner {

	public static void main(String[] args) {
		TextGenerator tg = new TextGenerator();
		tg.train("much_ado.txt");
		ArrayList<String> answer = tg.generate();
		System.out.println(answer);
		
//		HashMap<String,ArrayList<String>> m = tg.getMap(tg.allWords);
//		for(String s : m.keySet()) {
//			System.out.println(s + ": " + m.get(s));
//		}
	}
}
