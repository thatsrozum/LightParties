# PartyLib
A lightweight library for parties.

#### Prerequisites
- **Java 11+** – Server must run at least this Java version.
- **Minecraft 1.13+** – Server must run at least this version.
- **Spigot API** – Built on Spigot, also works on **Paper** servers.

#### Features
- Manage parties easily
- Send invitations with expiration
- Custom events <ins>(coming soon)</ins>

---

### Getting started

1. Download the plugin and put it in your `plugins/` folder.
2. Add PartyLib as a softdepend in your `plugin.yml`:
```yaml
softdepend: [PartyLib]
```
3. Add the JitPack repository and dependency.

<details> <summary>Gradle (Groovy DSL)</summary>

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.thatsrozum:PartyLib:main-SNAPSHOT'
}
```

</details> <details> <summary>Gradle (Kotlin DSL)</summary>

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.thatsrozum:PartyLib:main-SNAPSHOT")
}
```
</details> <details> <summary>Maven</summary>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.thatsrozum</groupId>
        <artifactId>PartyLib</artifactId>
        <version>main-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

</details>

### Usage

Load it with the Services Manager:
```java
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PartyLibAPI partyLibAPI = getServer().getServicesManager().load(PartyLibAPI.class);

        if (partyLibAPI != null) {
            // Your integration logic here
        } else {
            getLogger().warning("PartyLib could not be loaded!");
        }
    }
}
```

# PartyLib
A lightweight library for parties.

#### Prerequisites
- **Java 11+** – Server must run at least this Java version.
- **Minecraft 1.13+** – Server must run at least this version.
- **Spigot API** – Built on Spigot, also works on **Paper** servers.

#### Features
- Manage parties easily
- Send invitations with expiration
- Custom events <ins>(coming soon)</ins>

---

### Getting started

1. Download the plugin and put it in your `plugins/` folder.
2. Add PartyLib as a softdepend in your `plugin.yml`:
```yaml
softdepend: [PartyLib]
```
3. Add the JitPack repository and dependency.

<details> <summary>Gradle (Groovy DSL)</summary>

```groovy
repositories {
    mavenCentral()
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.thatsrozum:PartyLib:main-SNAPSHOT'
}
```

</details> <details> <summary>Gradle (Kotlin DSL)</summary>

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.thatsrozum:PartyLib:main-SNAPSHOT")
}
```
</details> <details> <summary>Maven</summary>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.thatsrozum</groupId>
        <artifactId>PartyLib</artifactId>
        <version>main-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

</details>

### Usage

Load it with the Services Manager:
```java
public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        PartyLibAPI partyLibAPI = getServer().getServicesManager().load(PartyLibAPI.class);

        if (partyLibAPI != null) {
            // Your integration logic here
        } else {
            getLogger().warning("PartyLib could not be loaded!");
        }
    }
}
```

# [Javadocs (Dokka)](https://thatsrozum.github.io/PartyLib/javadocs/index.html)