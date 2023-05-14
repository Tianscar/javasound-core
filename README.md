# JavaSound Framework Core
The stand-alone JavaSound framework core, ported from JDK. If you want to use the decoder/encoder (or third-party plugins) from JavaSound framework without include the whole `java.desktop` module (e.g. play `AudioInputStream` with OpenAL), you can include it to your project as a dependency.

Details of the port:  
From BellSoft Liberica JDK 8  
`com.sun.media.sound` -> `com.sun.media.sound`  
`javax.sound` -> `javax.sound`  
Removed all security managers, native-code related classes and `JavaSoundAudioClip.java`.

## Add the library to your project (gradle)
1. Add the Maven Central repository (if not exist) to your build file:
```groovy
repositories {
    ...
    mavenCentral()
}
```

2. Add the dependency:
```groovy
dependencies {
    ...
    implementation 'com.tianscar.javasound:javasound-core:1.0.0'
}
```

## Usage
[Tests](/src/test/java/com/tianscar/javasound/core/test)

Note you need to download test audios [here](https://github.com/Tianscar/fbodemo1) and put them to /src/test/java/resources to run the test code properly!

## License
[GPLv2+CE](/LICENSE)
