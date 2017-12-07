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
      int digit = (int)(zip.charAt(i)-'0');
      check += digit;
      answer+=a[digit];
    }
    answer += a[check%10] + "|";
    return answer;
  }

  public static String toZip(String code){
    String answer = "";
    String[] a = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    if (code.length() != 32 ||
      code.charAt(0) != '|' ||
      code.charAt(31) != '|') {
      throw new IllegalArgumentException("Bad Barcode or wrong length");
    }
    int check = 0;
    int Sum = 0;
    String zip = "";
    for (int i = 1; i < 31; i += 5) {
      for (int key = 0; key < 10; key++) {
        if (code.substring(i, i + 5).equals(a[key])) {
          if (i < 25) {
            zip += key;
            check += key;
          }
          else Sum = key;
        }
      }
    }
    if (Sum != check % 10) {
      throw new IllegalArgumentException();
    }
    return zip;
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
