import java.io.*;
import java.util.Scanner;

public class Services {
    static String[] personsData = checkInputData();
    static String[] patronymics = {"ович", "овна", "евич", "евна", "ич", "ична"};
    static String[] surnames = {"ов", "ова", "ев", "ева", "ин", "ина", "ын", "ына"};
    static String[] notNames = {"ович", "овна", "евич", "евна", "ич", "ична", "ов", "ова", "ев", "ева", "ин", "ина", "ын", "ына"};

    public static Person createPerson(){
        Person human = new Person();
        for(String personData : personsData){
            if (personData.contains(".") &&
                    (personData.replace(".", "").chars().allMatch(Character::isDigit))) {
                human.setBirthDate(personData);
            } else if (personData.chars().allMatch(Character::isDigit)) {
                human.setPhoneNumber(personData);
            } else if ((personData.equalsIgnoreCase("Ж")) ||
                    (personData.equalsIgnoreCase("М"))) {
                human.setGender(personData);
            } else if ((personData.length() > 1) && (personData.chars().allMatch(Character::isLetter))) {
                if (isName(personData)) {
                    human.setName(personData);
                }
                if (isSurname(personData)) {
                    human.setSurName(personData);
                }
                if (isPatronymic(personData)) {
                    human.setLastName(personData);
                }
            }
        }
        if (human.getName() == null) {
            throw new RuntimeException("Поле \"имя\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getLastName() == null) {
            throw new RuntimeException("Поле \"отчество\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getSurname() == null) {
            throw new RuntimeException("Поле \"фамилия\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getGender() == null) {
            throw new RuntimeException("Поле \"пол\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getBirthDate() == null) {
            throw new RuntimeException("Поле \"дата рождения\" заполнено некорректно, пожалуйста, проверьте ввод!");
        } else if (human.getPhoneNumber() == null) {
            throw new RuntimeException("Поле \"номер телефона\" заполнено некорректно, пожалуйста, проверьте ввод!");
        }
        return human;
    }
    public static String[] checkInputData() {
        System.out.println(
                "Пожалуйста, введите данные через пробел (Фамилия, Имя, Отчество, пол, дата рождения, номер телефона):"
        );
        Scanner sc = new Scanner(System.in);
        String[] persons = sc.nextLine().split(" ");
        if (persons.length != 6) {
            throw new RuntimeException("Не хватает данных, пожалуйста, проверьте ввод");
        } else {
            personsData = persons;
            return personsData;
        }
    }
    public static boolean isName(String personDatum) {
        for (String notName : notNames) {
            if (personDatum.endsWith(notName)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isSurname(String personDatum) {
        for (String surname : surnames) {
            if (personDatum.endsWith(surname)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPatronymic(String personDatum) {
        for (String patronymic : patronymics) {
            if (personDatum.endsWith(patronymic)) {
                return true;
            }
        }
        return false;
    }
    public static void writeInUserFile() {
        File writer = new File(createPerson().getSurname() + ".txt");
        try (FileWriter userFile = new FileWriter(writer, true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(userFile);
            bufferedWriter.write(createPerson() + "\n");
            bufferedWriter.close();
            System.out.printf("Операция записи в файл %s успешно завершена!\n" +
                    "Добавлена следующая строка: %s", writer, createPerson());
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
