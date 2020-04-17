# Beans Binding (JSR 295)

This is a fork of a [clone](https://github.com/JFormDesigner/swing-beansbinding) of the original SVN repo.
This fork provides (base) classes for "value properties" (similar to JavaFX's `SimpleXXXProperty` classes), as well as a [Gradle](https://gradle.org/) project structure to support usage with [Jitpack.io](https://jitpack.io/#HoldYourWaffle/swing-beansbinding).

## Usage with Gradle

```gradle
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.HoldYourWaffle:swing-beansbinding:v1.3.0'
}
```

If you don't need/want the "value properties" you can use `v1.2.1`, which contains the same code as [JFormDesigner/swing-beansbinding](https://github.com/JFormDesigner/swing-beansbinding) but with Jitpack support.

<!-- TODO provide usage examples -->

## Links

- https://jcp.org/en/jsr/detail?id=295
- https://jitpack.io/

## License

[GNU LESSER GENERAL PUBLIC LICENSE, Version 2.1](beansbinding/license.txt)
