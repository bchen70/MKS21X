import java.util.*;
public class SuperArray implements Iterable<String>{
  private String[] data;
  private int size;

  public Iterator<String> iterator(){
    return new SuperArrayIterator(data,size);
  }
  public SuperArray(){
    data = new String[10];
    size = 0;
  }

  public void clear(){
    new SuperArray();
  }

  public int size(){
    return size;
  }

  public boolean add(String element){
    if (size == data.length){
      String[] newray = new String[size+1];
      for (int i = 0; i < size; i++){
        newray[i] = data[i];
      }
      newray[size] = element;
      size++;
      data = newray;
      return true;
    }
    data[size] = element;
    size++;
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
}
