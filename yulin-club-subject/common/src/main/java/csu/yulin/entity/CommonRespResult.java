package csu.yulin.entity;

import csu.yulin.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 通用返回结果
 *
 * @author lp
 * @create 2024-08-06-11:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespResult<T> implements Serializable {
    private Boolean success;
    private Integer code;
    private String message;
    private T data;

    public CommonRespResult(ResultCode resultCode) {
        this.success = resultCode.getSuccess();
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    /**
     * 通用返回成功（不带数据）
     */
    public static <T> CommonRespResult<T> success() {
        return new CommonRespResult<>(ResultCode.SUCCESS);
    }

    /**
     * 通用返回成功（带数据）
     */
    public static <T> CommonRespResult<T> success(T data) {
        CommonRespResult<T> result = new CommonRespResult<>(ResultCode.SUCCESS);
        result.setData(data);
        return result;
    }

    /**
     * 通用返回失败（不带数据）
     */
    public static <T> CommonRespResult<T> failure(ResultCode failResultCode) {
        return new CommonRespResult<>(failResultCode);
    }

    /**
     * 通用返回失败（带数据）
     */
    public static <T> CommonRespResult<T> failure(ResultCode failResultCode, T data) {
        CommonRespResult<T> result = new CommonRespResult<>(failResultCode);
        result.setData(data);
        return result;
    }

    /**
     * 通用返回（自定义）
     */
    public static <T> CommonRespResult<T> customResponse(Boolean success, Integer code, String message, T data) {
        return new CommonRespResult<>(success, code, message, data);
    }
}
