package org.esgi.use_case.tradesman.infrastructure;

import org.esgi.use_case.tradesman.domain.Tradesman;
import org.esgi.use_case.tradesman.domain.TradesmanId;
import org.esgi.use_case.tradesman.domain.TradesmanRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryTradesmanRepository implements TradesmanRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<TradesmanId, Tradesman> data = new HashMap<>();

    @Override
    public void add(Tradesman tradesman) {
        data.put(tradesman.getId(), tradesman);
    }

    @Override
    public TradesmanId nextIdentity() {
        return TradesmanId.of(counter.incrementAndGet());
    }

    @Override
    public List<Tradesman> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Tradesman findById(TradesmanId id) {
        final Tradesman tradesman = data.get(id);
        if(tradesman == null) {
            throw new RuntimeException("No tradesman for " + id.getValue());
        }
        return tradesman;
    }

    @Override
    public void save(Tradesman tradesman) {
        data.put(tradesman.getId(), tradesman);
    }

    @Override
    public void setValid(TradesmanId id){
        final Tradesman tradesman = findById(id);
        tradesman.setValid();
        save(tradesman);
    }

    @Override
    public void setInvalid(TradesmanId id){
        final Tradesman tradesman = findById(id);
        tradesman.setInvalid();
        save(tradesman);
    }
}
