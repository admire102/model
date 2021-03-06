package com.igniubi.model.dtos.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.igniubi.model.enums.common.ResultEnum;

/**
 * 公共返回响应体
 * <p>
 *
 * @author 徐擂
 * @version 1.0.0
 * @date 2018-12-5
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultDTO<T> extends BaseDTO{

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 响应描述
     */
    private String message;

    /**
     * 时间戳
     */
    private Long timestamp;

    /**
     * 返回数据
     */
    private T data;

    public ResultDTO() {
        this(ResultEnum.OK);
    }

    public ResultDTO(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }

    public ResultDTO(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }


    public ResultDTO(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static class ResultDTOBuilder{
        ResultDTO resultDTO;

        public ResultDTOBuilder() {
            this.resultDTO= new ResultDTO();
        }

        public ResultDTO.ResultDTOBuilder code(int code){
            resultDTO.code=code;
            return this;
        }
        public ResultDTO.ResultDTOBuilder message(String message){
            resultDTO.message=message;
            return this;
        }
        public ResultDTO.ResultDTOBuilder data(Object data){
            resultDTO.data=data;
            return this;
        }
        public ResultDTO build(){
            return resultDTO;
        }
    }
    @Override
    public String toString() {
        return "响应结果【" + this.code + "】,:" + this.message;
    }

    public Integer getCode() { return code; }

    public void setCode(Integer code) { this.code = code; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public Long getTimestamp() { return timestamp; }

    public void setTimestamp(Long timestamp) { this.timestamp = timestamp; }

    public T getData() { return data; }

    public void setData(T data) { this.data = data; }
}
