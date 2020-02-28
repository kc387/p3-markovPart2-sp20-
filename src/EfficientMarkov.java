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
		myText = text;
		myMap.clear();
		for(int k = 0; k < myText.length()- myOrder; k += 1){
			String a = myText.substring(k, k+myOrder);
			char c = myText.charAt(k + myOrder + 1);
			String d = Character.toString(c);
			ArrayList b = new ArrayList();
			b.add(d);
			myMap.put(a, b);
		}
		super.setTraining(text);
	}
}	
