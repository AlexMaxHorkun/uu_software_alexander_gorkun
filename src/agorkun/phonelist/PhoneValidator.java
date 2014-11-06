package agorkun.phonelist;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Validates Phone instance.
 *
 * @author Alexander Gorkun
 */
public class PhoneValidator {
    public enum Errors{
        NAME_EMPTY,
        LASTNAME_EMPTY,
        PHONE_EMPTY,
        NAME_INVALID,
        LASTNAME_INVALID,
        PHONE_INVALID
    }

    public Set<PhoneValidator.Errors> validate(Phone p){
        Set<PhoneValidator.Errors> errors=new LinkedHashSet<PhoneValidator.Errors>();
        if(p.getName().length()==0){
            errors.add(Errors.NAME_EMPTY);
        }
        Pattern onlyLettersRegex=Pattern.compile("^\\p{Alpha}+$");
        Matcher matcher=onlyLettersRegex.matcher(p.getName());
        if(!matcher.matches()){
            errors.add(Errors.NAME_INVALID);
        }
        if(p.getLastname().length()==0){
            errors.add(Errors.LASTNAME_EMPTY);
        }
        matcher=onlyLettersRegex.matcher(p.getLastname());
        if(!matcher.matches()){
            errors.add(Errors.LASTNAME_INVALID);
        }
        Pattern phoneRegex=Pattern.compile("^\\+?\\d+$");
        if(p.getPhone().length()==0){
            errors.add(Errors.PHONE_EMPTY);
        }
        matcher=phoneRegex.matcher(p.getPhone());
        if(!matcher.matches()){
            errors.add(Errors.PHONE_INVALID);
        }
        return errors;
    }
}
