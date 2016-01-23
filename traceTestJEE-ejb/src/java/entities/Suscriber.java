package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Suscriber implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int maxBorrowing;
    private String susType;

    @OneToMany(mappedBy = "suscriber")
    private Collection<Loan> loans;
    
    public Suscriber() {
        this.loans = new ArrayList();
    }

    public Suscriber(String name, int maxBmaxBorrowing) {
        this();
        this.name = name;
        this.maxBorrowing = maxBmaxBorrowing;
        this.susType = this.getClass().getSimpleName();
    }

    public String getSusType() {
        return susType;
    }

    public void setSusType(String susType) {
        this.susType = susType;
    }

    
    
    public void addLoan(Loan loan) throws Exception {
        if (loans.size() - 1 == getMaxBorrowing()) {
            throw new Exception(name + " has reached their borrowing limit.");
        }
        loan.setSuscriber(this);
        loans.add(loan);
    }

    public void removeLoan(Loan loan) {
        loans.remove(loan.getId());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection getLoans() {
        return loans;
    }

    public void setLoans(Collection loans) {
        this.loans = loans;
    }

    public int getMaxBorrowing() {
        return maxBorrowing;
    }

    public void setMaxBorrowing(int maxBorrowing) {
        this.maxBorrowing = maxBorrowing;
    }

    @Override
    public String toString() {
        return "Suscriber{" + "id=" + id + ", name=" + name 
                + ", loans=" + loans + ", maxBorrowing=" + maxBorrowing + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Suscriber)) {
            return false;
        }
        Suscriber other = (Suscriber) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
}
