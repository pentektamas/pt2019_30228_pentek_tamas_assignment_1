package PT2019.Assignment1.ProjectPolinom.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PT2019.Assignment1.ProjectPolinom.Controller.GeneralController;
import PT2019.Assignment1.ProjectPolinom.Model.Polinom;
import PT2019.Assignment1.ProjectPolinom.View.GeneralView;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Aceasta clasa este o clasa de JUnitTest in care testam pe rand
 *         operatiile de citire, procesare, adunare, scadere, inmultire,
 *         impartire, derivare, integrare pentru polinomul p1 si polinomul p2
 * 
 *
 */
public class TestJunit {

	Polinom p1 = new Polinom();
	Polinom p2 = new Polinom();
	Polinom rez = new Polinom();
	String polinom1 = "2x^3+3x^2-x+5";
	String polinom2 = "x^2-x+1";
	Polinom r = new Polinom();
	GeneralView v = new GeneralView();
	GeneralController c = new GeneralController(v);

	@Test
	public void testReadPolinom1() {
		assertEquals(p1.readPolinom(polinom1, "polinomul 1"), true);
	}

	@Test
	public void testReadPolinom2() {
		assertEquals(p2.readPolinom(polinom2, "polinomul 2"), true);
	}

	@Test
	public void testProcessPolinom1() {
		assertEquals(p1.processPolinom("polinomul 1"), true);
	}

	@Test
	public void testProcessPolinom2() {
		assertEquals(p2.processPolinom("polinomul 2"), true);
	}

	@Test
	public void testAdunarePolinom() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.adunare(p1, p2);
		assertEquals(rez.toString(), "2x^3+4x^2-2x+6");
	}

	@Test
	public void testScaderePolinom() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.scadere(p1, p2, 0);
		assertEquals(rez.toString(), "2x^3+2x^2+4");
	}

	@Test
	public void testInmultirePolinom() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.inmultire(p1, p2);
		assertEquals(rez.toString(), "2x^5+x^4-2x^3+9x^2-6x+5");
	}

	@Test
	public void testImpartirePolinom() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.impartire(p1, p2, r);
		assertEquals(rez.toString(), "2x+5");
		assertEquals(r.toString(), "2x");
	}

	@Test
	public void testDerivarePolinom1() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		rez = Polinom.derivare(p1);
		assertEquals(rez.toString(), "6x^2+6x-1");
	}

	@Test
	public void testDerivarePolinom2() {
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.derivare(p2);
		assertEquals(rez.toString(), "2x-1");
	}

	@Test
	public void testIntegrarePolinom1() {
		p1.readPolinom(polinom1, "polinomul 1");
		p1.processPolinom("polinomul 1");
		rez = Polinom.integrare(p1);
		assertEquals(rez.toString2(), "0,50x^4+x^3-0,50x^2+5,00x");
	}

	@Test
	public void testIntegrarePolinom2() {
		p2.readPolinom(polinom2, "polinomul 2");
		p2.processPolinom("polinomul 2");
		rez = Polinom.integrare(p2);
		assertEquals(rez.toString2(), "0,33x^3-0,50x^2+x");
	}
}
