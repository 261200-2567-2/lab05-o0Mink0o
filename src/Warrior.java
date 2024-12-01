public class Warrior implements RPGJob {
    @Override
    public String getJobName() {
        return "Warrior";
    }

    @Override
    public double calculateDamage(int level) {
        return 10 + 2 * level;
    }

    @Override
    public double modifyHP(double baseHP) {
        return baseHP * 1.2; // เพิ่ม HP 20%
    }

    @Override
    public double modifyRunSpeed(double baseSpeed) {
        return baseSpeed; // ไม่มีผลกับความเร็ว
    }
}
