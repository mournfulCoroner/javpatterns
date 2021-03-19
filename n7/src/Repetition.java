public class Repetition {
    private boolean made = false;

    public boolean isMade() {
        return made;
    }

    public void setMade(boolean made) {
        this.made = made;
    }

    public void done(Actor a1, Actor a2){
        setMade(true);
    }
}
