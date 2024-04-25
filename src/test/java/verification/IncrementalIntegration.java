package verification;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import verification.domain.*;
import verification.repository.*;
import verification.service.Service;
import verification.validation.*;

public class IncrementalIntegration {
	@Test
	public void testAddStudent() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		fileRepository1.delete("1");
		fileRepository1.delete("2");
		assertTrue(service.saveStudent("1", "test Student 1", 933) == 1);
		assertTrue(service.saveStudent("2", "test Student 2", 934) == 1);
	}

	@Test
	public void testAddAssignment() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		fileRepository1.delete("1");
		fileRepository1.delete("2");
		assertTrue(service.saveStudent("1", "test Student addAssignment 1", 933) == 1);
		assertTrue(service.saveStudent("2", "test Student addAssignment 2", 934) == 1);

		fileRepository2.delete("1");
		fileRepository2.delete("2");
		assertTrue(service.saveTema("1", "test Assignment 1", 10, 2) == 1);
		assertTrue(service.saveTema("2", "test Assignment 2", 13, 4) == 1);
	}

	@Test
	public void testAddGrade() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		fileRepository1.delete("1");
		fileRepository1.delete("2");
		assertTrue(service.saveStudent("1", "test Student addAssignment 1", 933) == 1);
		assertTrue(service.saveStudent("2", "test Student addAssignment 2", 934) == 1);

		fileRepository2.delete("1");
		fileRepository2.delete("2");
		assertTrue(service.saveTema("1", "test Assignment 1", 10, 2) == 1);
		assertTrue(service.saveTema("2", "test Assignment 2", 13, 4) == 1);

		fileRepository3.delete(new Pair<>("1", "1"));
		fileRepository3.delete(new Pair<>("2", "2"));
		assertTrue(service.saveNota("1", "1", 10, 10, "test") == 1);
		assertTrue(service.saveNota("2", "2", 10, 10, "test") == 1);
	}
}
