package madhoma.test

import android.app.Application
import madhoma.test.di.AppComponent

class App : Application(){

    companion object {
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.init(this)
    }
}