package entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Kenneth
 */
@Entity
public class Student extends Suscriber implements Serializable {

//    private static final long serialVersionUID = 1L;
    private String institution;

    public Student() {
    }

    public Student(String institution, String id, String name) {
        super(id, name, 6);
        this.institution = institution;
    }

    public Student(String institution, String name) {
        super(name, 6);
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    @Override
    public String toString() {
        return super.toString() + " - Student{" + "institution=" + institution + '}';
    }

    @Override
    public String getFormattedString() {
        return "Student: " + super.getName() + " - Institution: " + institution;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (super.getId() != null ? super.getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((super.getId() == null && other.getId() != null) || 
                (super.getId() != null && !super.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
