/******************************************************************
 * Copyright (c) 2015 Nittsu System to present.                   *
 * All right reserved.                                            *
 *****************************************************************/
package nts.uk.ctx.basic.infra.entity.report;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class PcpmtPersonTempAssignPK.
 */
@Embeddable
@Setter
@Getter
public class PcpmtPersonTempAssignPK implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The ccd. */
	@Basic(optional = false)
    @Column(name = "CCD")
    private String ccd;
    
    /** The pid. */
    @Basic(optional = false)
    @Column(name = "PID")
    private String pid;
    
    /** The hist id. */
    @Basic(optional = false)
    @Column(name = "HIST_ID")
    private String histId;

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccd != null ? ccd.hashCode() : 0);
        hash += (pid != null ? pid.hashCode() : 0);
        hash += (histId != null ? histId.hashCode() : 0);
        return hash;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PcpmtPersonTempAssignPK)) {
            return false;
        }
        PcpmtPersonTempAssignPK other = (PcpmtPersonTempAssignPK) object;
        if ((this.ccd == null && other.ccd != null) || (this.ccd != null && !this.ccd.equals(other.ccd))) {
            return false;
        }
        if ((this.pid == null && other.pid != null) || (this.pid != null && !this.pid.equals(other.pid))) {
            return false;
        }
        if ((this.histId == null && other.histId != null) 
        		|| (this.histId != null && !this.histId.equals(other.histId))) {
            return false;
        }
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "entity.PcpmtPersonTempAssignPK[ ccd=" + ccd + ", pid=" + pid + ", histId=" + histId + " ]";
    }
    
}
