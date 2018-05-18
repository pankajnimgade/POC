package poc.remote.android.hercules.com.presenter;

import android.bluetooth.BluetoothDevice;

import java.util.List;

import poc.remote.android.hercules.com.model.bluetooth.ErrorType;

public interface IPresenter {
    void discoverBluetoothDevice();

    void onError(ErrorType bluetoothNotSupported);

    void pairedDevicesPresenter(List<BluetoothDevice> bluetoothDevices);
}
