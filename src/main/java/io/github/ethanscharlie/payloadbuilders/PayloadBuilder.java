package io.github.ethanscharlie.payloadbuilders;

import io.github.ethanscharlie.model.Payload;
import java.util.List;

public interface PayloadBuilder {
    List<Payload> build(List<Payload> availablePayloads);
}
