package model;

public class Fedora extends Linux {
    public Fedora(String version) {
        super("Fedora", version);
    }

    @Override
    public String getDefaultDesktopEnvironment() {
        return "KDE Plasma";
    }
}