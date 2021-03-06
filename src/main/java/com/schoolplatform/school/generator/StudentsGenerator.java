package com.schoolplatform.school.generator;

import com.schoolplatform.school.entity.student.Student;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Component
public class StudentsGenerator {

    public final File surnamesFile = new File(
            "G:\\GitHub\\schoolPlatform\\src\\main\\resources\\generate students\\Surnames.txt");
    public final File manNamesFile = new File(
            "G:\\GitHub\\schoolPlatform\\src\\main\\resources\\generate students\\Man names.txt");
    public final File womanNamesFile = new File(
            "G:\\GitHub\\schoolPlatform\\src\\main\\resources\\generate students\\Woman names.txt");
    public List<String> surnames = new ArrayList<>();
    public List<String> manNames = new ArrayList<>();
    public List<String> womanNames = new ArrayList<>();
    public final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd",
            Locale.ENGLISH);
    public Date minAgeForEnterASchool;
    public Date maxAgeForEnterASchool;


    public StudentsGenerator() {
        try {
            minAgeForEnterASchool = DATE_FORMAT.parse("2014.02.20");
            maxAgeForEnterASchool = DATE_FORMAT.parse("2003.02.20");
            this.initializeAllListsFromFiles();

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public List<String> listFromFile(File file) {
        List<String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (!(line == null)) {
                list.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void initializeAllListsFromFiles() {
        surnames = listFromFile(surnamesFile);
        manNames = listFromFile(manNamesFile);
        womanNames = listFromFile(womanNamesFile);
    }

    public static boolean generateGender() {
        double random = Math.random() * 2;
        if (random < 1) {
            return true;
        } else {
            return false;
        }
    }

    public static int randomIndex(List list) {
        return (int) (Math.random() * list.size());
    }

    public String generateName(boolean isMan) {
        String name;
        if (isMan) {
            name = manNames.get(randomIndex(manNames));
        } else {
            name = womanNames.get(randomIndex(womanNames));
        }
        return name;
    }

    public String generateSurname(boolean isMan) {
        String surname = surnames.get(randomIndex(surnames));
        if (!isMan) {
            if (surname.endsWith("??") || surname.endsWith("??")) {
                return surname + "??";
            } else if (surname.endsWith("????") || surname.endsWith("????") || surname.endsWith("????")) {
                return surname.substring(0, surname.length() - 2) + "????";
            }
        }
        return surname;
    }

    public String generatePatronymic(boolean isMan) {
        String pathronymic = manNames.get(randomIndex(manNames));
        if (pathronymic.endsWith("??") || pathronymic.endsWith("??") || pathronymic.endsWith("??")) {
            pathronymic = pathronymic.substring(0, pathronymic.length() - 1);
            if (isMan) {
                return pathronymic + "????????";
            } else {
                return pathronymic + "????????";
            }
        }
        if (isMan) {
            return pathronymic + "????????";
        } else {
            return pathronymic + "????????";
        }
    }

    public String generateFullName() {
        boolean isMan = generateGender();
        String name = this.generateName(isMan);
        String surname = this.generateSurname(isMan);
        String patronymic = this.generatePatronymic(isMan);
        return surname + " " + name + " " + patronymic;
    }


    public List<Student> generateStudents(int quantityOfStudents) {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < quantityOfStudents; i++) {
            students.add(this.generateOneStudent());
        }
        return students;
    }


    public Student generateOneStudent() {
        String fullName = generateFullName();
        LocalDate birthDate = generateBirthDate();
        Student student = new Student(fullName, birthDate);
        return student;
    }

    public LocalDate generateBirthDate() {
        long minDate = minAgeForEnterASchool.getTime();
        long maxDate = maxAgeForEnterASchool.getTime();
        long randomTimeInMs = (long) (Math.random() * ((maxDate - minDate) + 1)) + minDate;
        return new Date(randomTimeInMs).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
