import controller.DeviceController;
import controller.IDeviceController;
import view.DeviceView;

public class main {
    public static void main(String[] args) {
        IDeviceController controller = new DeviceController();
        DeviceView view = new DeviceView(controller);

        view.start();
    }
}