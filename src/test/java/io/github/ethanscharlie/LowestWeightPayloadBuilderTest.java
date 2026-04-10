package io.github.ethanscharlie;

import static org.junit.jupiter.api.Assertions.*;

import io.github.ethanscharlie.model.Payload;
import io.github.ethanscharlie.TestUtils;
import java.util.List;

import io.github.ethanscharlie.payloadbuilders.LowestWeightPayloadBuilder;
import org.junit.jupiter.api.Test;

public class LowestWeightPayloadBuilderTest {

    private final LowestWeightPayloadBuilder builder = new LowestWeightPayloadBuilder();

    @Test
    public void testMatchingList() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        assertNotNull(result);
        assertEquals(9, result.size());

        assertEquals("Seed Viability", result.get(0).experiment());
        assertEquals("Yeast Fermentation", result.get(1).experiment());
        assertEquals("Cloud Patterns", result.get(2).experiment());
        assertEquals("Mice Tumors", result.get(3).experiment());
        assertEquals("Microgravity Plant Growth", result.get(4).experiment());
        assertEquals("Cosmic Rays", result.get(5).experiment());
        assertEquals("Sun Spots", result.get(6).experiment());
        assertEquals("Relativity", result.get(7).experiment());
        assertEquals("Micrometeorites", result.get(8).experiment());

        int totalWeight = result.stream()
                .mapToInt(Payload::weightInKilograms)
                .sum();
        assertEquals(654, totalWeight);
        assertTrue(totalWeight <= 700);

        int totalRating = result.stream()
                .mapToInt(Payload::rating)
                .sum();
        assertEquals(52, totalRating);
    }

    @Test
    public void testEmptyList() {
        List<Payload> result = builder.build(List.of());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testListWithOneElement() {
        Payload single = new Payload(1, "Single Payload", 100, 5);

        List<Payload> result = builder.build(List.of(single));

        assertNotNull(result);
        assertEquals(1, result.size());

        assertEquals("Single Payload", result.get(0).experiment());
        assertEquals(100, result.get(0).weightInKilograms());
        assertEquals(5, result.get(0).rating());
    }
}