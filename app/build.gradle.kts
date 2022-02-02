plugins {
    appPlugins().forEach(::id)
}

android {

    namespace = "com.revolhope.composeutilscore"

    applyAppDefaultConfig()

    applySigningConfig(
            SigningData(
                    name = release,
                    keystore = file("app_release_keystore.jks"),
                    keystorePassword = "ComposeUtilsCore02022022!:)*",
                    alias = "release_sign_key",
                    password = "ComposeUtilsCore02022022!:)*"
            )
    )

    applyAppFlavors()

    applyCompileOptions()

    kotlinOptions { jvmTarget() }

    excludeCommonPackages()
}

dependencies {

    androidCore()
    androidRuntime()

    compose()

    test()
}