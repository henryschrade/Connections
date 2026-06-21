import java.util.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
public class Category{
  private int count;
  private int comma;
  private String category;
  private ArrayList<String> categories = new ArrayList<String>();
  private Scanner fileScanner = new Scanner("");
  public Category(int num1, String color){
    try {
    if(color.equals("yellow")){
       fileScanner = new Scanner(new File("yellow.txt"));
    } else if(color.equals("green")){
     fileScanner = new Scanner(new File("green.txt"));
    } else if(color.equals("blue")){
     fileScanner = new Scanner(new File("blue.txt"));
    } else {
     fileScanner = new Scanner(new File("purple.txt"));
    }
      while (fileScanner.hasNextLine()) {
      String categoryList = fileScanner.nextLine();
      count++;
      if(count == num1){
        for(int i = 0; i < 4; i++){
          comma = categoryList.indexOf(",");
          category = categoryList.substring(0, comma);
          categoryList = categoryList.substring(comma + 2, categoryList.length());
          categories.add(category);
        } 
      categories.add(categoryList);
      }
    }
  } catch (FileNotFoundException e) {
      System.err.println("Word list file not found: ");
  }
}
  public String toString(){
    String str = "";
    for(int i = 0; i < 4; i++){
      str += categories.get(i);
      str += " ";
    }
    return str;
  }
  public boolean checkCategory(ArrayList<String> guesses){
    String guess = "";
    int count = 0;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        if(guesses.get(i).toLowerCase().equals(categories.get(j))){
          count++;
        }
      }
    }
    if(count == 4){
      return true;
    }
    return false;
  }
}
