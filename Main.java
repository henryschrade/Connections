import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

      
        //makes categories, then prints them out
      
      //deselect causes err 
       int num1 = (int)(Math.random() * 20) + 1;
        int guessesRem = 4;
        Scanner scan = new Scanner(System.in);
        String guess = "";
        ArrayList<String> guesses = new ArrayList<String>();
        boolean categoryGuessed = false;
        Category yellow = new Category(num1, "yellow");
        Category green = new Category(num1, "green");
        Category blue = new Category(num1, "blue");
        Category purple = new Category(num1, "purple");

        System.out.println(yellow.toString());
        System.out.println(green.toString());
        System.out.println(blue.toString());
        System.out.println(purple.toString());

      while(guessesRem != 0){
        categoryGuessed = false;
        System.out.println("Guesses Remaining: " + guessesRem);
        for(int i = 0; i < 4; i++){
          guess = scan.nextLine();
          if(guess.toLowerCase().equals("deselect")){
            guesses.clear();
          } else {
            guesses.add(guess);   
          }
        }
        System.out.println(guesses);
        if(yellow.checkCategory(guesses) || green.checkCategory(guesses) || blue.checkCategory(guesses) || purple.checkCategory(guesses)){
          categoryGuessed = true;
        }
        System.out.println(categoryGuessed);
        guesses.clear();
        if(!categoryGuessed){
          guessesRem--;
        } 
      }
    }
}
