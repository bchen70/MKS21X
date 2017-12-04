abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String writer, String name, String isbn, String callN){
      setAuthor(writer);
      setTitle(name);
      setISBN(isbn);
      setCallNum(callN);
    }

    public String getCallNum(){
      return callNumber;
    }

    public void setCallNum(String callN){
      callNumber = callN;
    }

    abstract void checkout(String patron, String due);

    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook b){
      return getCallNum().compareTo(b.getCallNum());
    }

    public String toString(){
      return  getCallNum() + ":" + circulationStatus();
    }
}
