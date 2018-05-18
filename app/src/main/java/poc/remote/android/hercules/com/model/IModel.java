package poc.remote.android.hercules.com.model;

import android.bluetooth.BluetoothDevice;

import java.util.List;

import poc.remote.android.hercules.com.model.bluetooth.ErrorType;

public interface IModel {
    void discoverBluetoothDeviceModel();

    void onErrorModel(ErrorType errorType);

    void pairedDevicesModel(List<BluetoothDevice> bluetoothDevices);
}
