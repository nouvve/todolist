
public class Zadanie {
    private String nazwa;
    private String opis;
    private boolean czyskonczone;


    public Zadanie(String nazwa, String opis){
        this.nazwa = nazwa;
        this.opis = opis;
        this.czyskonczone = false;
    }

    public void ustawJakoSkonczone(boolean czyskonczone) {
        this.czyskonczone = czyskonczone;
    }

    @Override
    public String toString() {
        return (czyskonczone ? "[x] - " : "[ ] - ") + nazwa + ": " + opis;
    }

}
