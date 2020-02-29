import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<String,ArrayList<String>> myMap;
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
