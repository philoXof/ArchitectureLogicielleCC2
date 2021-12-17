package org.esgi.infrastructure;

import org.esgi.domain.contractor.Contractor;
import org.esgi.domain.contractor.ContractorId;
import org.esgi.domain.contractor.ContractorRepository;
import org.esgi.domain.tradesman.Tradesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryContractorRepository implements ContractorRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<ContractorId, Contractor> data = new HashMap<>();

    @Override
    public void add(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }

    @Override
    public ContractorId nextIdentity() {
        return ContractorId.of(counter.incrementAndGet());
    }

    @Override
    public List<Contractor> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Contractor findById(ContractorId id) {
        final Contractor contractor = data.get(id);
        if(contractor == null){
            throw new RuntimeException("No contractor for " + id.getValue());
        }
        return contractor;
    }

    @Override
    public void save(Contractor contractor) {
        data.put(contractor.getId(), contractor);
    }
}
