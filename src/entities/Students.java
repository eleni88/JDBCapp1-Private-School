
package entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Eleni
 */
public class Students {
    
    private int sid;
    private String sfirstname;
    private String slastname;
    private LocalDate sdateofbirth;
    private int stuitionfees;

    public Students() {
    }

    public Students(String sfirstname, String slastname, LocalDate sdateofbirth, int stuitionfees) {
        this.sfirstname = sfirstname;
        this.slastname = slastname;
        this.sdateofbirth = sdateofbirth;
        this.stuitionfees = stuitionfees;
    }
    

    public Students(int sid, String sfirstname, String slastname, LocalDate sdateofbirth, int stuitionfees) {
        this.sid = sid;
        this.sfirstname = sfirstname;
        this.slastname = slastname;
        this.sdateofbirth = sdateofbirth;
        this.stuitionfees = stuitionfees;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSfirstname() {
        return sfirstname;
    }

    public void setSfirstname(String sfirstname) {
        this.sfirstname = sfirstname;
    }

    public String getSlastname() {
        return slastname;
    }

    public void setSlastname(String slastname) {
        this.slastname = slastname;
    }

    public LocalDate getSdateofbirth() {
        return sdateofbirth;
    }

    public void setSdateofbirth(LocalDate sdateofbirth) {
        this.sdateofbirth = sdateofbirth;
    }

    public int getStuitionfees() {
        return stuitionfees;
    }

    public void setStuitionfees(int stuitionfees) {
        this.stuitionfees = stuitionfees;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.sid;
        hash = 47 * hash + Objects.hashCode(this.sfirstname);
        hash = 47 * hash + Objects.hashCode(this.slastname);
        hash = 47 * hash + Objects.hashCode(this.sdateofbirth);
        hash = 47 * hash + this.stuitionfees;
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
        final Students other = (Students) obj;
        if (this.sid != other.sid) {
            return false;
        }
        if (this.stuitionfees != other.stuitionfees) {
            return false;
        }
        if (!Objects.equals(this.sfirstname, other.sfirstname)) {
            return false;
        }
        if (!Objects.equals(this.slastname, other.slastname)) {
            return false;
        }
        if (!Objects.equals(this.sdateofbirth, other.sdateofbirth)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Students{" + "sid=" + sid + ", sfirstname=" + sfirstname + ", slastname=" + slastname + ", sdateofbirth=" + sdateofbirth + ", stuitionfees=" + stuitionfees + '}';
    }
    
    
    
    
    
}
