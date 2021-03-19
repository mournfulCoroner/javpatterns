public class Performance {
    public void set(Repetition rep){
        if(rep.isMade()) {
            System.out.println("Выступление прошло успешно");
            rep.setMade(false);
        }
    }
}
