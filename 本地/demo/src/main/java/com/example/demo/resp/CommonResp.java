package com.example.demo.resp;

public class CommonResp<T> {

    private Boolean success = true;
    private String message;

    private T content;
    public Boolean getSuccess() { return success; }

    public void setSuccess(Boolean success) { this.success = success; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public T getContent() { return content; }

    public void setContent(T content) { this.content = content; }

    @Override
    public String toString() {
        return "CommonResp{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", content=" + content +
                '}';
    }
}
