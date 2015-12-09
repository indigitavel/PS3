/*
 * Programação Sistemática - Universidade de Brasília
 * Trabalho 02
 * Autores:
 *      - Adriano Torres    11/0106032
 *      - Caio Oliveira     14/0176713
 *      - Leandro Faria     14/0178759
 *      - Lisa Evaldt       09/0093450
 */
package psproject2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DisponibilityTest {

	private static final int TEN_AM_IN_MINUTES = 600;

	Disponibility disponibility = new Disponibility();

	Calendar currentDate = new GregorianCalendar();

	/**
	 * Testa o método que preenche os dados referentes à disponilidade. String
	 * info: A string que contém toda e qualquer informação a respeito desta
	 * disponibilidade.
	 */
	@Test
	public void populateCompleteDate() {
		try {
			String info = "Ter, 10/11/2015, 10:00-12:00";
			disponibility.populateData(info);
		} catch (Throwable e) {
			fail("Should not throw an exception on valid input.");
		}
	}

	@Test
	public void populateWithWeekDayAndTime() {
		try {
			String info = "Dom, 12:00-14:00";
			disponibility.populateData(info);
		} catch (Throwable e) {
			fail("Should not throw an exception on valid input.");
		}
	}

	/**
	 * Testa o horário de início da disponibilidade. expResult: Inteiro
	 * representando em minutos o horário de início da disponibilidade.
	 */
	@Test
	public void getStartTime() {
		String info = "Ter, 10/11/2015, 10:00-12:00";
		disponibility.populateData(info);

		int result = disponibility.getStartTime();

		assertEquals(TEN_AM_IN_MINUTES, result);
	}

	/**
	 * Testa o método match que verifica se a disponibilidade desejada bate com
	 * a disponibilidade existente.
	 */
	@Test
	public void matchCompleteDate() {
		String info = "Ter, 10/11/2015, 10:00-12:00";
		disponibility.populateData(info);

		int year = 2015;
		int month = 10; // O mês da classe Calendário começa em zero
		int day = 10;
		int dayOfWeek = 3;
		int howLong = 120;
		boolean result = disponibility.match(year, month, day, dayOfWeek,
				howLong);

		assertTrue(result);
	}

	@Test
	public void matchDateWithWeekDayAndTime() {
		String info = "Dom, 12:00-14:00";
		disponibility.populateData(info);

		// Valores de ano, mês e dia iguais a 0 por não haver lógica de cálculo
		// da data atual.
		int year = 0;
		int month = 0;
		int day = 0;
		int dayOfWeek = 1;
		int howLong = 120;

		boolean result = disponibility.match(year, month, day, dayOfWeek,
				howLong);

		assertTrue(result);
	}
	
	@Test
	public void matchCompleteDateWithInvalidParams() {
		String info = "Ter, 10/11/2015, 10:00-12:00";
		disponibility.populateData(info);
		
		// Valores inválidos
		int year = 2015;
		int month = 11;
		int day = 8;
		int dayOfWeek = 3;
		int howLong = 120;

		boolean result = disponibility.match(year, month, day, dayOfWeek,
				howLong);

		assertFalse(result);
	}
	
	@Test
	public void matchDateWithWeekDayAndTimeWithInvalidParams() {
		String info = "Dom, 12:00-14:00";
		disponibility.populateData(info);

		int year = 2015;
		int month = 11;
		int day = 8;
		int dayOfWeek = 3;
		int howLong = 120;

		boolean result = disponibility.match(year, month, day, dayOfWeek,
				howLong);

		assertFalse(result);
	}

}
