public class Monster {
    private String name;
    private double hp;
    private double attackDamage;

    public Monster(String name, double hp, double attackDamage) {
        this.name = name;
        this.hp = hp;
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public double getHP() {
        return hp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public double attack() {
        return attackDamage;
    }

    public void takeDamage(double damage) {
        hp = Math.max(0, hp - damage);
    }
}
