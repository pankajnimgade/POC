package poc.remote.android.hercules.com.model;

import android.bluetooth.BluetoothDevice;

import java.util.List;

import poc.remote.android.hercules.com.model.bluetooth.DiscoverPairedDevice;
import poc.remote.android.hercules.com.model.bluetooth.ErrorType;
import poc.remote.android.hercules.com.presenter.IPresenter;

public class Model implements IModel {

    private IPresenter presenter;

    private DiscoverPairedDevice discoverPairedDevice;

    public Model(IPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void discoverBluetoothDeviceModel() {
        discoverPairedDevice = new DiscoverPairedDevice();
        discoverPairedDevice.findPairedDevices(this);
    }

    @Override
    public void onErrorModel(ErrorType errorType) {
        this.presenter.onError(errorType);
    }

    @Override
    public void pairedDevicesModel(List<BluetoothDevice> bluetoothDevices) {
        this.presenter.pairedDevicesPresenter(bluetoothDevices);
    }
}
