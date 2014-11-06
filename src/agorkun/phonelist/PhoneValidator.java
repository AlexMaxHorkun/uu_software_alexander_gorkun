package agorkun.phonelist;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Validates Phone instance.
 *
 * @author Alexander Gorkun
 */
public class PhoneValidator {
    public enum Errors{
        NAME_EMPTY,
        LASTNAME_EMPTY,
        PHONE_EMPTY
    }

    public Set<PhoneValidator.Errors> validate(Phone p){
        Set<PhoneValidator.Errors> errors=new LinkedHashSet<PhoneValidator.Errors>();
        if(p.getName().length()==0){
            errors.add(Errors.NAME_EMPTY);
        }
        if(p.getLastname().length()==0){
            errors.add(Errors.LASTNAME_EMPTY);
        }
        if(p.getPhone().length()==0){
            errors.add(Errors.PHONE_EMPTY);
        }
        return errors;
    }
}
