import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileController extends Controller {

    private File dataFolder;

    private File contactFolder;

    public FileController(String dataPath) {

        dataFolder = new File("data");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
            System.out.println("Missing data directory created.");
        }

        contactFolder = new File("data/contacts");
        if (!contactFolder.exists()) {
            contactFolder.mkdirs();
            System.out.println("Missing contacts directory created.");
        }

        if (contactFolder.exists() && contactFolder.isDirectory()) {
            // Obtenim la llista de fitxers dins el directori
            File[] files = contactFolder.listFiles((d, name) -> name.endsWith(".txt"));
            if (files != null && files.length > 0) {
                for (File file : files) {
                    try {
                        List<String> lines = Files.readAllLines(file.toPath());
                        System.out.println("Carregant fitxer: " + file.getName());
                        for (String line : lines) {
                            int id = 0;
                            String nom = null;
                            String cognom = null;
                            String phone = null;
                            String mail = null;
                            line = line.trim();
                            if (line.startsWith("ID:")) {
                                id = Integer.parseInt(line.replace("ID:", "").trim());
                            } else if (line.startsWith("Name:")) {
                                nom = line.replace("Name:", "").trim();
                            } else if (line.startsWith("Surname:")) {
                                cognom = line.replace("Surname:", "").trim();
                            } else if (line.startsWith("Phone:")) {
                                phone = line.replace("Phone:", "").trim();
                            } else if (line.startsWith("Email:")) {
                                mail = line.replace("Email:", "").trim();
                            }

                            if (id != 0 && nom != null && cognom != null && phone != null && mail != null) {
                                contactsList.add(new Contacte(id, nom, cognom, phone, mail));
                                id = 0;
                                nom = null;
                                cognom = null;
                                phone = null;
                                mail = null;
                            }
                        }

                    } catch (IOException e) {
                        System.err.println("Error llegint el fitxer " + file.getName() + ": " + e.getMessage());
                    }
                }
            } else {
                System.out.println("No hi ha fitxers .txt al directori.");
            }
        } else {
            System.err.println("El directori no existeix o no és vàlid.");
        }
    }





    @Override
    public void contactCreation(String[] info) {
        try {
            super.contactCreation(info);
            FileWriter contact = new FileWriter(contactFolder + "/" + idCount + ".txt", true);
            contact.write(String.valueOf(contactsList.get(idCount - 1)));
            contact.close();
            setIdCount(idCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
