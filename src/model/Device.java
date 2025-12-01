package model;

public class Device {
    private String user;
    private OperatingSystem os;

    public Device(String user, OperatingSystem os) {
        this.user = user;
        this.os = os;
    }

    public Device(String user) {
        this.user = user;
        this.os = null;
    }

    public String getUser() {
        return user;
    }

    public OperatingSystem getOs() {
        return os;
    }
}