package mx.edu.uacm.mocks.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import mx.edu.uacm.mocks.domain.Bug;
import mx.edu.uacm.mocks.service.BugService;

public class BugControllerTest {
	
	@Mock
	BugService bugService;
	
	@Mock
	Model model;
	
	BugController bugController;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		bugController = new BugController(bugService);
	}
	
	
	@Test
	public void testModelIndexPage() {
		
		List<Bug> bugs = new ArrayList<Bug>();
		bugs.add(new Bug(1L, "a", "aa"));
		bugs.add(new Bug(2L, "a", "aa"));
		bugs.add(new Bug(3L, "a", "aa"));
		
		when(bugService.getBugs()).thenReturn(bugs);
		
		ArgumentCaptor<List<Bug>> argumentCaptor = ArgumentCaptor.forClass(List.class);
		
		String viewName = bugController.list(model);
		
		assertThat(viewName).isEqualTo("bugs");
		
		verify(bugService, times(1)).getBugs();
		
		verify(model, times(1)).addAttribute(ArgumentMatchers.eq("bugs"), argumentCaptor.capture());
		
		
		List<Bug> listInisideController = argumentCaptor.getValue();
		
		assertThat(listInisideController.size()).isEqualTo(3);
		
		
		
		
	}
	
	

}
