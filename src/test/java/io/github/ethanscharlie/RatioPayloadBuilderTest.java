package io.github.ethanscharlie;

import static org.junit.jupiter.api.Assertions.*;

import io.github.ethanscharlie.model.Payload;
import io.github.ethanscharlie.TestUtils;
import java.util.List;

import io.github.ethanscharlie.payloadbuilders.RatioPayloadBuilder;
import org.junit.jupiter.api.Test;

public class RatioPayloadBuilderTest {

    private final RatioPayloadBuilder builder = new RatioPayloadBuilder();

    @Test
    public void testMatchingList() {
        List<Payload> result = builder.build(TestUtils.testingPayloads);

        assertNotNull(result);
        assertEquals(8, result.size());

        assertEquals("Seed Viability", result.get(0).experiment());
        assertEquals("Yeast Fermentation", result.get(1).experiment());
        assertEquals("Cloud Patterns", result.get(2).experiment());
        assertEquals("Mice Tumors", result.get(3).experiment());
        assertEquals("Cosmic Rays", result.get(4).experiment());
        assertEquals("Relativity", result.get(5).experiment());
        assertEquals("Microgravity Plant Growth", result.get(6).experiment());
        assertEquals("Micrometeorites", result.get(7).experiment());

        int totalWeight = result.stream()
                .mapToInt(Payload::weightInKilograms)
                .sum();
        assertEquals(559, totalWeight);
        assertTrue(totalWeight <= 700);

        int totalRating = result.stream()
                .mapToInt(Payload::rating)
                .sum();
        assertEquals(50, totalRating);
    }

    @Test
    public void testEmptyList() {
        List<Payload> result = builder.build(List.of());

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testListWithOneElement() {
        Payload single = new Payload(1, "Single Payload", 100, 10);

        List<Payload> result = builder.build(List.of(single));

        assertNotNull(result);
        assertEquals(1, result.size());

        assertEquals("Single Payload", result.get(0).experiment());
        assertEquals(100, result.get(0).weightInKilograms());
        assertEquals(10, result.get(0).rating());
    }
}
