package nts.uk.ctx.sys.auth.app.command.cas012;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nts.arc.time.GeneralDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cas012CompanyAdRegisterOrUpdateCommand {
    private String cId;
    private Integer roleType;
    private String uId;
    private GeneralDate startDate;
    private GeneralDate endDate;
}
