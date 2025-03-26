import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 *
 *
 * <p>Java class for currency</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 * <pre>{@code
 * <simpleType name="currency">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="TZS"/>
 *     <enumeration value="KES"/>
 *     <enumeration value="UGX"/>
 *     <enumeration value="USD"/>
 *     <enumeration value="GBP"/>
 *     <enumeration value="EURO"/>
 *     <enumeration value="PKR"/>
 *     <enumeration value="NGN"/>
 *     <enumeration value="EGP"/>
 *     <enumeration value="ETB"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 *
 */
@XmlType(name = "currency")
@XmlEnum
public enum Currency {

    TZS,
    KES,
    UGX,
    USD,
    GBP,
    EURO,
    PKR,
    NGN,
    EGP,
    ETB;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
