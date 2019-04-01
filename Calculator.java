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
    @SuppressWarnings("unchecked")
    public static double eval(String given){
      int index=0;
      String tbr ="";
      MyDeque test = new MyDeque();
      while(index<given.length()){
        while(index<given.length() && given.charAt(index)!=' '){
          tbr+=given.charAt(index);
          index++;
        }
        if(isdouble(tbr)){
          test.addFirst(Double.parseDouble(tbr));
        }
        else if(tbr!=" "){
          //casting objects returned by MyDeque
          Double second = (Double)test.removeFirst();
          Double first = (Double)test.removeFirst();
          if(tbr.equals("+")){test.addFirst(first+second);}
          if(tbr.equals("-")){test.addFirst(first-second);}
          if(tbr.equals("*")){test.addFirst(first*second);}
          if(tbr.equals("/")){test.addFirst(first/second);}
          if(tbr.equals("%")){test.addFirst(first%second);}
        }
        tbr ="";
        index++;
      }
      double ss = (Double)test.removeFirst();
      return ss;
    }
    public static void main(String[] args) {
      System.out.println(eval("10 2.0 +"));
      System.out.println(eval("11 3 - 4 + 2.5 *") );
      System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
      System.out.println(eval("1 2 3 4 5 + * - -"));

    }
}
