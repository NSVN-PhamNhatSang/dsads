package nts.uk.ctx.bs.person.infra.entity.person.family.relationship;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class BpsmtFamilyRelationTypePk implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Basic(optional = false)
	@Column(name = "CONTRACT_CD")
	public String contractCd;
	
	@Basic(optional = false)
	@Column(name = "RELATION_CD")
	public String relationCd;
}
