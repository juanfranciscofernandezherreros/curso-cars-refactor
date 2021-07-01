package com.fernandez.cars.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class LogsAPI {

    private Long id;

    private int identificador;

    private String uuid;

    private String request;

    private String data;

    private String response;

    private String method;

    private String username;

    private String methodName;

    private String className;

    private int status;

    private String args;

    private Object body;

    private Map<String, List<String>> parametros;

    private Map<String, String>  headers;

    private String fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public Map<String, List<String>> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, List<String>> parametros) {
        this.parametros = parametros;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Map<String, String>  getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    @Override
    public String toString() {
        return "LogsAPI [id=" + id + ", identificador=" + identificador + ", uuid=" + uuid + ", request=" + request
                + ", data=" + data + ", response=" + response + ", method=" + method + ", username=" + username
                + ", methodName=" + methodName + ", className=" + className + ", status=" + status + ", args=" + args
                + ", body=" + body + ", parametros=" + parametros + ", headers=" + headers + ", fecha=" + fecha + "]";
    }

}
