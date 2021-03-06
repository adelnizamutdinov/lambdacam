package adeln.telegram.camera

import android.app.Application
import android.os.StrictMode
import com.squareup.leakcanary.LeakCanary
import common.android.threadPolicy
import common.android.vmPolicy
import timber.log.Timber

class App : Application() {
  override fun onCreate(): Unit {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      StrictMode.setVmPolicy(vmPolicy())
      StrictMode.setThreadPolicy(threadPolicy())
      Timber.plant(Timber.DebugTree())
      LeakCanary.install(this)
    }
//    Fabric.with(this, Crashlytics())
  }
}
