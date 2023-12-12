package Misha.Week1.N5;

public class SearchWord {

    String Text;

    public SearchWord() {
    }

    public SearchWord(String Text) {
        this.Text = Text;
    }

    public int foundWord(String word) {
        int count = 0;

        String [] words = Text.split(" ");

        for (String word1 : words) {
            if (word1.contains(word)){
                count++;
            }
        }
        return count;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

}
