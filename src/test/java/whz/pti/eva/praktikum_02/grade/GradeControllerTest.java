package whz.pti.eva.praktikum_02.grade;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest 
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class GradeControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();        
    }

    @Test
    public void testListAllGrades() throws Exception {
        mockMvc.perform(get("/grades")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .param("grade","1")
                .param("lecture", "Mathe"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
