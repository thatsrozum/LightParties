# LightParties
## A lightweight library for simple parties

> [!NOTE]
> This library doesn't do anything on its own, you have to implement commands or anything else yourself!

### What does it feature?:
- Managing parties in an easy way
- Sending invitations with expiration
- Custom events for listeners <ins>(Not yet implemented)</ins>


### How to add this library to your plugin

<details>

<summary>Gradle (Groovy DSL)</summary>

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.thatsrozum:LightParties:main-SNAPSHOT'
}
```

</details>

<details>

<summary>Gradle (Kotlin DSL)</summary>

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.thatsrozum:LightParties:main-SNAPSHOT")
}
```

</details>

<details>

<summary>Maven</summary>

```maven
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.thatsrozum</groupId>
        <artifactId>LightParties</artifactId>
        <version>main-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

</details>

### How to load it
```java
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        LightPartiesAPI lightPartiesAPI = getServer().getServicesManager().load(LightPartiesAPI.class);

        if (lightPartiesAPI != null) {
            // Do whatever you want to do
        } else {
            // Handle if your plugin couldn't load it
        }
    }
}
```
