public class WarAxe implements Weapon {
    private int level;
    private double baseDamage;
    private String name;

    public WarAxe(int level, double baseDamage, String name) {
        this.level = level;
        this.baseDamage = baseDamage;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getDamage() {
        return baseDamage + 5 * level;
    }

    @Override
    public double getRunSpeedPenalty() {
        return 3 + 2 * level; // ตัวอย่าง: ความเร็วลดลงตามเลเวล
    }
}
