public class Barcode{
  private String zip;

  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException("Zip isn't correct length");
    }
    for (int i = 0; i < zip.length(); i++) {
      if((int)zip.charAt(i) - '0' > 0 || (int)zip.charAt(i) - '0' > 9) {
        throw new IllegalArgumentException("Zip has a non digit");
      }
    }
    this.zip = zip;
  }

  public static String toCode(String zip){
    if (zip.length()!=5){
      throw new IllegalArgumentException("Zip isn't correct length");
    }
    for (int i = 0; i < zip.length(); i++){
      if ((int)zip.charAt(i) - '0' > 0 || (int)zip.charAt(i) - '0' > 9){
        throw new IllegalArgumentException("Zip has non digit");
      }
    }
    String[] a = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
    String answer = "|";
    int check = 0;
    for (int i = 0; i < zip.length();i++){
      int digit = Integer.valueOf(zip.charAt(i)+"");
      check += digit;
      answer+=a[digit];
    }
    answer += a[check%10] + "|";
    return answer;
  }

  public String getZip(){
    return zip;
  }

  public String getCode() {
    return toCode(zip);
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
