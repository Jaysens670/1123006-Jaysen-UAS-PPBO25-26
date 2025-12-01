package controller;

import model.Device;
import java.util.List;

public interface IDeviceController {
    void addDevice(Device device);
    List<Device> getAllDevices();
    List<Device> getDevicesSortedByOS();
}