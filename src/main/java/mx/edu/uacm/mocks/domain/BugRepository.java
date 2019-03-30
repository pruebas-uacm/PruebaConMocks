package mx.edu.uacm.mocks.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BugRepository extends CrudRepository<Bug, Long> {

	List<Bug> findByTitle(String title);
}
