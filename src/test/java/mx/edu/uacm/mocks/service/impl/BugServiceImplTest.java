package mx.edu.uacm.mocks.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.edu.uacm.mocks.domain.Bug;
import mx.edu.uacm.mocks.domain.BugRepository;
import mx.edu.uacm.mocks.service.BugService;

public class BugServiceImplTest {

	private BugService bugService;
	
	@Mock
	private BugRepository bugRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		bugService = new BugServiceImpl(bugRepository);
		
	}
	
	@Test
	public void  getBugs() {
		
		//given
		List<Bug> bugData = new ArrayList<Bug>();
		bugData.add(new Bug());
		bugData.add(new Bug());
		
		when(bugService.getBugs()).thenReturn(bugData);
		
		
		//when
		List<Bug> bugs = bugService.getBugs();
		
		
		//then
		assertEquals(2, bugs.size());
		
		//assertj
		assertThat(bugs.size()).isEqualTo(2);
		
		verify(bugRepository, times(1)).findAll();
		
	}
	
	@Test
	public void getById() {
		//TODO implementar el mock para probar bugService.getById(1L)
	}

}
