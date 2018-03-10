
package web.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mailWSStatus")
@XmlSeeAlso({
    MailWSStatusFault.class,
    MailWSStatusSuccess.class
})
public class MailWSStatus {


}
