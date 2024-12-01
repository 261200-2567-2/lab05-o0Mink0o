
import java.util.*;

public class RPGCharacter {
    private String name;
    private int level;
    private double baseRunSpeed;
    private double currentHP;
    private double maxHP;
    private double maxMana;
    private double currentMana;
    private Weapon weapon;
    private RPGJob job;

    public RPGCharacter(String name, int level, double baseRunSpeed, RPGJob job) {
        this.name = name;
        this.level = level;
        this.baseRunSpeed = baseRunSpeed;
        this.job = job;
        calculateStats();
    }

    private void calculateStats() {
        this.maxHP = 100 + 10 * level;
        this.maxMana = 50 + 2 * level;
        this.currentHP = maxHP;
        this.currentMana = maxMana;
    }

    public boolean isAlive() {
        return currentHP > 0;
    }

    public void takeDamage(double damage) {
        this.currentHP -= damage;
        if (this.currentHP < 0) {
            this.currentHP = 0;
        }
        System.out.printf("%s takes %.2f damage, remaining HP: %.2f\n", name, damage, currentHP);
    }

    public void levelUp() {
        level++;  // เพิ่มเลเวล
        calculateStats();  // คำนวณค่าสถานะใหม่เมื่อเลเวลเพิ่มขึ้น
        System.out.println("Congratulations! " + name + " has leveled up to level " + level + "!");
    }

    public void equipItems() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a weapon to equip:");
        System.out.println("1. Sword");
        System.out.println("2. Shield");
        System.out.println("3. War Axe");

        int choice = sc.nextInt();
        sc.nextLine();  // Clear buffer

        switch (choice) {
            case 1:
                Weapon sword = new Sword(1, 20, "Basic Sword");
                equipWeapon(sword);
                break;
            case 2:
                Weapon shield = new Shield(1, 10, "Basic Shield");
                equipWeapon(shield);
                break;
            case 3:
                Weapon warAxe = new WarAxe(1, 30, "War Axe");
                equipWeapon(warAxe);
                break;
            default:
                System.out.println("Invalid choice! No weapon equipped.");
        }
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        this.baseRunSpeed -= weapon.getRunSpeedPenalty();
    }

    public double attack() {
        double baseDamage = job.calculateDamage(level);
        if (weapon != null) {
            baseDamage += weapon.getDamage();  // เพิ่มดาเมจจากอาวุธ
        }
        return baseDamage;
    }

    public void printState() {
        System.out.println("===== Character State =====");
        System.out.printf("Name: %s\nLevel: %d\nHP: %.2f/%.2f\nMana: %.2f/%.2f\nRun Speed: %.2f\n",
                name, level, currentHP, maxHP, currentMana, maxMana, baseRunSpeed);
        System.out.println("Job: " + job.getJobName());
        if (weapon != null) {
            System.out.println("Weapon: " + weapon.getName() + " (Damage: " + weapon.getDamage() + ")");
        } else {
            System.out.println("Weapon: None");
        }
        System.out.println("==========================");
    }

}
