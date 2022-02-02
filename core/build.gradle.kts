plugins {
    libPlugins(GradlePlugin.Publish).forEach(::id)
}

android {

    namespace = "com.revolhope.core"

    applyLibModuleDefaultConfig()

    applyLibFlavors()

    applyCompileOptions()

    kotlinOptions { jvmTarget() }

    withFeatures(Feature.Compose)

    composeOptions { kotlinCompilerExtensionVersion = DependencyVersion.compose }

    excludeCommonPackages()
}

dependencies {

    androidCore()
    androidRuntime()
    androidExtensions()
    androidViewModel()

    ktxCoroutines()

    compose()

    test()
}

publish()