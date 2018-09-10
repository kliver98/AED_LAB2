package icesi.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "weapons") //This help to Write Data, "convert" to XML and otherwise
public class WeaponListWrapper {

	private List<Weapon> weapons;

    @XmlElement(name = "person")
    public List<Weapon> getPersons() {
        return weapons;
    }

    public void setWeapons(List<Weapon> weapons) {
        this.weapons = weapons;
    }
	
}
