// Задание 1.
// Дополнить проект методами записи в файл и чтения из файла. Для этого создать
// отдельный класс и реализовать в нем нужные методы. Для данного класса
// сделайте интерфейс, который и используйте в своей программе. Пример работы с
// интерфейсом Serialazable можно найти в материалах к уроку.
// Класс, представляющий человека
import java.io.IOException;

// Главный класс с точкой входа
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

    // Создаем людей
        Person john = new Person("John", 1950);
        Person mary = new Person("Mary", 1955);
        Person susan = new Person("Susan", 1980);

    // Устанавливаем родительские связи
        susan.setMother(mary);
        susan.setFather(john);
        john.addChild(susan);
        mary.addChild(susan);

    // Добавляем людей в древо
        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(susan);

    // Создаем объект для работы с файлами
        FileOperations fileOps = new FileOperationsImpl();

    // Сохраняем генеалогическое древо в файл
        try {
            fileOps.saveToFile(familyTree, "familyTree.dat");
            System.out.println("Family tree saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    // Загружаем генеалогическое древо из файла
        FamilyTree loadedFamilyTree = null;
        try {
            loadedFamilyTree = fileOps.loadFromFile("familyTree.dat");
            System.out.println("Family tree loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    // Проверяем, что древо загрузилось правильно
        if (loadedFamilyTree != null) {
            for (Person person : loadedFamilyTree.getPeople()) {
                System.out.println("Loaded person: " + person.getName() + ", born in " + person.getBirthYear());
            }
        }
    }
}