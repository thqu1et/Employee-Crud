package kz.thquiet.employee_crud.dto.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageableDTO {

    @PositiveOrZero
    protected int pageNumber = 0;

    @Positive
    protected int pageSize = 10;

    protected String sortBy = "id";

    protected Sort.Direction direction = Sort.Direction.DESC;
}
