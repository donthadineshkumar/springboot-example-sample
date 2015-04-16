package hello;

import org.apache.tomcat.jni.Status;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.cypher.internal.compiler.v2_1.executionplan.addEagernessIfNecessary;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/*
 * @WebAppConfiguration is a class-level annotation that is used to declare 
 * that the ApplicationContext loaded for an integration test should be a 
 * WebApplicationContext
 * 
 * The mere presence of @WebAppConfiguration on a test class ensures that a 
 * WebApplicationContext will be loaded for the test using a default
 * for the path to root of the web application.
 * 
 * override the default by using a value() attribute
 * 
 * @WebAppConfiguration must be used along with @ContextConfiguration
 * 
 * As we know that, In spring boot @SpringApplicationConfiguration 
 * is similar to @ContextConfiguration
 * 
 * use of MockServletContext is for an empty WebApplicationContext
 * 
 * 
 * 
 */


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes= MockServletContext.class)
@WebAppConfiguration
public class HelloControllerTest {

	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}
	
	
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
						.andExpect(MockMvcResultMatchers.status().isOk())
						.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Greetings from Dinesh")));
	}
	
}
