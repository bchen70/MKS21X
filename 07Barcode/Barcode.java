import java.util.*;
public class Barcode implements Comparable<Barcode>{
  private String zip;

  public Barcode(String zip){
    if (zip.length() != 5){
      throw new IllegalArgumentException("Zip isn't correct length");
    }
    try {
      int s;
      s = Integer.parseInt(zip);
    } catch (NumberFormatException e){
      throw new IllegalArgumentException();
    }
    this.zip = zip;
  }

  public static String toCode(String zip){
    if (zip.length()!=5){
      throw new IllegalArgumentException("Zip isn't correct length");
    }
    for (int i = 0; i < zip.length(); i++){
      if (!Character.isDigit(zip.charAt(i))){
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
    return this.getZip().compareTo(b.getZip());
    }

  public boolean equals(Barcode b) {
    return compareTo(b)== 0;
  }

  public static void main(String[]args){

    Barcode a = new Barcode("10282");
    Barcode b = new Barcode("10282");
    Barcode c = new Barcode("10101");

    // System.out.println("a: " + a); //a: |:::||||:::::|:||::|:::|:|::||:| (10282)
    // System.out.println("b: " + b); //b: |:::||||:::::|:||::|:::|:|::||:| (10282)
    // System.out.println("c: " + c); //c: |:::||||::::::||||::::::||::||:| (10101)

      // System.out.println(a.compareTo(b)); //0
      //System.out.println(c.compareTo(a)); //negative
      // System.out.println(a.compareTo(c)); //positive


     // System.out.println(a.equals(b)); //true
     // System.out.println(a.equals(c)); //false


    // System.out.println(toCode("10282")); // returns |:::||||:::::|:||::|:::|:|::||:|
    // System.out.println(toZip("|:::||||:::::|:||::|:::|:|::||:|")); //returns 10282


      // System.out.println(toCode("1234")); //length less than 5
      // System.out.println(toCode("123456")); // length greater than 5
      //System.out.println(toCode("1234z")); //contains non digit

      // Barcode x = new Barcode("123"); //length less than 5
    // Barcode x = new Barcode("123456"); //length greater than 5
    //Barcode x = new Barcode("123ab"); //contains non digit

    // System.out.println(toZip("|||:::||:::||:::||:::||:::||:::")); //length less than 32
    //System.out.println(toZip("|||:::||:::||:::||:::||:::||:::||||"));//length greater than 32

    }
}
