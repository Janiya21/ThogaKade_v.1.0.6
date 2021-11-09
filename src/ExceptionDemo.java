public class ExceptionDemo {
    public static void main(String[] args) {

            System.out.println("Main Start");
            int x = 10;
        try {
            int y = x / 0;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
            System.out.println("Main End");

    }
}
