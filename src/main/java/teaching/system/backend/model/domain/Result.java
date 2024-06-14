package teaching.system.backend.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: __yun
 * @Date: 2024/06/14/9:51
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String msg;
    private Object data;
    private String status;


    public Result(String msg, String status) {
        this.msg = msg;
        this.status = status;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public Result(Object data) {
        this.data = data;
    }

    static public Result success() {
        return new Result("OK", "200");
    }

    static public Result success(Object data) {
        return new Result("OK", data, "200");
    }

    static public Result error(String fault) {
        return new Result(fault, "500");
    }

    static public Result error(String fault, String status) {
        return new Result(fault, status);
    }
}
