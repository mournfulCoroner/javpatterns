public class Theatre {
    private Actor a1;
    private Actor a2;
    Repetition rep;
    Performance per;

    public Theatre(){
        this.a1 = new Actor();
        this.a2 = new Actor();
        this.rep = new Repetition();
        this.per = new Performance();
    }

    public void theaterWork(){
        rep.done(a1, a2);
        per.set(rep);
    }
}
