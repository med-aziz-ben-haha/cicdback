package com.esprit.examen.services;

import static org.junit.Assert.*;

import com.esprit.examen.entities.SecteurActivite;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Null;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecteurActiviteImplTest {
	@Autowired
	ISecteurActiviteService SecteurActiviteService;

	@Test
	public void testAddSecteurActivite() {
		//	List<Stock> stocks = stockService.retrieveAllStocks();
		//	int expected=stocks.size();
		SecteurActivite s = new SecteurActivite("SecteurActivite test","SecteurActivite");
		SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(s);

		//	assertEquals(expected+1, stockService.retrieveAllStocks().size());
		assertNotNull(savedSecteurActivite.getCodeSecteurActivite());
		SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

	}

	@Test
	public void testAddSecteurActiviteOptimized() {

		SecteurActivite s = new SecteurActivite("SecteurActivite test","SecteurActivite");
		SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(s);
		assertNotNull(savedSecteurActivite.getIdSecteurActivite());
		assertSame("SecteurActivite test", savedSecteurActivite.getCodeSecteurActivite());
		assertTrue(savedSecteurActivite.getLibelleSecteurActivite() != null);
		SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());

	}

	@Test
	public void testDeleteSecteurActivite() {
		SecteurActivite s = new SecteurActivite("SecteurActivite test","SecteurActivite");
		SecteurActivite savedSecteurActivite= SecteurActiviteService.addSecteurActivite(s);
		SecteurActiviteService.deleteSecteurActivite(savedSecteurActivite.getIdSecteurActivite());
		assertNull(SecteurActiviteService.retrieveSecteurActivite(savedSecteurActivite.getIdSecteurActivite()));
	}

}
