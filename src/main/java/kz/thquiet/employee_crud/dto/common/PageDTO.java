package kz.thquiet.employee_crud.dto.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageDTO<T> {

    private ListDTO<T> data;

    private int pageNumber;

    private long total;

    private long size;

    public PageDTO(Page<T> entity, List<T> entityDto) {
        this.setData(new ListDTO<>(entityDto));
        this.setPageNumber(entity.getNumber());
        this.setTotal(entity.getTotalElements());
        this.setSize(entity.getTotalPages());
    }


    public PageDTO(List<T> listDto, int pageNumber, int size, long count) {
        this.setData(new ListDTO<>(listDto));
        this.setTotal(count);
        this.setPageNumber(pageNumber);
        this.setSize((long) Math.ceil(count / size));
    }
}
