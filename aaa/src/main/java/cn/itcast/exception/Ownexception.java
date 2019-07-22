package cn.itcast.exception;

public class Ownexception extends Exception {
    private String message;

    public Ownexception(String message) {
        this.message = message;
    }

//    public Ownexception(String message, String message1) {
//        super(message);
//        this.message = message1;
//    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
