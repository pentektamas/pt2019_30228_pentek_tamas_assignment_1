package PT2019.Assignment1.ProjectPolinom.Test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * 
 * @author Pentek Tamas
 * 
 *         Aceasta este o clasa de TestRunner in care rulam JUnitTest din clasa
 *         TestJunit, daca sunt erori atunci afisam iar la final afisam daca
 *         testul s-a terminat cu succes(true) sau nu(false).
 *
 */
public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("Testul a avut un rezultat: " + result.wasSuccessful());
	}
}
