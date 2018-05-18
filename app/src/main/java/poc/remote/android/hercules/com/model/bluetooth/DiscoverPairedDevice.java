package poc.remote.android.hercules.com.model.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import poc.remote.android.hercules.com.model.IModel;

import static poc.remote.android.hercules.com.model.bluetooth.ErrorType.BLUETOOTH_NOT_SUPPORTED;
import static poc.remote.android.hercules.com.model.bluetooth.ErrorType.BLUETOOTH_OFF;
import static poc.remote.android.hercules.com.model.bluetooth.ErrorType.NO_PAIRED_BLUETOOTH_DEVICE;

public class DiscoverPairedDevice {

    public void findPairedDevices(IModel model) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isEnabled()) {
                Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();
                if (bondedDevices != null && !bondedDevices.isEmpty()) {
                    List<BluetoothDevice> bluetoothDevices = new ArrayList<>();
                    bluetoothDevices.addAll(bondedDevices);
                    model.pairedDevicesModel(bluetoothDevices);
                } else {
                    model.onErrorModel(NO_PAIRED_BLUETOOTH_DEVICE);
                }
            } else {
                model.onErrorModel(BLUETOOTH_OFF);
            }
        } else {
            model.onErrorModel(BLUETOOTH_NOT_SUPPORTED);
        }
    }
}
