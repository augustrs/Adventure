public class Food extends Item {

    private int healingPoint;

    public Food(String kortNavn, String langNavn, int healingPoint) {
        super(kortNavn, langNavn);
        this.healingPoint = healingPoint;
    }

    public String toString() {
        return super.toString() + " (" + healingPoint + "HP)";
    }

    public int getHealingPoint() {
        return healingPoint;
    }
}
