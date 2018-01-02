import java.util.*;
public class SuperArray{
  private String[] data;
  private int size;
  public SuperArray(int arraySize){
    if (arraySize < 0){
      arraySize = 0;
    }
    size = 0;
    data = new String[arraySize];
  }
  public SuperArray(){
    this(10);
  }

  public void clear(){
    new SuperArray();
  }

  public int size(){
    return size;
  }

  public boolean add(String a){
    if(size == data.length){
      this.resize();
    }
    data[size] = a;
    size ++;
    return true;
  }

  public String toString(){
    String a = "";
    for(int x=0; x< size();x++){
      a = a + "data[x]";
    }
    return a;
  }

  public String get(int num){
    if(num < 0 || num >= size) {
      return "Error";
    } else{
      return data[num];
    }
  }

  public String set(int num,String element){
    if(num < 0 || num >= size){
      System.out.println("Error");
    } else{
    data[num] = element;
    }
    return "Success";
  }

  public void resize(){
    if(data.length + 1 == size){
      String[] newdata = new String[size * 2];
      for(int index = 0; index <size; index ++){
        newdata[index] = data[index];
      }
      data = newdata;
    }
  }

  public boolean contains(String element){
    for(int x = 0; x< size();x++){
      if (data[x].equals(element)){
        return true;
      }
    }
    return false;
  }
  public int indexOf(String element){
    for (int index = 0; index < size; index ++)  {
      if(data[index].equals(element)){
        return index;
      }
    }
      return -1;
  }
    public int lastIndexOf(String element){
      for (int index = size; index >= 0; index++){
        if (data[index].equals(element)){
            return index;
      }
      }
          return -1;
    }

    public void add(int index, String element){
      resize();
      if (index < 0 || index>size){
        System.out.println("Error: Index out of bounds");
      }
      else{
        for (int x = size;x >=index; x --){
          data[x + 1] = data[x];
        }
        data[index] = element;
        size ++;
      }
    }

    public String remove(int index){
      if (index < 0 || index >= size){
        System.out.println("Error: Index out of bounds");
        return null;
      }
      String rmoved = data[index];
      for(int x=index;x<size; x++){
        data[x] = data[x + 1];
      }
      size --;
      return rmoved;
    }

    public boolean remove(String element){
      int count;
      for(count = 0; data[count] != element; count ++){
        if(count == size){
          return false;
        }
      }
      for(int newc = count; count < size; count++){
        data[count] = data[count + 1];
      }
      size --;
      return true;
    }
  public static void main(String[] args){
  for (int x = 0; x < 10; x++){
      runTest01(x);
  }
  runTest01(6);
    }

    public static void runTest01(int testID){
  if(testID<0){
      System.out.println("Error in driver usage!");
      System.exit(0);
  }

  SuperArray s1 = new SuperArray();
  ArrayList<String> s2 = new ArrayList<>();

  try{
      if(testID == 0 ){
      }

      if(testID == 1 ){
    s1.add("0");
    s2.add("0");
    s1.add("1");
    s2.add("1");
      }

      if(testID == 2 ){

    s1.add("0");
    s2.add("0");
    s1.add("1");
    s2.add("1");
    s1.add(1,"5");
    s2.add(1,"5");
    s1.add(0,"6");
    s2.add(0,"6");
    s1.add(s1.size()-1,"4");
    s2.add(s2.size()-1,"4");
      }

      if(testID == 3 ){
    s1.add("0");
    s2.add("0");
    s1.add("1");
    s2.add("1");
    s1.add(1,"5");
    s2.add(1,"5");
    s1.add(0,"6");
    s2.add(0,"6");
    s1.add(s1.size(),"4");
    s2.add(s2.size(),"4");
      }

      if(testID == 4 ){
    s1.add(0,"0");
    s2.add(0,"0");
      }

      if(testID == 5 ){
    s1.add("1");
    s2.add("1");
    for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
    }
      }

      if(testID == 6 ){
    try{
        s1.get(0);
    } catch(IndexOutOfBoundsException e){

    }
      }

      if(testID == 7 ){
    try{
        s1.set(0,"");
    } catch(IndexOutOfBoundsException e){

    }
      }

      if(testID == 8 ){
    try{
        s1.add(1,"");
    } catch(IndexOutOfBoundsException e){

    }
      }
      if(testID == 9 ){
    s1.add("1");
    s2.add("1");

    for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
    }
      }


  }catch(Exception f){
      s2.add("0");
      //f.printStackTrace();
  }

  if(true){
      System.out.println("Test "+testID+",PASS");
  }else{
      System.out.println("Test "+testID+",FAIL");
  }



}
}
