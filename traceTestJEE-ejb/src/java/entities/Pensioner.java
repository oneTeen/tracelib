package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Kenneth
 */
@Entity
public class Pensioner extends Suscriber implements Serializable {

//    private static final long serialVersionUID = 1L;

    public Pensioner() {
    }

    public Pensioner(String name) {
        super(name,3);
    }

    @Override
    public String toString() {
        return super.toString() + " - Pensioner{" + '}';
    }
    
    @Override
    public String getFormattedString() {
        return "Pensioner: " + super.getName();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pensioner)) {
            return false;
        }
        Pensioner other = (Pensioner) object;
        if ((super.getId() == null && other.getId() != null)
                || (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
