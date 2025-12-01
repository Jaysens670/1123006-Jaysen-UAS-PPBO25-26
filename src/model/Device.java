package model;

public class Device {
    private String ownerName;
    private OperatingSystem os;

    public Device(String ownerName, OperatingSystem os) {
        this.ownerName = ownerName;
        this.os = os;
    }

    public Device(String ownerName) {
        this.ownerName = ownerName;
        this.os = null;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public OperatingSystem getOs() {
        return os;
    }
}