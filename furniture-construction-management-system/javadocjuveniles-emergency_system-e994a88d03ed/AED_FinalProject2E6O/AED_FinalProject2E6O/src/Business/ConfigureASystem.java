package Business;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.SystemAdminRole;
import Business.Role.WoodCuttingRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {

    public static EcoSystem configure() {

        EcoSystem system = EcoSystem.getInstance();
        Network bostonNetwork = system.createAndAddNetwork();
        bostonNetwork.setName("boston");

        bostonNetwork.getEnterpriseDirectory().createAndAddEnterprise("Furniture", Enterprise.EnterpriseType.Furniture);
        bostonNetwork.getEnterpriseDirectory().createAndAddEnterprise("Construction", Enterprise.EnterpriseType.Construction);
//        for (Enterprise enterprise : bostonNetwork.getEnterpriseDirectory().getEnterpriseList()) {
//            if (enterprise.getEnterpriseType().equals(Enterprise.EnterpriseType.Furniture)) {
//                Organization org = enterprise.getOrganizationDirectory().createOrganization(Organization.Type.WoodCutting);
//                Employee wood1 = org.getEmployeeDirectory().createEmployee("wood1");
//                UserAccount acc = org.getUserAccountDirectory().createUserAccount("wood1", "wood1", wood1, new WoodCuttingRole());
//
//            } else {
//               // enterprise.getOrganizationDirectory().createOrganization(Organization.Type.Construction);
//            }
//        }
        //Create a network

        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        Employee employee = system.getEmployeeDirectory().createEmployee("sysadmin");

        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());

        return system;
    }

}
