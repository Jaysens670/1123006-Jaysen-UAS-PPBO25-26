package model;

public abstract class Linux extends OperatingSystem {
    protected String desktopEnvironmentName;

    public Linux(String name, String version) {
        super(name, version);
        this.desktopEnvironmentName = getDefaultDesktopEnvironment();
    }

    public abstract String getDefaultDesktopEnvironment();

    @Override
    public String getBootInfo() {
        return "Booting " + name + " " + version + " with " + desktopEnvironmentName;
    }
}