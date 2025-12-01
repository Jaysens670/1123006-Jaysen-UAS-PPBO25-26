package model;

public abstract class OperatingSystem {
    protected String name;
    protected String version;

    public OperatingSystem(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public OperatingSystem(String name) {
        this(name, "Unknown");
    }

    public String getName() {
        return name;
    }

    public abstract String getBootInfo();
}