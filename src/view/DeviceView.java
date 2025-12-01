package view;

import controller.IDeviceController;
import exception.EmptyListException;
import exception.InvalidMenuException;
import exception.InvalidOSException;
import model.*;
import utils.CLIUtils;

import java.util.List;

public class DeviceView {
    private IDeviceController controller;

    public DeviceView(IDeviceController controller) {
        this.controller = controller;
    }

    public void start() {
        boolean berjalan = true;
        while (berjalan) {
            try {
                displayMenu();
                int pilihan = CLIUtils.readInt("");

                switch (pilihan) {
                    case 1:
                        addDeviceMenu();
                        break;
                    case 2:
                        showAllDevices();
                        break;
                    case 3:
                        showSortedDevices();
                        break;
                    case 0:
                        berjalan = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        throw new InvalidMenuException("Salah menu: " + pilihan);
                }
            } catch (InvalidMenuException | InvalidOSException | EmptyListException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah device");
        System.out.println("2. Tampilkan semua device");
        System.out.println("3. Tampilkan semua device terurut berdasarkan OS");
        System.out.println("0. Keluar");
    }

    private void addDeviceMenu() throws InvalidOSException {
        String nama = CLIUtils.readString("Masukkan nama pengguna:");
        
        System.out.println("Pilih OS: 1. Windows, 2. Ubuntu, 3. Fedora");
        int pilihanOS = CLIUtils.readInt("");
        
        if (pilihanOS < 1 || pilihanOS > 3) {
            throw new InvalidOSException("Salah pilihan operating system: " + pilihanOS);
        }

        String versi = CLIUtils.readString("Masukkan versi");
        OperatingSystem sistemOperasi = null;

        switch (pilihanOS) {
            case 1:
                sistemOperasi = new Windows(versi);
                break;
            case 2:
                sistemOperasi = new Ubuntu(versi);
                break;
            case 3:
                sistemOperasi = new Fedora(versi);
                break;
        }

        Device device = new Device(nama, sistemOperasi);
        controller.addDevice(device);
        System.out.println("Device added successfully.");
    }

    private void showAllDevices() throws EmptyListException {
        List<Device> daftarDevice = controller.getAllDevices();
        if (daftarDevice.isEmpty()) {
            throw new EmptyListException("Daftar device kosong");
        }
        
        System.out.println("--- Booting Devices ---");
        for (Device device : daftarDevice) {
            System.out.println(device.getUser() + " booted: " + device.getOs().getBootInfo());
        }
    }

    private void showSortedDevices() throws EmptyListException {
        List<Device> daftarDevice = controller.getAllDevices();
        if (daftarDevice.isEmpty()) {
            throw new EmptyListException("Daftar device kosong");
        }

        List<Device> daftarTerurut = controller.getDevicesSortedByOS();
        
        System.out.println("--- Devices Sorted by OS ---");
        for (Device device : daftarTerurut) {
            System.out.println(device.getUser() + " booted: " + device.getOs().getBootInfo());
        }
    }
}