public class Plate implements Dishes{
    private String form = "";
    private String ornament = "";

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getOrnament() {
        return ornament;
    }

    public void setOrnament(String ornament) {
        this.ornament = ornament;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "form='" + form + '\'' +
                ", ornament='" + ornament + '\'' +
                '}';
    }
}
