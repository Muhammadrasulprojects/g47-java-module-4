package lesson.lesson11.miniProject;

public enum QuestionLevelEnum {
    HARD(3),
    MEDIUM(2),
    EASY(1),
    ;

    private final int ball;

    QuestionLevelEnum(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }
}
