package verification.repository;

import verification.domain.Student;
import verification.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
	public StudentRepository(Validator<Student> validator) {
		super(validator);
	}
}
