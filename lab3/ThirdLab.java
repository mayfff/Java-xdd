import java.util.Scanner;

public class ThirdLab {
    /*C3 = 0, C17 = 15 
      	StringBuilder,  В заданому тексті замінити слова заданої довжини визначеним рядком.*/
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a string: "); 
        String text = scn.nextLine();  // Введення тексту
        StringBuilder textBuilder = new StringBuilder(text); // Зміна типу тексту
        System.out.print("Enter a string to replace the words: ");
        String replace = scn.nextLine(); // Введення рядку для заміни
        System.out.print("Enter the length of the words to replace: ");
        int length = scn.nextInt(); // Введення довжини слова для заміни
        String[] words = textBuilder.toString().split("\\s+"); // Розподіл тексту на масив
        textBuilder.setLength(0);  
        for(String word : words) {
            if(word.charAt(word.length()-1) == '.' && word.length() - 1 == length) {
                textBuilder.append(replace + ". "); 
            } else if (word.charAt(word.length() - 1) == '!' && word.length() - 1 == length) {
                textBuilder.append(replace + "! ");
            } else if (word.charAt(word.length() - 1) == '?' && word.length() - 1 == length) { // Перевірка довжини кожного слова та їх заміна
                textBuilder.append(replace + "? ");
            } else if (word.length() == length) {          
                textBuilder.append(replace + " "); 
            } else {
                textBuilder.append(word + " ");
            }
        }

        System.out.printf("Result: %s", textBuilder); // Друк кінцевого результату
        scn.close();
    }
}
