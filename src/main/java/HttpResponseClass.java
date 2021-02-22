public class HttpResponseClass {

    String status;
    String reason;
    String headers;
    String body;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpResponseClass(String status, String reason, String headers, String body) {
        this.status = status;
        this.reason = reason;
        this.headers = headers;
        this.body = body;
    }
}
