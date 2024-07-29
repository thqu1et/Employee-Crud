package kz.thquiet.employee_crud.util;

import kz.thquiet.employee_crud.dto.common.PageableDTO;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@UtilityClass
public class PageableUtils {

    public static PageRequest createPageRequest(PageableDTO dto) {
        return PageRequest.of(dto.getPageNumber(), dto.getPageSize(), Sort.by(dto.getDirection(), dto.getSortBy()));
    }
}
