package com.lrpa.app.util;

import com.lrpa.app.controller.dto.request.PageableDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;

/**
 * @author ROMULO
 * @package com.lrpa.app.util
 * @license Lrpa, zephyr cygnus
 * @since 28/2/2024
 */
public final class PageableUtil {
    private PageableUtil() {
    }

    public static Pageable setPageable(PageableDto pageableDto) {
        var page = pageableDto.getPage();
        var size = pageableDto.getSize();
        var order = pageableDto.getOrder();
        var field = pageableDto.getField();

        if (Objects.equals(order, "1")) {
            field = Objects.requireNonNullElse(field, "id");
            return PageRequest.of(page, size, Sort.by(field).ascending());
        }
        if (Objects.equals(order, "0")) {
            field = Objects.requireNonNullElse(field, "id");
            return PageRequest.of(page, size, Sort.by(field).descending());
        }

        return PageRequest.of(page, size, Sort.by("id").ascending());
    }
}

