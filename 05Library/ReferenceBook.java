class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String writer,String name,String isbn,String callN,String col){
      super(writer,name,isbn,callN);
      collection = col;
    }

  
  public String getCol(){
    return collection;
  }

    public void setCol(String col){
	collection = col;
    }

    public void checkout(String patron, String due){
	System.out.println("cannot check out a reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "non-circulating reference book";
    }

    public String toString(){
      return super.toString() + "Collection" + getCol();
    }
    
}
