
package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Eleni
 */
public class Course {
    
    private int cid;
    private String ctitle;
    private String ctype;
    private LocalDate cstartdate;
    private LocalDate cenddate;
    private int strid;

    public Course() {
    }

    public Course(String ctitle, String ctype, LocalDate cstartdate, LocalDate cenddate, int strid) {
        this.ctitle = ctitle;
        this.ctype = ctype;
        this.cstartdate = cstartdate;
        this.cenddate = cenddate;
        this.strid = strid;
    }
    
    

    public Course(int cid, String ctitle, String ctype, LocalDate cstartdate, LocalDate cenddate, int strid) {
        this.cid = cid;
        this.ctitle = ctitle;
        this.ctype = ctype;
        this.cstartdate = cstartdate;
        this.cenddate = cenddate;
        this.strid = strid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCtitle() {
        return ctitle;
    }

    public void setCtitle(String ctitle) {
        this.ctitle = ctitle;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public LocalDate getCstartdate() {
        return cstartdate;
    }

    public void setCstartdate(LocalDate cstartdate) {
        this.cstartdate = cstartdate;
    }

    public LocalDate getCenddate() {
        return cenddate;
    }

    public void setCenddate(LocalDate cenddate) {
        this.cenddate = cenddate;
    }

    public int getStrid() {
        return strid;
    }

    public void setStrid(int strid) {
        this.strid = strid;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.cid;
        hash = 47 * hash + Objects.hashCode(this.ctitle);
        hash = 47 * hash + Objects.hashCode(this.ctype);
        hash = 47 * hash + Objects.hashCode(this.cstartdate);
        hash = 47 * hash + Objects.hashCode(this.cenddate);
        hash = 47 * hash + this.strid;
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
        final Course other = (Course) obj;
        if (this.cid != other.cid) {
            return false;
        }
        if (this.strid != other.strid) {
            return false;
        }
        if (!Objects.equals(this.ctitle, other.ctitle)) {
            return false;
        }
        if (!Objects.equals(this.ctype, other.ctype)) {
            return false;
        }
        if (!Objects.equals(this.cstartdate, other.cstartdate)) {
            return false;
        }
        if (!Objects.equals(this.cenddate, other.cenddate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Course{" + "cid=" + cid + ", ctitle=" + ctitle + ", ctype=" + ctype + ", cstartdate=" + cstartdate + ", cenddate=" + cenddate + ", strid=" + strid + '}';
    }
    
    
    
}
