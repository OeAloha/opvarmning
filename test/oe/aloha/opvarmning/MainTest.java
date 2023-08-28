package test.oe.aloha.opvarmning;

import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.OutputStream;
import oe.aloha.opvarmning.Main;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;

public class MainTest {
	private final InputStream originalInput = System.in;
	private final InputStream mockedInput = new ByteArrayInputStream(
			"1\n2\nq\n".getBytes());
	private final PrintStream originalOut = System.out;
	private final OutputStream mockedOut = new ByteArrayOutputStream();

	@Test
	public void testInputLoop() throws IOException {
		System.setIn(mockedInput);
		System.setOut(new PrintStream(mockedOut));
		Main.main(null);
		System.setIn(originalInput);
		System.setOut(originalOut);
		assertEquals("Hej med dig!\n" +
				"Indtast et tal: Gennemsnittet af de indtastede tal er 1.\n" +
				"Indtast endnu et tal: Gennemsnittet af de indtastede tal er 1.\n" +
				"Indtast endnu et tal: Farvel!\n", mockedOut.toString());
	}
}