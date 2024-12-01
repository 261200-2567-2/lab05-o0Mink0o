public class Berserker implements RPGJob {
    @Override
    public String getJobName() {
        return "Berserker";
    }

    @Override
    public double calculateDamage(int level) {
        return 15 + 3 * level;
    }

    @Override
    public double modifyHP(double baseHP) {
        return baseHP * 0.8; // ลด HP 20%
    }

    @Override
    public double modifyRunSpeed(double baseSpeed) {
        return baseSpeed * 1.1; // เพิ่มความเร็ว 10%
    }
}
