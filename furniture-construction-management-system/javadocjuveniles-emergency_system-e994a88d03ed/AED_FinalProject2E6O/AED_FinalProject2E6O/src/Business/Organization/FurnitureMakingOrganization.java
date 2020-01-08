/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.FurnitureMakingRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class FurnitureMakingOrganization extends Organization{

    public FurnitureMakingOrganization() {
        super(Organization.Type.FurnitureMaking.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new FurnitureMakingRole());
        return roles;
    }
     
   
    
    
}
