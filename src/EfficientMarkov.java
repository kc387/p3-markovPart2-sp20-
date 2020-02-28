import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	public EfficientMarkov(int order){
		super(order);
		myMap = new HashMap();
	}
	public EfficientMarkov(){
		this(3);
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myText = text;
		myMap.clear();
		for(int k = 0; k < myText.length()- myOrder; k += 1){
			String a = myText.substring(k, k+myOrder);
			myMap.putIfAbsent(a, new ArrayList());
			if(k == myText.length() - myOrder) {
				myMap.get(a).add(PSEUDO_EOS);
			}
			else {
				char c = myText.charAt(k + myOrder);
				String d = Character.toString(c);
				myMap.get(a).add(d);
			}
		}
	}

	@Override
	public ArrayList<String> getFollows(String key) {
		if(myMap.containsKey(key)){
			return myMap.get(key);
		}
		else{
			throw new NoSuchElementException(key + " not in map");
		}
	}
}
