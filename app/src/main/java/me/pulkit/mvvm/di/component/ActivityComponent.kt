package me.pulkit.mvvm.di.component

import dagger.Component
import me.pulkit.mvvm.di.ActivityScope
import me.pulkit.mvvm.di.module.ActivityModule
import me.pulkit.mvvm.ui.topheadline.TopHeadlineActivity

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)

}