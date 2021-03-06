package eccrm.base.employee.dao;

import eccrm.base.employee.bo.ContactMethodBo;
import eccrm.base.employee.domain.ContactMethod;

import java.util.List;

/**
 * Generated by chenl on 2014-10-22.
 */

public interface ContactMethodDao {

    String save(ContactMethod contactMethod);

    void update(ContactMethod contactMethod);

    List<ContactMethod> query(ContactMethodBo bo);

    long getTotal(ContactMethodBo bo);

    ContactMethod findById(String id);

    int deleteById(String id);
}
