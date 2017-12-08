import java.util.Arrays;
public class Sorts{
  public static String d(int[] s){
    String str = "[";
    for (int x: s){
      str += x + ",";
    }
    if (str.length()==1){
      return str+"]";
    }
    return str.substring(0,str.length()-1) + "]";
  }

  public static String name(){
    return "10.Chen.Benny";
  }
  public static boolean isSorted(int[]ary){
    for(int i = 0; i < ary.length-1; i++){
      if (ary[i] > ary[i+1]){
        return false;
      }
    }
    return eturn true;
  }

  public static void bogoSort(int[]ary){
    while(!isSorted(ary)){
      for (int i = 0; i < ary.length; i++){
        int temp = ary[i];
        int newSpot = (int)(Math.random()*ary.length);
        ary[i] = ary[newSpot];
        ary[newSpot] = temp;
      }
    }
  }

  public static void selectionSort(int[] data){
    for (int i = 0; i < data.length; i++){
      int minIndex = i;
      for (int j = i+1; j < data.length;j++){
        if (data[j] < data[minIndex]){
          minIndex = j;
        }
      }
      if (minIndex!=i){
        int hol = data[i];
        data[i] = data[minIndex];
        data[minIndex] = hol;
      }
    }
  }

}
