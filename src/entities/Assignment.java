
package entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Eleni
 */
public class Assignment {
    
    private int aid;
    private String atitle;
    private String adescription;
    private double oralMark;
    private double totalMark;
    private LocalDateTime asubDateTime;

    public Assignment() {
    }

    public Assignment(String atitle, String adescription, double oralMark, double totalMark, LocalDateTime asubDateTime) {
        this.atitle = atitle;
        this.adescription = adescription;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.asubDateTime = asubDateTime;
    }

    
    
    public Assignment(int aid, String atitle, String adescription, double oralMark, double totalMark, LocalDateTime asubDateTime) {
        this.aid = aid;
        this.atitle = atitle;
        this.adescription = adescription;
        this.oralMark = oralMark;
        this.totalMark = totalMark;
        this.asubDateTime = asubDateTime;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAdescription() {
        return adescription;
    }

    public void setAdescription(String adescription) {
        this.adescription = adescription;
    }

    public double getOralMark() {
        return oralMark;
    }

    public void setOralMark(double oralMark) {
        this.oralMark = oralMark;
    }

    public double getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(double totalMark) {
        this.totalMark = totalMark;
    }

    public LocalDateTime getAsubDateTime() {
        return asubDateTime;
    }

    public void setAsubDateTime(LocalDateTime asubDateTime) {
        this.asubDateTime = asubDateTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.aid;
        hash = 13 * hash + Objects.hashCode(this.atitle);
        hash = 13 * hash + Objects.hashCode(this.adescription);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.oralMark) ^ (Double.doubleToLongBits(this.oralMark) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.totalMark) ^ (Double.doubleToLongBits(this.totalMark) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.asubDateTime);
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
        final Assignment other = (Assignment) obj;
        if (this.aid != other.aid) {
            return false;
        }
        if (Double.doubleToLongBits(this.oralMark) != Double.doubleToLongBits(other.oralMark)) {
            return false;
        }
        if (Double.doubleToLongBits(this.totalMark) != Double.doubleToLongBits(other.totalMark)) {
            return false;
        }
        if (!Objects.equals(this.atitle, other.atitle)) {
            return false;
        }
        if (!Objects.equals(this.adescription, other.adescription)) {
            return false;
        }
        if (!Objects.equals(this.asubDateTime, other.asubDateTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Assignment{" + "aid=" + aid + ", atitle=" + atitle + ", adescription=" + adescription + ", oralMark=" + oralMark + ", totalMark=" + totalMark + ", asubDateTime=" + asubDateTime + '}';
    }
    
    
    
    
    
}
