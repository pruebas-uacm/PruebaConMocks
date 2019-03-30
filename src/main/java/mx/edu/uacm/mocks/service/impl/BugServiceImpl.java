package mx.edu.uacm.mocks.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import mx.edu.uacm.mocks.domain.Bug;
import mx.edu.uacm.mocks.domain.BugRepository;
import mx.edu.uacm.mocks.service.BugService;

@Service
public class BugServiceImpl implements BugService {

	private BugRepository bugRepository;
	
	public BugServiceImpl(BugRepository bugRepository) {
		this.bugRepository = bugRepository;
	}
	
	@Override
	public Optional<Bug> getById(Long id) {
		
		return bugRepository.findById(id);
	}

	@Override
	public List<Bug> getBugs() {
		
		return (List<Bug>)bugRepository.findAll();
	}

}
