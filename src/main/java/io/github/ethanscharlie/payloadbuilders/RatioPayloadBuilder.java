package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RatioPayloadBuilder implements PayloadBuilder {
    @Override
    public List<Payload> build(List<Payload> payloads) {
        if (payloads == null) return new ArrayList<>();

        List<Payload> sorted = new ArrayList<>(payloads);

        // Logic: Sort by Rating-to-Weight Ratio (High to Low)
        sorted.sort((p1, p2) -> {
            double ratio1 = (double) p1.rating() / p1.weightInKilograms();
            double ratio2 = (double) p2.rating() / p2.weightInKilograms();
            int comparison = Double.compare(ratio2, ratio1); // Descending
            
            if (comparison == 0) {
                return Integer.compare(p1.id(), p2.id()); // Tie-break by ID
            }
            return comparison;
        });

        List<Payload> selected = new ArrayList<>();
        int currentWeight = 0;
        final int MAX_CAPACITY = 700;

        for (Payload p : sorted) {
            if (currentWeight + p.weightInKilograms() <= MAX_CAPACITY) {
                selected.add(p);
                currentWeight += p.weightInKilograms();
            }
        }
        return selected;
    }
}