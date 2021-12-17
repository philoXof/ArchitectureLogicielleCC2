package org.esgi.domain.contractor;

import org.esgi.domain.tradesman.Tradesman;
import org.esgi.domain.tradesman.TradesmanId;

import java.lang.invoke.CallSite;
import java.util.List;

public interface ContractorRepository {
    void add(Contractor contractor);

    ContractorId nextIdentity();

    List<Contractor> findAll();

    Contractor findById(ContractorId id);

    void save(Contractor contractor);
}
