public class Shield implements Weapon {
    private int level;
    private double baseDamage;
    private String name;

    public Shield(int level, double baseDamage, String name) {
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
        return baseDamage; // ค่าความเสียหายของโล่จะคงที่
    }

    @Override
    public double getRunSpeedPenalty() {
        return 2 + level; // ลดความเร็วตามเลเวล
    }
}
