package poc.remote.android.hercules.com.view;

import android.bluetooth.BluetoothDevice;

import java.util.List;

import poc.remote.android.hercules.com.model.bluetooth.ErrorType;

public interface IMainActivity {

    void onErrorUi(ErrorType errorType);

    void onPairedDevicesUi(List<BluetoothDevice> bluetoothDevices);
}
