package csu.yulin.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应状态码枚举
 *
 * @author lp
 * @create 2024-08-06-11:06
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(true, 200, "成功"),
    FAIL(false, 400, "请求失败");

    /**
     * 响应是否成功
     */
    private final Boolean success;
    /**
     * 响应状态码
     */
    private final Integer code;
    /**
     * 响应信息
     */
    private final String message;
}