package team6;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
public class LinkerTest{
	@Before
    public void setUp() {
		
    }
	@Test
	public void testGetInfoBasedOnCourse() throws IOException{
		Linker link = new Linker();
		String output = link.checkAgainstArgs("course", "99018");
		assertEquals("[99018] Spring 2014 (16 students)", output);
	}
	@Test
	public void testGetInfoBasedOnStudent() throws IOException{
		Linker link = new Linker();
		String output = link.checkAgainstArgs("student", "111128");
		assertEquals("[111128] Maritza Abbott mabbott@jsu.edu", output);
	}
	@Test
	public void testGetInfoBasedOnInvalidInput() throws IOException{
		Linker link = new Linker();
		String output = link.checkAgainstArgs("ssojfla", "111128");
		assertEquals("THE REQUEST YOU MADE IS INVAILD\nUSE ONLY student OR course WITH ID\nEXAMPLES student 111128\n", output);
	}
}




