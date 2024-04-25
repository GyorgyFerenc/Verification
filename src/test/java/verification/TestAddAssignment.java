package verification;
// public int saveTema(String id, String descriere, int deadline, int startline) {

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import verification.domain.*;
import verification.repository.*;
import verification.service.Service;
import verification.validation.*;

public class TestAddAssignment {
	@Test
	public void testAddAssignmentValidFields() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		// public int saveTema(String id, String descriere, int deadline, int startline)
		// {
		fileRepository2.delete("1");
		fileRepository2.delete("2");
		assertTrue(service.saveTema("1", "test Assignment 1", 10, 2) == 1);
		assertTrue(service.saveTema("2", "test Assignment 2", 13, 4) == 1);
	}

	@Test
	public void testAddAssignmentStringIdNumericDescription() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		fileRepository2.delete("abcd");
		fileRepository2.delete("efg");
		assertTrue(service.saveTema("abcd", "123", 10, 2) == 1);
		assertTrue(service.saveTema("efg", "321", 13, 4) == 1);
	}

	@Test
	public void testAddAssignmentStringIdEmptyDescription() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("1");
			fileRepository2.delete("2");
			assertTrue(service.saveTema("1", "", 10, 2) == 1);
			assertTrue(service.saveTema("2", "", 13, 4) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddAssignmentEmptyFields() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("1");
			fileRepository2.delete("2");
			assertTrue(service.saveTema("1", "", 0, 0) == 1);
			assertTrue(service.saveTema("2", "", 0, 0) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddAssignmentInvalidFields() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("1");
			fileRepository2.delete("2");
			assertTrue(service.saveTema("1", "test Assignment 1", 0, 0) == 1);
			assertTrue(service.saveTema("2", "test Assignment 2", 0, 0) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddAssignmentInvalidDeadline() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("1");
			fileRepository2.delete("2");
			assertTrue(service.saveTema("1", "test Assignment 1", -1, 0) == 1);
			assertTrue(service.saveTema("2", "test Assignment 2", -1, 0) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddAssignmentInvalidStartline() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("1");
			fileRepository2.delete("2");
			assertTrue(service.saveTema("1", "test Assignment 1", 10, -1) == 1);
			assertTrue(service.saveTema("2", "test Assignment 2", 13, -1) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddAssignmentNullFields() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		try {
			fileRepository2.delete("2");
			fileRepository2.delete("1");
			assertTrue(service.saveTema(null, null, 0, 0) == 1);
			assertTrue(service.saveTema(null, null, 0, 0) == 1);
			assertTrue(false);
		} catch (ValidationException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testAddDuplicate() {
		Validator<Student> studentValidator = new StudentValidator();
		Validator<Tema> temaValidator = new TemaValidator();
		Validator<Nota> notaValidator = new NotaValidator();

		StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "test_students.xml");
		TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "test_projects.xml");
		NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "test_grades.xml");

		Service service = new Service(fileRepository1, fileRepository2, fileRepository3);

		// public int saveTema(String id, String descriere, int deadline, int startline)
		// {
		fileRepository2.delete("1");
		service.saveTema("1", "test Assignment 1", 10, 2);
		assertTrue(service.saveTema("1", "test Assignment 1", 10, 2) == 0);
	}
}
