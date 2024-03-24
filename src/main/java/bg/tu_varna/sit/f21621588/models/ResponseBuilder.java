package bg.tu_varna.sit.f21621588.models;

public class ResponseBuilder {
    private ServerCode code;
    private String message;

    public ResponseBuilder setCode(ServerCode code) {
        this.code = code;
        return this;
    }

    public ResponseBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseMessage build() {
        return new ResponseMessage(this.code, this.message);
    }
}