import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TextGenerator {
	private ArrayList<String> firstWords;
	public ArrayList<String> allWords;
	
	public TextGenerator() {
		firstWords = new ArrayList<String>();
		allWords = new ArrayList<String>();
	}
	
	public ArrayList<String> generate(){
		Random randy = new Random();
		HashMap<String, ArrayList<String>> map = getMap();
		String curr = firstWords.get(randy.nextInt(firstWords.size()));
		ArrayList<String> result = new ArrayList<String>();
		
		String next;
		
		do {
			result.add(curr);
			ArrayList<String> value = map.get(curr);
			next = value.get(randy.nextInt(value.size()));
			curr = next;
		} while (!curr.equals("END_OF_FILE"));
		
		return result;
	}
	
	public HashMap<String, ArrayList<String>> getMap() {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(int x = 0; x < allWords.size() - 1; x++) {
			String current = allWords.get(x);
			String next = allWords.get(x+1);
			if(map.containsKey(current)) {
				ArrayList<String> value = map.get(current);
				value.add(next);
			}
			else {
				ArrayList<String> val = new ArrayList<String>();
				val.add(next);
				map.put(current, val);
			}
		}
		
		return map;
	}

	public void train(String filePath) {
		try {
			Scanner sc = new Scanner(new File(filePath));
			if(sc.hasNext()) {
				String word = sc.next();
				firstWords.add(word);
				allWords.add(word);
			}
			while(sc.hasNext()) {
				allWords.add(sc.next());
			}
			allWords.add("END_OF_FILE");
			sc.close();
		}
		catch(FileNotFoundException x) {
			x.printStackTrace();
		}
	}
	
	
}
