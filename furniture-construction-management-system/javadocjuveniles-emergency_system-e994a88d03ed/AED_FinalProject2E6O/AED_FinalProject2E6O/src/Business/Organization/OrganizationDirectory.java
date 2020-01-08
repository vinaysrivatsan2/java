/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.WoodCutting.getValue())){
            organization = new WoodCuttingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FurnitureMaking.getValue())){
            organization = new FurnitureMakingOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.FurnitureDelivery.getValue())){
            organization = new FurnitureDeliveryOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HouseBuilder.getValue())){
            organization = new HouseBuilderOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Electrician.getValue())){
            organization = new ElectricianOrganization();
            organizationList.add(organization);
        
    }
        return organization;
}
}
