package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Resource implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String gameType;
    private String type;
    private String author;

    @OneToOne
    private Loan loan;

    public Resource() {
    }

    public Resource(String type, String title, String extra) {
        this.type = type;
        this.title = title;
        if (type.equals("Book")) {
            this.author = extra;
        } else {
            this.gameType = extra;
        }
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    
    
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void removeLoan() {
        loan = null;
    }

    public Loan getLoan() {
        return loan;
    }

    public int getMaxLoanPeriod() {
        if (gameType.equals("X-Box")) {
            return 7;
        } else if (gameType.equals("PS2")) {
            return 7;
        } else if (gameType.equals("Amstrad")) {
            return 14;
        } else {
            return 28;
        }
    }

    public double getSurcharge() {
        if (gameType.equals("X-Box")) {
            return 1.0;
        } else if (gameType.equals("PS2")) {
            return 1.5;
        } else if (gameType.equals("Amstrad")) {
            return .5;
        } else {
            return 0;
        }
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
        if (!(object instanceof Resource)) {
            return false;
        }
        Resource other = (Resource) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }

}
