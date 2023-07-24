package br.com.alura.lojadeesporte

import android.app.Application
import br.com.alura.lojadeesporte.di.daoModule
import br.com.alura.lojadeesporte.di.testeDatabaseModule
import br.com.alura.lojadeesporte.di.uiModule
import br.com.alura.lojadeesporte.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppApplication)
            modules(
                listOf(
                    testeDatabaseModule,
                    daoModule,
                    uiModule,
                    viewModelModule
                )
            )
        }
    }
}