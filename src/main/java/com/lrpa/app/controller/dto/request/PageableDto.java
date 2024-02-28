package com.lrpa.app.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author ROMULO
 * @package com.lrpa.app.controller.dto.request
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
@Getter @NoArgsConstructor @AllArgsConstructor
@ParameterObject
public class PageableDto implements Pageable, Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    //@NotEmpty(message = "Page number is required")
    private Integer page;
    //@NotEmpty(message = "Size is required")
    private Integer size;
    @Pattern(regexp = "[0-1]", message = "Order must be 0 or 1")
    private String order;
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Field must be a string")
    private String field;

    @Override
    public int getPageNumber() {
        return this.page;
    }

    @Override
    public int getPageSize() {
        return this.size;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
