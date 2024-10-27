import java.io.*;

// Интерфейс для операций с файлами
interface FileOperations {
    void saveToFile(FamilyTree familyTree, String fileName) throws IOException;
    FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
    // Реализация интерфейса для операций с файлами
class FileOperationsImpl implements FileOperations {
    @Override
    public void saveToFile(FamilyTree familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }
    @Override
    public FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        }
    }
}