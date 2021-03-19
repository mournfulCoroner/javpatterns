public class AppleMachine {
    private Apple apple;

    public AppleMachine(Apple apple) {
        this.apple = apple;
    }

    public Apple makeApple() throws CloneNotSupportedException {
        return (Apple) this.apple.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Apple app = null;
        Apple prototype = new BigApple();
        AppleMachine cloner = new AppleMachine(prototype);
        for (int i = 0; i < 50; i++)
            app = cloner.makeApple();
    }
}
