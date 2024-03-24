package bg.tu_varna.sit.f21621588.models;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResponseMessage {
    private ServerCode code;
    private String message;

    protected ResponseMessage() {
        this.code = ServerCode.SUCCESS;
    }

    protected ResponseMessage(ServerCode code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServerCode getCode() {
        return code;
    }

    public void setCode(ServerCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}