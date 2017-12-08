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
    return true;
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
      int next = data[i];
      int index = i;
      for (int j = i; j < data.length; j++){
        if (data[j] < next){
          next = data[j];
          index = j;
        }
      }
      data[index] = data[i];
      data[i] = next;
    }
  }
  public static void insertionSort(int[] data){
    for (int i = 1; i < data.length; i++){
      int temp = data[i];
      int index = i;
      for (int j = i-1; j >= 0 && data[j] > temp; j--){
        data[j+1] = data[j];
        index = j;
      }
      data[index] = temp;
    }
  }
}
