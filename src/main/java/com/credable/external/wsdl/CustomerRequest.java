import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type</p>.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.</p>
 *
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerNumber"
})
@XmlRootElement(name = "CustomerRequest", namespace = "http://credable.io/cbs/customer")
public class CustomerRequest {

    @XmlElement(namespace = "http://credable.io/cbs/customer", required = true)
    protected String customerNumber;

    /**
     * Gets the value of the customerNumber property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

}
