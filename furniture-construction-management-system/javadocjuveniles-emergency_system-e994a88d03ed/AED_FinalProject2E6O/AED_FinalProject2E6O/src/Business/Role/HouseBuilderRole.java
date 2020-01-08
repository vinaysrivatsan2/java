/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.HouseBuilderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.HouseBuilderRole.HouseBuilderWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.HouseBuilderRole.HouseBuilderWorkAreaJPanel;
/**
 *
 * @author admin
 */
public class HouseBuilderRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new HouseBuilderWorkAreaJPanel(userProcessContainer, account, (HouseBuilderOrganization)organization, enterprise,business);
    }
}
