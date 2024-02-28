package com.lrpa.app.persistance.entity.audit;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * @author ROMULO
 * @package com.lrpa.app.persistance.entity
 * @license Lrpa, zephyr cygnus
 * @since 27/2/2024
 */
@EntityListeners({AuditingEntityListener.class})
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class TemplateEntity {
    @CreatedDate
    protected LocalDateTime createdDate;
    @LastModifiedDate
    protected LocalDateTime lastModifiedDate;
}
