import java.util.*;
public class OrderedSuperArray extends SuperArray{
  public OrderedSuperArray(){
    super();
  }
  public OrderedSuperArray(int size){
    super(size);
  }

 public OrderedSuperArray(String [] ary){
    super();
    for (String x: ary){
      add(x);
    }
 }
  public void add(int index, String value){
      add(value);
  }

  public int findIndex(String element){
    for (int i = 0; i <size(); i ++){
      if (element.compareTo(get(i)) <= 0){
        return i;
      }
    }
    return size();
  }

  public int indexOfBinary(String element){
    int start = 0;
    int end = size()-1;
    int middle = 0;
    while (start <= end){
      middle = ( start + end )/2;
      if (element.compareTo(get(middle))<0) end = middle-1;
      else if (element.compareTo(get(middle))>0) start = middle +1;
      else{
        while(middle >0 && get(middle-1)==element) middle-=1;
        return middle;
      }
    }
    return -1;
  }

  public int findIndexBinary(String element){
    int start = 0;
    int end = size()-1;
    int i= 0;
    while (start <= end){
      i = ( start + end )/2;
      if (element.compareTo(get(i))<0) end = i-1;
      else if (element.compareTo(get(i))>0) start = i +1;
      else{
        while(i >=1 && get(i-1)==element) i-=1;
        return i;
      }
    }
    return start;
  }

  public int lastIndexOfBinary(String element){
    int index = indexOfBinary(element);
    while (index < size()-1&&  element.compareTo(get(index+1))==0){
      index++;
    }
    return index;
  }

  public boolean add(String value){
    int index = findIndexBinary(value);
    super.add(index, value);

    return true;
  }
  public static void runTest02(int testID){

  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }

  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();

  try{
    if(testID == 0 ){
    }

    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
    }

    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("1");
      s2.add("1");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }

    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }

    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){

      }
    }

    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){

      }
    }

    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");

      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }


  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }

  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
  }

public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(s.get(i) != a.get(i)){
          return false;
        }
      }
      return true;
    }
    return false;
  }


}
