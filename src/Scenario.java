
import model.data.*;
import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
/**
 * 
 */
public class Scenario{

    private Departement d;
    private Commune c;
	private Gare g;
	private Aeroport a;
    
	@Before
	public void setAttributs(){
		this.d = new Departement(11, "HONK", 235900);
		this.c = new Commune(123, "LaCommune");
		this.g = new Gare(1, "Gare", true, true);
		this.a = new Aeroport("Navion", "56769 Vannes");
	}

    @Test
    public void testEstVoisine(){
		System.out.println("cas nominal");
		Commune co = new Commune(122, "LaVoisine");
		c.getListeVoisine().add(co);
		co.getListeVoisine().add(c);
		if((c.estVoisine(co)) && (co.estVoisine(c))){
			System.out.println("Elles sont voisines");
		}

		System.out.println("Cas limite");
		Commune ca = new Commune(1233, "PasVoisine");
		if ((!ca.estVoisine(c) && (!c.estVoisine(ca)))) {
			System.out.println("Elles ne sont pas voisine");
		}

		System.out.println("Cas d'erreur");
		c.getListeVoisine().clear();
    }

	@Test
	public void testCompareInvessTo(){
		System.out.println("Cas nominal");
		Departement de = new Departement(12, "LEDEP", 235900);
		assertEquals("Nuh uh", 1, d.compareInvessTo(de));

		System.out.println("Cas de erreur");
		try {
			de = null;
			assertEquals("Nuh uh", 0, d.compareInvessTo(de));
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur");
		}
	}

	@Test
	public void testNbGare(){
		System.out.println("Cas Nominal");
		Commune co = new Commune(123412, "communeTest");
		Gare ga = new Gare(2, "Gare2", false, true);
		Gare ge = new Gare(3, "Gare3", true, false);
		this.c.getListeGare().add(this.g);
		co.getListeGare().add(ge);
		co.getListeGare().add(ga);
		this.d.getListeCommunes().add(co);
		this.d.getListeCommunes().add(c);
		assertEquals("Nuh uh", 3, this.d.nbGare());

		System.out.println("Cas D'erreur");
		try {
			this.d.getListeCommunes().add(null);
			assertEquals("Nuh uh", 3, this.d.nbGare());
			this.d.getListeCommunes().clear();
		} catch (IllegalArgumentException e) {
			System.out.println("Ce n'est pas bon");
		}
	}

	@Test
	public void testCommuneGare(){
		System.out.println("Cas nominal");
		Gare ga = new Gare(2, "Gare2", false, true);
		Commune co = new Commune(123412, "communeTest");
		co.getListeGare().add(ga);
		this.c.getListeGare().add(g);
		assertEquals("Nuh uh", true, ga.communeGare(co));

		System.out.println("Cas Limite");
		assertEquals("Nuh uh", false, ga.communeGare(c));

		System.out.println("Cas d'erreur");
		try {
			assertEquals("Nuh uh", false, ga.communeGare(null));
		} catch (IllegalArgumentException e) {
			System.out.println("erreur");
		}

		c.getListeGare().clear();
	}

	@Test
	public void testEmplacementAeroport(){
		System.out.println("Cas nominal");
		Departement de = new Departement(12, "LEDEP", 235900);
		Aeroport ae = new Aeroport("AeroportTest", "12345 Test");
		this.d.getListeAeroport().add(a);
		de.getListeAeroport().add(ae);
		if(ae.emplacementAeroport(de).equals(de.getNomDep())){
			System.out.println("test reussi");
		}else{
			System.out.println("Test echoue");
		}

		System.out.println("Cas limite");
		if(ae.emplacementAeroport(d).equals(de.getNomDep())){
			System.out.println("test reussi");
		}else{
			System.out.println("Test echoue");
		}

		System.out.println("Cas d'erreur");
		try {
			if(ae.emplacementAeroport(null).equals(de.getNomDep())){
				System.out.println("test reussi");
			}else{
				System.out.println("Test echoue");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur");
		}

		this.d.getListeAeroport().clear();
	}

	public static void main(String[] args){
		JUnitCore.main("Scenario");
	}
}
