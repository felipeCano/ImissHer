pluginManagement {
    //ext.hilt_version = '2.28-alpha
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            //if( requested.id.id == 'dagger.hilt.android.plugin') {
            //useModule("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
            // }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "IMissHer"
include(":app")
