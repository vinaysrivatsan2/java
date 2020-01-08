/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author tanishka
 */
public class FurnitureEnterprise extends Enterprise {
    public FurnitureEnterprise(String name){
        super(name,Enterprise.EnterpriseType.Furniture);
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    
}
