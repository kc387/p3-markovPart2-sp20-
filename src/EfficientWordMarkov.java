import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;
    public EfficientWordMarkov(int order){
        super(order);
        myMap = new HashMap();
    }
    public EfficientWordMarkov(){
        this(3);
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        myWords = text.split("\\s+");
        myMap.clear();
        for(int k = 0; k <= myWords.length - myOrder; k += 1){
            WordGram a = new WordGram(myWords, k, myOrder);
            //String b = a.toString();
            myMap.putIfAbsent(a, new ArrayList());
            if(k == myWords.length - myOrder) {
                myMap.get(a).add(PSEUDO_EOS);
            }
            else{
                String d = myWords[k + myOrder];
                myMap.get(a).add(d);
            }
        }
    }

    @Override
    public ArrayList<String> getFollows(WordGram kGram) {
        if(myMap.containsKey(kGram)){
            return myMap.get(kGram);
        }
        else{
            throw new NoSuchElementException(kGram + " not in map");
        }
    }
}
