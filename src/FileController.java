import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileController extends MemoryController {

    private File dataFolder;

    private File contactFolder;

    public FileController(String dataPath) {
        dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        contactFolder = new File("data/contacts");
        if (!contactFolder.exists()) {
            contactFolder.mkdirs();
        }

        if (contactFolder.exists() && contactFolder.isDirectory()) {
            File[] files = contactFolder.listFiles((d, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(file.toPath());

                        int id = 0;
                        String nom = null, cognom = null, phone = null, mail = null;

                        for (String line : lines) {
                            line = line.trim();
                            if (line.startsWith("ID:")) id = Integer.parseInt(line.replace("ID:", "").trim());
                            else if (line.startsWith("Name:")) nom = line.replace("Name:", "").trim();
                            else if (line.startsWith("Surname:")) cognom = line.replace("Surname:", "").trim();
                            else if (line.startsWith("Phone:")) phone = line.replace("Phone:", "").trim();
                            else if (line.startsWith("Email:")) mail = line.replace("Email:", "").trim();
                        }

                        if (id > 0 && nom != null && cognom != null && phone != null && mail != null) {
                            contactsList.put(id, new Contacte(nom, cognom, phone, mail));
                            if (id >= idCount) {
                                idCount = id + 1;
                            }
                        }

                    } catch (IOException e) {
                        System.err.println("Error reading file: " + file.getName());
                    }
                }
            }
        }
    }


    @Override
    public void contactCreation(String[] info) {
        int currentId = idCount;
        super.contactCreation(info);
        Contacte c = contactsList.get(currentId);

        if (c == null) {
            System.err.println("Error: No se pudo encontrar el contacto recién creado con ID: " + currentId);
            return;
        }
        try (FileWriter fw = new FileWriter(contactFolder + "/" + c.getID() + ".txt")) {
            fw.write(c.toString());
            System.out.println("Contacto guardado en archivo: " + c.getID() + ".txt");
        } catch (IOException e) {
            System.err.println("Error al guardar el contacto: " + e.getMessage());
        }
    }



    @Override
    public Contacte updatingContacte(int selectedID, String changeName, String changeSur, String changePhone, String changeMail) {
        try {
            super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
            FileWriter updateContact = new FileWriter (contactFolder + "/" + selectedID + ".txt", false);
            updateContact.write(String.valueOf(contactsList.get(selectedID - 1)));
            updateContact.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.updatingContacte(selectedID, changeName, changeSur, changePhone, changeMail);
    }

    @Override
    public void deleteContact(int idCount) {
        super.deleteContact(idCount);
        try {
            File deletefile = new File(contactFolder + "/" + idCount + ".txt");
            if (deletefile.exists()) {
                System.out.println("File deleted successfully");
            } else if (!deletefile.delete()) {
                System.out.println("Could not delete file: " + deletefile.getName());
            } else {
                System.out.println("The file does not exist: " + deletefile.getName());
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting contact file: " + idCount, e);
        }
    }
}
