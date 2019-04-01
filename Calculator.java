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
    public static void next(String given, int index){
      String tbr ="";
      MyDeque test = new MyDeque();
      while(index<given.length()){
        while(index<given.length() && given.charAt(index)!=' '){
          tbr+=given.charAt(index);
          index++;
        }
        if(isdouble(tbr)){
          test.addFirst(Double.parseDouble(tbr));
          System.out.println(test);
        }
        else if(tbr!=" "){
          //casting objects returned by MyDeque
          Double second = (Double)test.removeFirst();
          Double first = (Double)test.removeFirst();
          System.out.println(tbr);
          if(tbr.equals("+")){test.addFirst(first+second); System.out.println(second+first);}
          if(tbr.equals("-")){test.addFirst(first-second);}
          if(tbr.equals("*")){test.addFirst(first*second);}
          if(tbr.equals("/")){test.addFirst(first/second);}
          if(tbr.equals("%")){test.addFirst(first%second);}
          System.out.println(test);
        }
        tbr ="";
        index++;
      }
      System.out.print(test);
    }
    //public static double eval(String s){}
    public static void main(String[] args) {
      String  s = "8 2 + 99 9 - * 2 + 9 -";
      next(s,0);
    }
}
