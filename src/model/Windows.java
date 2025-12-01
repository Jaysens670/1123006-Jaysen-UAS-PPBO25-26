package model;

public class Windows extends OperatingSystem {

    public Windows(String version) {
        super("Windows", version);
    }

    @Override
    public String getBootInfo() {
        return "Booting " + name + " " + version;
    }
}