public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static boolean isdouble(String f){
      try {
        Double.parseDouble(f);
        return true;}
      catch (NumberFormatException e) {
        return false;}
    }
    public static void next(String given, int index){
      String tbr ="";
      while(index<given.length()){
      while(index<given.length() && given.charAt(index)!=' '){
        tbr+=given.charAt(index);
        index++;
      }
      if(isdouble(tbr)){
        System.out.println(tbr+ " This is a number");
      }
      else{System.out.println(tbr +" This is not a number");}
      tbr ="";
      index++;
    }
    }
    //public static double eval(String s){}
    public static void main(String[] args) {
      String  s = "8 2 + 99 9 - * 2 + 9 -";
      next(s,0);
    }
}
