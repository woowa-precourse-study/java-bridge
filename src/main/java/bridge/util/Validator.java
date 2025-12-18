package bridge.util;

public class Validator {

    private static int MIN_LENGTH = 3;
    private static int MAX_LENGTH = 20;

    public static boolean checkNull(String sizeInput){
        return sizeInput == null || sizeInput.isEmpty();
    }

    public static boolean checkRange(int size){
        return size < MIN_LENGTH || size > MAX_LENGTH;
    }
}
