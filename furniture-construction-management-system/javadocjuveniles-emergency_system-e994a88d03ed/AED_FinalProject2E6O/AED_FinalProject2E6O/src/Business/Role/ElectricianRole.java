/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.ElectricianOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.ElectricianRole.ElectricianWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.ElectricianRole.ElectricianWorkAreaJPanel;
/**
 *
 * @author admin
 */
public class ElectricianRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ElectricianWorkAreaJPanel(userProcessContainer, account, organization,business, enterprise);
    }
}
