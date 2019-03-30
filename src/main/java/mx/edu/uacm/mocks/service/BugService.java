package mx.edu.uacm.mocks.service;

import java.util.List;
import java.util.Optional;

import mx.edu.uacm.mocks.domain.Bug;

public interface BugService {

	Optional<Bug> getById(Long id);
	
	List<Bug> getBugs();
}
