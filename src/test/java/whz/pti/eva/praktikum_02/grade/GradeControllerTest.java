package whz.pti.eva.praktikum_02.grade;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import whz.pti.eva.praktikum_02.grade.domain.Grade;
import whz.pti.eva.praktikum_02.grade.service.GradeService;

@SpringBootTest 
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class GradeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @MockBean
    private GradeService gradeServiceMock;
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders 
                .webAppContextSetup(wac)
                .build();     
        when(gradeServiceMock.calculateAverage()).thenReturn(1.0);
        when(gradeServiceMock.listAllGrades()).thenReturn(List.of(new Grade("Mathe", "1")));
    }

    @Test
    public void testListAllGrades() throws Exception {
        mockMvc.perform(get("/grades")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("grade","1")
                .param("lecture", "Mathe"))
                .andExpect(status().isOk())
                .andExpect(view().name("grades"))
                .andExpect(model().attribute("listAllGrades", hasSize(1)))
                .andExpect(model().attribute("average", 1.0))
                .andDo(print());
    }
    
    @Test
    public void testAddGrade() throws Exception {
    	mockMvc.perform(post("/add")
    			.contentType(MediaType.APPLICATION_JSON_VALUE)
    			.param("grade", "1")
    			.param("lecture", "mathe"))
    			.andExpect(status()
    			.is3xxRedirection())
    			.andExpect(redirectedUrl("grades")).andDo(print());
    }
}
