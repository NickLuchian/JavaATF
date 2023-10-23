package steps;

import io.cucumber.java.ParameterType;
import org.apache.commons.lang3.EnumUtils;
import util.Pages;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class ParameterTypes {
    @ParameterType(value = "HOME|SEARCH ITEMS|PRODUCT|CHECKOUT|CART")
    public Pages pages(String value){
        return EnumUtils.getEnumIgnoreCase(Pages.class,value.replaceAll(SPACE, "_"));
    };
}
