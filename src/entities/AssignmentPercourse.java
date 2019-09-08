
package entities;

/**
 *
 * @author Eleni
 */
public class AssignmentPercourse {
    
    private int acid;
    private int aid;
    private int cid;

    public AssignmentPercourse() {
    }

    public AssignmentPercourse(int acid, int aid, int cid) {
        this.acid = acid;
        this.aid = aid;
        this.cid = cid;
    }

    public int getAcid() {
        return acid;
    }

    public void setAcid(int acid) {
        this.acid = acid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.acid;
        hash = 97 * hash + this.aid;
        hash = 97 * hash + this.cid;
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
        final AssignmentPercourse other = (AssignmentPercourse) obj;
        if (this.acid != other.acid) {
            return false;
        }
        if (this.aid != other.aid) {
            return false;
        }
        if (this.cid != other.cid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AssignmentPercourse{" + "acid=" + acid + ", aid=" + aid + ", cid=" + cid + '}';
    }
    
    
    
    
}
