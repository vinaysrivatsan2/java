/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.WoodCuttingOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.SupplyandDemandRole.supplyAndDemandWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class WoodCuttingRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new supplyAndDemandWorkAreaJPanel(userProcessContainer, account, (WoodCuttingOrganization)organization, enterprise);
    }
    
    
}
