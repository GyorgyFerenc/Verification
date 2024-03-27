package verification;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;

import console.*;
import domain.*;
import repository.*;
import service.*;
import validation.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void testAddStudent1(){
        Validator<Student> studentValidator = new StudentValidator();
        Validator<Tema> temaValidator = new TemaValidator();
        Validator<Nota> notaValidator = new NotaValidator();

        //createFile("test_students.xml");
        //createFile("test_projects.xml");
        //createFile("test_grades.xml");
        StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
        TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
        NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

        Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

        // int saveStudent(String id, String nume, int grupa) {
        fileRepository1.delete("1");
        fileRepository1.delete("2");
        assertTrue(service.saveStudent("1", "test Student 1", 933) == 1);
        assertTrue(service.saveStudent("2", "test Student 2", 934) == 1);

        fileRepository1.delete("abcd");
        fileRepository1.delete("efg");
        assertTrue(service.saveStudent("abcd", "123", 933) == 1);
        assertTrue(service.saveStudent("efg", "321", 934) == 1);


        try {
            service.saveStudent("", "", 0);
            service.saveStudent("id", "test student1", 12);
            service.saveStudent("id2", "test student2", 1000);
            service.saveStudent(null, "name xd lol", 933);
            service.saveStudent("id312", null, 933);
            assertTrue(false);
        } catch(ValidationException e){
            assertTrue(true);
        }
    }

    @Test
    public void testAddStudent2(){
        assertTrue(true);
    }
}
