public class Food extends Item {

    private int healingPoint;
    public Food(String kortNavn, String langNavn, int healingPoint) {
        super(kortNavn,langNavn);
        this.healingPoint=healingPoint;
    }
Food f1 = new Food("æble", "Et grønt æble", 5);
}
