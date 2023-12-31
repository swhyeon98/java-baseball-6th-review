package baseball.view;

public class OutputView {

    public void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
