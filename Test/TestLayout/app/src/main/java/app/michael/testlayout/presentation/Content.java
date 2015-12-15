package app.michael.testlayout.presentation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michael on 12/10/15.
 */
public class Content {

    private List<Word> words;


    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;


    }

    public Content() {
        words = new ArrayList<Word>();

        makeSampleData();
    }

    public void makeSampleData() {
        String str = "wrote this initially ............. just as a demonstration that MathJax can be used ............. dynamically inside an Android app, and as such, there isn't ............. really much to the app's code";
        String[] strs = str.split(" ");

        for (String item : strs) {
            if(item.equals(".............")) {
                words.add(new Word(2,item));
            }    else  {
                words.add(new Word(0," "+item+" "));
            }
        }
    }
}
