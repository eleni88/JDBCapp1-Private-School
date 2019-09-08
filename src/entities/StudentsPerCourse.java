
package entities;

/**
 *
 * @author Eleni
 */
public class StudentsPerCourse {
    
    private int scid;
    private int sid;
    private int cid;
  

    public StudentsPerCourse() {
    }

    public StudentsPerCourse(int sid, int cid) {
        this.sid = sid;
        this.cid = cid;
    }

    
    
    public StudentsPerCourse(int scid, int sid, int cid) {
        this.scid = scid;
        this.sid = sid;
        this.cid = cid;
    }

    public int getScid() {
        return scid;
    }

    public void setScid(int scid) {
        this.scid = scid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.scid;
        hash = 83 * hash + this.sid;
        hash = 83 * hash + this.cid;
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
        final StudentsPerCourse other = (StudentsPerCourse) obj;
        if (this.scid != other.scid) {
            return false;
        }
        if (this.sid != other.sid) {
            return false;
        }
        if (this.cid != other.cid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StudentsPerCourse{" + "scid=" + scid + ", sid=" + sid + ", cid=" + cid + '}';
    }
    
    
    
    
    
}
