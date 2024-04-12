package com.jurgenvrapi.progettoS6D5.payloads;

import com.jurgenvrapi.progettoS6D5.enums.StatoDispositivo;
import jakarta.validation.constraints.*;

public record DispositivoDTO(
        @NotEmpty(message = "L'ID è obbligatorio")
        String id,
        @NotEmpty(message = "Il tipo è obbligatorio")
        String tipo,
        @NotNull(message = "Lo stato è obbligatorio")
        StatoDispositivo stato
) {
}

