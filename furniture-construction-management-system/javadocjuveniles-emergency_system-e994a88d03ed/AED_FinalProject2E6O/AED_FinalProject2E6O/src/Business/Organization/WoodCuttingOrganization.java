/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.WoodCuttingRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class WoodCuttingOrganization extends Organization{

    public WoodCuttingOrganization() {
        super(Organization.Type.WoodCutting.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new WoodCuttingRole());
        return roles;
    }
     
}