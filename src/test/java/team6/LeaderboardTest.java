package team6;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
public class LeaderboardTest{
	@Before
    public void setUp() {
		
    }
	@Test
	public void testIfLeaderboardIgnoresArgsNotEqualToTwo() throws IOException{
		String[] args = {"hi", "this", "is", "me"};
		Leaderboard leaderboard = new Leaderboard();
		boolean error = leaderboard.runValidityChecks(args);
		assertEquals(true, error);
	}
	@Test
	public void testIfLeaderboardRunsArgsEqualToTwo() throws IOException{
		String[] args = {"course", "99018"};
		Leaderboard leaderboard = new Leaderboard();
		boolean error = leaderboard.runValidityChecks(args);
		assertEquals(false, error);
	}
	
}




