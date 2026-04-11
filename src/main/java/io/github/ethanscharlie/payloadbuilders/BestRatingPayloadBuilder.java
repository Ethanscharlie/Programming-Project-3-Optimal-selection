package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestRatingPayloadBuilder implements PayloadBuilder {
    @Override
    public List<Payload> build(List<Payload> payloads) {
        if (payloads == null) return new ArrayList<>();

        List<Payload> sorted = new ArrayList<>(payloads);

        // Logic: 
        // 1. Rating (High to Low)
        // 2. Weight (Low to High) - Pick lighter tied items to fit more in the 700kg limit
        // 3. ID (Low to High) - Final deterministic tie-breaker
        sorted.sort(Comparator.comparingInt(Payload::rating).reversed()
                .thenComparingInt(Payload::weightInKilograms)
                .thenComparingInt(Payload::id));

        List<Payload> selected = new ArrayList<>();
        int currentWeight = 0;
        final int MAX_CAPACITY = 700;

        for (Payload p : sorted) {
            if (currentWeight + p.weightInKilograms() <= MAX_CAPACITY) {
                // The test requires the top 5 fitting items
                if (selected.size() < 5) {
                    selected.add(p);
                    currentWeight += p.weightInKilograms();
                }
            }
        }
        return selected;
    }
}