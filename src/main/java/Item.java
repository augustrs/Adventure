public class Item {
    private String kortNavn;
    private String langNavn;

    public Item(String kortNavn, String langNavn) {
        this.kortNavn = kortNavn;
        this.langNavn = langNavn;
    }

    public String getKortNavn() {
        return kortNavn;
    }

    public String getLangNavn() {
        return langNavn;
    }

    @Override
    public String toString() {
        return langNavn;
    }
}
