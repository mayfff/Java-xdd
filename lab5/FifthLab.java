import java.util.Scanner;

public class FifthLab {
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = scn.nextLine();
        StringBuilder textBuilder = new StringBuilder(text);
        StringBuilder result = new StringBuilder();
        System.out.print("Enter a string to replace the words: ");
        String replace = scn.nextLine();
        System.out.print("Enter the length of the words to replace: ");
        int length = scn.nextInt();
        System.out.println("\nText before changes: ");
        System.out.println(textBuilder);


        String[] mySentence = textBuilder.toString().split("(?<=[!.?])\\s?");
        for(String s: mySentence){
            StringBuilder sb = new StringBuilder(s);
            Sentences sentence = new Sentences(sb, length, replace);
            result.append(sentence.WordsSplit());
        }


        System.out.println("\nText after changes: ");
        System.out.println(result);
        scn.close();

    }
}

class Sentences {
    
    private final StringBuilder SENTENCE;
    private final int LENGTH;
    private String REPLACE;

    public Sentences(StringBuilder SENTENCE, int LENGTH, String REPLACE) {
        this.SENTENCE = SENTENCE;
        this.LENGTH = LENGTH;
        this.REPLACE = REPLACE;
    }

    public StringBuilder WordsSplit() {
        StringBuilder ReturnSentence = new StringBuilder();
        String text = SENTENCE.toString();
        String[] words = text.split(" ");
        for(String s: words) {
            StringBuilder sb = new StringBuilder(s);
            Words word = new Words(sb, LENGTH, REPLACE);
            ReturnSentence.append(word.LettersSplit()).append(" ");
        }

        return ReturnSentence;
    }
}

class Words {

    private final StringBuilder WORD;
    private final int LENGTH;
    private String REPLACE;

    public Words(StringBuilder WORD, int LENGTH, String REPLACE) {
        this.WORD = WORD;
        this.LENGTH = LENGTH;
        this.REPLACE = REPLACE;
    }

    public StringBuilder LettersSplit() {
        StringBuilder ReturnWord = new StringBuilder();
        String word = WORD.toString();
        int len = word.length();
        String[] letters = word.split("");
        String[] ReplaceLetters = REPLACE.split("");
        char last = word.charAt(word.length() - 1);
        if(last == '!' || last == '?' || last == '.') {
            if(word.charAt(word.length() - 2) == '.') {
                len = word.length() - 3;
            } else {
                len = word.length() - 1;
            }
        }
        if(len == LENGTH) {
            for(String chr: ReplaceLetters) {
                StringBuilder ltr = new StringBuilder(chr);
                Letters letter = new Letters(ltr);
                ReturnWord.append(letter.GetLetter());
            }
            if(word.length() - len == 1) {
                ReturnWord.append(word.charAt(word.length() - 1));
            } else if(word.length() - len == 3) {
                ReturnWord.append("...");
            }
        } else {
            for(String chr: letters) {
                StringBuilder ltr = new StringBuilder(chr);
                if(chr.equals("!") || chr.equals("?") || chr.equals(".") || chr.equals(",") || chr.equals(":") || chr.equals(";")) {
                    Punctuation punctuation = new Punctuation(ltr);
                    ReturnWord.append(punctuation.GetPunctuation());
                } else {
                    Letters letter = new Letters(ltr);
                    ReturnWord.append(letter.GetLetter());
                }
            }
        }
        
        return ReturnWord;
    }
}

class Letters {

    private final StringBuilder LETTER;

    public Letters(StringBuilder LETTER) {
        this.LETTER = LETTER;
    }

    public StringBuilder GetLetter() {
        return LETTER;
    }

}

class Punctuation {

    private final StringBuilder PUNCTUATION;

    public Punctuation(StringBuilder PUNCTUATION) {
        this.PUNCTUATION = PUNCTUATION;
    }

    public StringBuilder GetPunctuation() {
        return PUNCTUATION;
    }
}
