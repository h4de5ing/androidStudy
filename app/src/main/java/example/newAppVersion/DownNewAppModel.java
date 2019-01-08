package example.newAppVersion;


import android.annotation.SuppressLint;
import android.app.Application;
import android.app.DownloadManager;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;

import com.style.base.BaseServiceModel;
import com.style.utils.OpenFileUtil;

import java.io.File;

public class DownNewAppModel extends BaseServiceModel {
    MutableLiveData<Boolean> downLoadNewVersionSuccess = new MutableLiveData<>();

    private File mAppFile;

    public DownNewAppModel(@NonNull Application application) {
        super();
    }

    /**
     * 开始下载新版App
     * @param versionInfo
     */
    @SuppressLint("CheckResult")
    public void startDownloadApp(String versionInfo) {
        //执行子线程run中的代码逻辑
    }

}
