package plan.backend;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import plan.utils.LastDayOfMonth;

public class TilgungsplanEintragTest {
	@Test
	public void calcNextTest() {
		TilgungsplanEintrag start = new TilgungsplanEintrag(new LastDayOfMonth(11, 2020), -99833.34, 176.67, 2.12, 166.66, 343.33);
		TilgungsplanEintrag next = start.calcNext();
		
		assertEquals(31, next.getDatum().getDay());
		assertEquals(12, next.getDatum().getMonth());
		assertEquals(2020, next.getDatum().getYear());
		assertEquals(-99666.38, next.getRestschuld(), 0.1);
		assertEquals(176.37, next.getZinsen(), 0.1);
		assertEquals(166.96, next.getTilgAusz(), 0.1);

		next = next.calcNext();
		assertEquals(31, next.getDatum().getDay());
		assertEquals(1, next.getDatum().getMonth());
		assertEquals(2021, next.getDatum().getYear());
		assertEquals(-99499.13, next.getRestschuld(), 0.1);
		assertEquals(176.08, next.getZinsen(), 0.1);
		assertEquals(167.25, next.getTilgAusz(), 0.1);

	}
}
