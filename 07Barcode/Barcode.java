public class Barcode{
  private String zip;

  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException();
    }
    for (int x = 0; x < zip.length(); x++) {
      if((int)zip.charAt(x) - '0' > 0 || (int)zip.charAt(x) - '0' > 9) {
        throw new IllegalArgumentException();
      }
    }
    this.zip = zip;
  }

  public String getZip(){
    return zip;
  }

  public String getCode() {
    String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    String answer  = "|";
    int check = 0;
    for (int x = 0; x < zip.length(); x++) {
      answer += a[(int)zip.charAt(x) - '0'];
      check += (int)zip.charAt(x)- '0';
    }
    return answer + a[check % 10] + "|";
    }

    public String toString() {
      return getCode() + "(" + zip + ")";
    }

  public int compareTo(Barcode b) {
    return getZip().compareTo(b.getZip());
    }

  public boolean equals(Barcode b) {
      return getZip().equals(b.getZip());
}
}
