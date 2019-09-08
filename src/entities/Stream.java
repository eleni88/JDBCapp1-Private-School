
package entities;

import java.util.Objects;

/**
 *
 * @author Eleni
 */
public class Stream {
    
    private int strid;
    private String strname;

    public Stream() {
    }

    public Stream(int strid, String strname) {
        this.strid = strid;
        this.strname = strname;
    }

    public int getStrid() {
        return strid;
    }

    public void setStrid(int strid) {
        this.strid = strid;
    }

    public String getStrname() {
        return strname;
    }

    public void setStrname(String strname) {
        this.strname = strname;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.strid;
        hash = 97 * hash + Objects.hashCode(this.strname);
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
        final Stream other = (Stream) obj;
        if (this.strid != other.strid) {
            return false;
        }
        if (!Objects.equals(this.strname, other.strname)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stream{" + "strid=" + strid + ", strname=" + strname + '}';
    }
    
    
    
    
}
