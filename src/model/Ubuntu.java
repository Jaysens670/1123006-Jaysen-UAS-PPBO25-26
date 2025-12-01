package model;

public class Ubuntu extends Linux {
    public Ubuntu(String version) {
        super("Ubuntu", version);
    }

    @Override
    public String getDefaultDesktopEnvironment() {
        return "Gnome";
    }
}