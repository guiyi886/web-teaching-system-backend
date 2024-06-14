package teaching.system.backend.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/06/14/10:00
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    private long total;
    private List rows;
}
