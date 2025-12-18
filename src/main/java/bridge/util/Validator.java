package bridge.util;

public class Validator {

    private static int MIN_LENGTH = 3;
    private static int MAX_LENGTH = 20;

    public static void checkNull(String sizeInput){
        if(sizeInput == null ){
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE_ERROR);
        }
    }

    public static void checkRange(int size){
        if(size < MIN_LENGTH || size > MAX_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.INPUT_RANGE_ERROR);
        }
    }

    public static void checkMoving(String movingInput){
        if(!movingInput.equals("U") && !movingInput.equals("D")){
            throw new IllegalArgumentException(ErrorMessage.INPUT_SELECT_ERROR);
        }
    }

    public static void checkCommand(String commandInput){
        if(!commandInput.equals("R") && !commandInput.equals("Q")){
            throw new IllegalArgumentException(ErrorMessage.INPUT_RETRY_ERROR);
        }
    }
}
