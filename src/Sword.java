public class Sword implements Weapon {
    private int level;
    private double baseDamage;
    private String name;

    public Sword(int level, double baseDamage, String name) {
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
        return baseDamage + 3 * level; // คำนวณ damage ตามเลเวล
    }

    @Override
    public double getRunSpeedPenalty() {
        return 1 + level; // คำนวณค่าลดความเร็วการวิ่งตามเลเวล
    }
}
