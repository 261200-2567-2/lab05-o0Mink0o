import java.util.Scanner;

public class RPGMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // สร้างตัวละคร
        System.out.print("Enter your character's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter base run speed: ");
        double runSpeed = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        // เลือก Job

        System.out.println("Choose your class:");
        System.out.println("1. Warrior");
        System.out.println("2. Berserker");

        int jobChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        RPGJob job;
        if (jobChoice == 1) {
            job = new Warrior();
        } else if (jobChoice == 2) {
            job = new Berserker();
        } else {
            System.out.println("Invalid choice! Defaulting to Warrior.\n");
            job = new Warrior();
        }

        // สร้างตัวละครด้วย Job ที่เลือก
        RPGCharacter character = new RPGCharacter(name, 1, runSpeed, job);

        // เลือกอุปกรณ์
        character.equipItems();

        // สร้างมอนสเตอร์
        Monster monster1 = new Monster("Goblin", 60, 10);
        Monster monster2 = new Monster("Orc", 85, 15);
        Monster monster3 = new Monster("Dragon", 125, 25);

        Monster[] monsters = {monster1, monster2, monster3};

        while (character.isAlive()) {
            // แสดงสถานะตัวละคร
            character.printState();

            // เลือกมอนสเตอร์ที่จะโจมตี
            System.out.println("Choose a monster to attack:");
            for (int i = 0; i < monsters.length; i++) {
                if (monsters[i].isAlive()) {
                    System.out.printf("%d. %s (HP: %.2f)\n", i + 1, monsters[i].getName(), monsters[i].getHP());
                }
            }

            int choice = scanner.nextInt();
            if (choice < 1 || choice > monsters.length || !monsters[choice - 1].isAlive()) {
                System.out.println("Invalid choice! Try again.\n");
                continue;
            }

            Monster selectedMonster = monsters[choice - 1];

            // ตัวละครโจมตีมอนสเตอร์
            double damage = character.attack();
            selectedMonster.takeDamage(damage);
            System.out.printf("You dealt %.2f damage to %s.\n", damage, selectedMonster.getName());

            // มอนสเตอร์โต้กลับ
            if (selectedMonster.isAlive()) {
                double monsterDamage = selectedMonster.attack();
                character.takeDamage(monsterDamage);
                System.out.printf("%s dealt %.2f damage to you.\n", selectedMonster.getName(), monsterDamage);
            } else {
                System.out.println(selectedMonster.getName() + " is defeated!\n");
                character.levelUp();
            }

            // ตรวจสอบว่ามอนสเตอร์ทั้งหมดตายแล้วหรือไม่
            boolean allMonstersDefeated = true;
            for (Monster monster : monsters) {
                if (monster.isAlive()) {
                    allMonstersDefeated = false;
                    break;
                }
            }

            if (allMonstersDefeated) {
                System.out.println("All monsters are defeated! You win!\n");
                break;
            }
        }

        if (!character.isAlive()) {
            System.out.println("You have been defeated. Game Over.\n");
        }

        scanner.close();
    }
}
