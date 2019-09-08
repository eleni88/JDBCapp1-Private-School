
package entities;

import java.util.Objects;

/**
 *
 * @author Eleni
 */
public class Trainers {
    
    private int tid;
    private String tfirstname;
    private String tlastname;

    public Trainers() {
    }

    public Trainers(String tfirstname, String tlastname) {
        this.tfirstname = tfirstname;
        this.tlastname = tlastname;
    }
    
    

    public Trainers(int tid, String tfirstname, String tlastname) {
        this.tid = tid;
        this.tfirstname = tfirstname;
        this.tlastname = tlastname;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTfirstname() {
        return tfirstname;
    }

    public void setTfirstname(String tfirstname) {
        this.tfirstname = tfirstname;
    }

    public String getTlastname() {
        return tlastname;
    }

    public void setTlastname(String tlastname) {
        this.tlastname = tlastname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.tid;
        hash = 89 * hash + Objects.hashCode(this.tfirstname);
        hash = 89 * hash + Objects.hashCode(this.tlastname);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trainers other = (Trainers) obj;
        if (this.tid != other.tid) {
            return false;
        }
        if (!Objects.equals(this.tfirstname, other.tfirstname)) {
            return false;
        }
        if (!Objects.equals(this.tlastname, other.tlastname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trainers{" + "tid=" + tid + ", tfirstname=" + tfirstname + ", tlastname=" + tlastname + '}';
    }
    
    
    
    
    
}
