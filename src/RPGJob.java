public interface RPGJob {
    String getJobName();
    double calculateDamage(int level);
    double modifyHP(double baseHP);
    double modifyRunSpeed(double baseSpeed);
}
