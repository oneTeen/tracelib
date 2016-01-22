package entities;

import java.util.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

@Entity
public class Loan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date loanDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date returnDate;

    @OneToOne
    private Suscriber suscriber;
    
    @OneToMany
    private Collection<Resource> resources;
      
    public Loan() {
        this.resources = new ArrayList();
        this.loanDate = new Date();
    }

    public Loan(Suscriber s, Resource r) {
        this();
        this.suscriber = s;
        this.resources.add(r);
    }

    public Suscriber getSuscriber() {
        return suscriber;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        if (this.returnDate != null) {
            throw new IllegalStateException("Return date has already been assigned");
        }
        suscriber.removeLoan(this);
        resources.clear();
        this.returnDate = returnDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public void setResource(Resource resource) {
        this.resources.add(resource);
    }

    public void setSuscriber(Suscriber suscriber) {
        this.suscriber = suscriber;
    }

    public Long getId() {
        return id;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Collection getResource() {
        return resources;
    }

    public Object getSubscriber() {
        return suscriber;
    }

    public Collection<Resource> getResources() {
        return resources;
    }

    public void setResources(Collection<Resource> resources) {
        this.resources = resources;
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
        if (!(object instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
