
package entities;

/**
 *
 * @author Eleni
 */
public class TrainersPerCourse {
    
    private int tcid;
    private int tid;
    private int cid;

    public TrainersPerCourse() {
    }

    public TrainersPerCourse(int tid, int cid) {
        this.tid = tid;
        this.cid = cid;
    }

    
    
    public TrainersPerCourse(int tcid, int tid, int cid) {
        this.tcid = tcid;
        this.tid = tid;
        this.cid = cid;
    }

    public int getTcid() {
        return tcid;
    }

    public void setTcid(int tcid) {
        this.tcid = tcid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
        hash = 83 * hash + this.tcid;
        hash = 83 * hash + this.tid;
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
        final TrainersPerCourse other = (TrainersPerCourse) obj;
        if (this.tcid != other.tcid) {
            return false;
        }
        if (this.tid != other.tid) {
            return false;
        }
        if (this.cid != other.cid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TrainersPerCourse{" + "tcid=" + tcid + ", tid=" + tid + ", cid=" + cid + '}';
    }
    
    
    
    
}
