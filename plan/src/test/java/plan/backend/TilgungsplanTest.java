package plan.backend;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TilgungsplanTest {
	@Test
	public void contructorTest() {
		Tilgungsplan tp = new Tilgungsplan(100000.0f, 2.12, 2.0, 10);
		assertEquals(343.33, tp.getFesteRate(), 0.0);
		TilgungsplanEintrag tpe = tp.getEintraege().get(0);
		//assertEquals(tpe.getDatum().getDay(), 30);
		//assertEquals(tpe.getDatum().getMonth(), 11);
		//assertEquals(tpe.getDatum().getYear(), 2020);
		assertEquals(tpe.getRate(), -100000.0, 0.0);
		assertEquals(tpe.getRestschuld(), -100000.0, 0.0);
		assertEquals(tpe.getTilgAusz(), -100000.0, 0.0);
		assertEquals(tpe.getZinsen(), 0.0, 0.0);

		tp.calcPlan();
		String test;
		test = "";
		System.out.println(test);


		

	}
}
