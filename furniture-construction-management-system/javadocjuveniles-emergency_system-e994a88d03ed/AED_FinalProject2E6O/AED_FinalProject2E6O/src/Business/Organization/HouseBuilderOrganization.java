/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import java.util.ArrayList;
import Business.Role.HouseBuilderRole;

/**
 *
 * @author admin
 */
public class HouseBuilderOrganization extends Organization {
     public HouseBuilderOrganization() {
        super(Organization.Type.HouseBuilder.getValue());
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HouseBuilderRole());
        return roles;
    }
}
