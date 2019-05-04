package madhoma.test.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import madhoma.test.ui.main.MainPresenter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent {

    fun inject(presenter: MainPresenter)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun context(context: Context): Builder
    }

    companion object {
        fun init(context: Context): AppComponent =
            DaggerAppComponent.builder()
                .context(context)
                .build()
    }
}