public class OrderedSuperArray extends SuperArray{
  /*constructor initializes an empty List*/
  public OrderedSuperArray(){
      super();
  }

  /*call the proper add.*/
  public void add(int index, String value){
      add(value);
  }

  /*Write this method and any
    appropriate helper methods.*/
  public boolean add(String value){
      if (super.size()== 0){
	  super.add(0,value);
      }
      else{
	  for (int count = 0; count < super.size(); count ++){
	      if (value.compareTo(super.get(count)) <  0){
		  super.add(count,value);
	      }
	      return true;
	  }
      }
      return true;
  }
}
