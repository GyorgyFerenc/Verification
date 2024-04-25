package verification.repository;

import verification.domain.Nota;
import verification.domain.Pair;
import verification.validation.Validator;

public class NotaRepository extends AbstractCRUDRepository<Pair<String, String>, Nota> {
	public NotaRepository(Validator<Nota> validator) {
		super(validator);
	}
}
