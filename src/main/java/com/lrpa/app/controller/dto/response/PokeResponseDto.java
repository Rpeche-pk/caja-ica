package com.lrpa.app.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.response
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
@Getter
@JsonRootName("data")
public class PokeResponseDto implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;
        private String name;
        private String message;
        private int status;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime timeStamp;

        @Builder
        public PokeResponseDto(String name, String message, int status) {
            this.name = name;
            this.message = message;
            this.status = status;
            this.timeStamp = LocalDateTime.now();
        }


}

