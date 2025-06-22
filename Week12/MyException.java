package Week12;

public class MyException extends Exception {
   private String detail;
   public MyException(String message) 
   {
        super(message);
        this.detail = message;
   }
   @Override
   public String getMessage()
   {
        return "[InvalidTriangle] cause: " + detail;
   }
}
