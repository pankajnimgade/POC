package poc.remote.android.hercules.com.presenter;

import poc.remote.android.hercules.com.model.bluetooth.ErrorType;

public interface IPresenter {
    void discoverBluetoothDevice();

    void onError(ErrorType bluetoothNotSupported);
}
