package me.pulkit.mvvm.di.component

import android.content.Context
import dagger.Component
import me.pulkit.mvvm.MVVMApplication
import me.pulkit.mvvm.data.api.NetworkService
import me.pulkit.mvvm.data.repository.TopHeadlineRepository
import me.pulkit.mvvm.di.ApplicationContext
import me.pulkit.mvvm.di.module.ApplicationModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MVVMApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getTopHeadlineRepository(): TopHeadlineRepository

}