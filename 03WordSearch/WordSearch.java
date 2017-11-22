import java.util.*;
import java.io.*;

public class WordSearch{
  private char[][]data;
  private Random randgen;
  private ArrayList<String>wordsToAdd = new ArrayList<String>();
  private ArrayList<String>wordsAdded = new ArrayList<String>();
  private char[][] key;
  private boolean keyselect = false;

  public WordSearch(int rows, int cols, String filename){
    data = new char[rows][cols];
    this.key = new char[rows][cols];
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        String word = in.nextLine();
        wordsToAdd.add(word);
      }
      in.close();
    }
    catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }
    for (int x = 0; x < rows; x++){
      for (int y = 0; y < cols; y++){
        data[x][y] = '_';
      }
    }
    randgen = new Random();
    addAllWords();
    System.out.println("Bank: " + "\n" + wordsAdded);
    System.out.println("Seed: " + randgen.nextInt());
  }


  public WordSearch(int rows,int cols,String filename,int randseed){
    data = new char[rows][cols];
    this.key = new char[rows][cols];
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        String word = in.nextLine();
        wordsToAdd.add(word);
      }
      in.close();  
    }catch(FileNotFoundException e){ 
      System.out.println("File not found: " + filename); 
      System.exit(1);
    }
    for(int x = 0; x <rows; x++){ 
      for(int y = 0;y <cols; y++){
        data[x][y] = '_'; 
      }
    }
    randgen = new Random(randseed);
    addAllWords();
    System.out.println("Bank \n" + wordsAdded);
    System.out.println("Seed: " + randseed); 
  }

  public WordSearch(int rows, int cols, String filename, int randSeed, boolean keyselect){
    data = new char[rows][cols];
    this.key = new char[rows][cols];
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      while (in.hasNext()){
        String word = in.nextLine();
        wordsToAdd.add(word);
      }
    }catch(FileNotFoundException e){
      System.out.println("File not found: " + filename);
      System.exit(1);
    }
    randgen = new Random(randSeed);
     addAllWords();
    if(keyselect){
      this.keyselect = keyselect;
      System.out.println("Key:" + "\n" +  keyToString()); 
    }
    System.out.println("Seed: " + randSeed);
    System.out.println("Bank: " + "\n" + wordsAdded);
  }

  private void clear(){
    for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
        data[i][j] = '_';
	    }
    }
  }

  public String toString(){ 
    String s = "";
    for(int x = 0; x < data.length; x++){
	    for(int y = 0; y < data[y].length; y++){
        s = s + "[" + data[x][y]+"]";
	    }
	    s += "\n";
    }
    return s;
  }

  public String keyToString(){
    String a = "";
    for (int i = 0; i < key.length; i++){
      for (int j = 0; j < key[i].length; j++){
        a += "[" + key[i][j] + " ]";
      }
      a += '\n';
    }
    return a;
  }
  
  private void toFill(){
    char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    for (int i = 0; i < data.length; i++){
      for (int j = 0; j < data.length; j++){
        if(data[i][j] == '_'){
          data[i][j]=letters[randgen.nextInt(26)];
        }
      }
    }
  }

  private boolean addWord(int r, int c, String word, int rowIncrement, int colIncrement){
    int rows = r, cols = c;
    if (colIncrement == 0 && rowIncrement == 0){ 
      return false;
    }
    try{
      for (int i =0; i < word.length(); i++){
        if (data[rows][cols] != '_' && data[rows][cols] != word.charAt(i)){ 
          return false;
        }
        rows += rowIncrement;//runs through the inc
        cols += colIncrement;
      }
    }catch(IndexOutOfBoundsException e){
      return false;
    }
    
    for (int i = 0; i < word.length(); i++){
      data[r][c] = word.charAt(i);
      r+= rowIncrement;
      c+= colIncrement;
    }
    wordsToAdd.remove(word);
    wordsAdded.add(word);
    return true;
  }

private boolean addAllWords(){
  clear();
    
  for (int i = 0; i < 1000; i++){ 
      if (wordsToAdd.size() == 0){
        for (int r = 0; r < data.length; r++){
          for (int c = 0; c < data.length; c++){
            key[r][c] = data[r][c];
          }
        }
        toFill(); 
        return true;
      }
      
      addWord(randgen.nextInt(data.length), 
              randgen.nextInt(data[0].length),
              wordsToAdd.get(randgen.nextInt(wordsToAdd.size())),
              randgen.nextInt(3)-1,
              randgen.nextInt(3)-1);
    }
  
  for (int i = 0; i < data.length; i++){ 
      for (int j = 0; j < data.length; j++){
        key[i][j] = data[i][j];
      }
    }
  toFill(); 
    return false;
  }

 

   public static void main(String[] args){
    boolean  key = false;
    if (args.length < 3){
      System.out.println("Enter rows, columns, or filename"); 
      System.out.println("Optional Parameter seed");
      System.exit(1);
    }
    if (args.length == 3){
      WordSearch game = new WordSearch( Integer.parseInt(args[0]), Integer.parseInt(args[1]),args[2]);
      System.out.println(game);
    }
    if (args.length == 4){
      WordSearch game = new WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]),args[2],Integer.parseInt(args[3]));
      System.out.println(game);
    }
    if (args.length == 5){
      if (args[4].equals("true")){
        key = true;
      }
      WordSearch game = new WordSearch( Integer.parseInt(args[0]),Integer.parseInt(args[1]),args[2], Integer.parseInt(args[3]),key);
      System.out.println(game);
    }
  }
}
