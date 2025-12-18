package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {

    // ===== 상수 =====

    static Map<String, Runnable> commands = new HashMap<>();
    static String PREFIX_ERROR="[ERROR] ";
    static final int MAX_RETRY = 10;


    // ===== main / run =====

    public static void main(String[] args) {
            initCommands();
            try{
                run();
            } catch(IllegalStateException e){
                System.out.println(e.getMessage());
            }

    }


    static void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int num=0;
        int times=0;
        try{
            System.out.println("다리의 길이를 입력해주세요.");
            // 숫자 입력
            String number = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    Validator::validateIsNumber,
                    input -> Validator.validateRange(input, 3, 20)
            ));
            num=Integer.parseInt(number);


        } catch(IllegalArgumentException | NoSuchElementException e){ // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR+e.getMessage());
        }

        // 정답이 되는 다리 건설
        BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeAnswer=bridgeMaker.makeBridge(num);
        List<String> copyAnswer=new ArrayList<>();
        List<String> moveUp = new ArrayList<>();
        List<String> moveDown= new ArrayList<>();
        String gameResult="";

        while (true){
            times+=1;
            copyAnswer.addAll(bridgeAnswer);  // 깊은 복사
            List<List<String>> result=playGame(num,copyAnswer);
            moveUp = result.get(1);
            moveDown = result.get(2);
            gameResult=result.get(0).get(0);

            if (gameResult.equals("성공") || gameResult.equals("Restart")){
                break;
            }
        }


        System.out.println("최종 게임 결과");
        System.out.println("[ "+String.join(" | ",moveUp)+" ]");
        System.out.println("[ "+String.join(" | ",moveDown)+" ]");
        System.out.println("게임 성공 여부: "+gameResult);
        System.out.println("총 시도한 횟수: "+times);

    }


    static String restartGame(){
        try{
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            // 숫자 입력
            String move = readInputWithRetry(List.of(
                    Validator::validateNotBlank,
                    Validator::validateRestart
            ));
            if (move.equals("R")){
                return "Restart";
            }

        } catch(IllegalArgumentException | NoSuchElementException e){ // 입력안함은 여기서 자동 제거
            System.out.println(PREFIX_ERROR+e.getMessage());
        }
        return "Quit";
    }

    static List<List<String>> playGame(int num, List<String> bridgeAnswer){
        List<String> moveUp=new ArrayList<>();
        List<String> moveDown=new ArrayList<>();
        int idx=0;
        String result="성공";
        String isRestart="Quit";
        while (moveUp.size()<num){
            try{
                System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
                // 숫자 입력
                String move = readInputWithRetry(List.of(
                        Validator::validateNotBlank,
                        Validator::validateMove
                ));

                if (move.equals("U") && bridgeAnswer.get(idx).equals("U")){
                    moveUp.add("O");
                    moveDown.add(" ");
                }
                else if(move.equals("U") && bridgeAnswer.get(idx).equals("D")){
                    moveUp.add("X");
                    moveDown.add(" ");
                    result="실패";
                    isRestart=restartGame();
                    break;
                }
                else if(move.equals("D") && bridgeAnswer.get(idx).equals("D")){
                    moveUp.add(" ");
                    moveDown.add("O");
                }
                else if(move.equals("D") && bridgeAnswer.get(idx).equals("U")){
                    moveUp.add(" ");
                    moveDown.add("X");
                    result="실패";
                    isRestart=restartGame();
                    break;
                }
                if (moveUp.size()<num){
                    System.out.println("[ "+String.join(" | ",moveUp)+" ]");
                    System.out.println("[ "+String.join(" | ",moveDown)+" ]");
                }
                idx+=1;

            } catch(IllegalArgumentException | NoSuchElementException e){ // 입력안함은 여기서 자동 제거
                System.out.println(PREFIX_ERROR+e.getMessage());
            }

        }
        return List.of(List.of(result,isRestart),moveUp,moveDown);

    }

    static void initCommands() {
        commands.put("UU", Application::upbridge);
        commands.put("DD", Application::downbridge);
    }

    static void upbridge() {
        System.out.println("출석 수정");
    }

    static void downbridge() {

        System.out.println("출석 수정");
    }

    /**
     * 입력 관련 메서드
     * 아래와 같이 검증들을 input 파라미터로 넣어준다.
     *
     *             String number = readInputWithRetry(List.of(
     *                     Validator::validateNotBlank,
     *                     Validator::validateNotNumber,
     *                     input -> Validator.validateRange(input, 1, 4),
     *                     input -> Validator.validateMaxLength(input, 4)
     *
     *             ));
     * **/

    static String readInput(List<Validator> validators) {
        String input = Console.readLine();
        System.out.println(input);
        for (Validator v : validators) {
            v.validate(input);
        }
        return input;
    }


    static String readInputWithRetry(List<Validator> validators) {
        int retry = 0;
        while (true) {
            try {
                return readInput(validators);
            } catch (IllegalArgumentException | NoSuchElementException e) {
                retry++;
                System.out.println(PREFIX_ERROR + e.getMessage());

                if (retry >= MAX_RETRY) {
                    throw new IllegalStateException("입력 횟수를 초과했습니다.");
                }
            }
        }
    }


}

