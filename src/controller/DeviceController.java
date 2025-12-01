package controller;

import model.Device;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DeviceController implements IDeviceController {
    private List<Device> devices;

    public DeviceController() {
        this.devices = new ArrayList<>();
    }

    @Override
    public void addDevice(Device device) {
        devices.add(device);
    }

    @Override
    public List<Device> getAllDevices() {
        return devices;
    }

    @Override
    public List<Device> getDevicesSortedByOS() {
        return devices.stream()
                .sorted(Comparator.comparing(device -> device.getOs().getName()))
                .collect(Collectors.toList());
    }
}