---
title: GitHub Pages for Maven
layout: default
---

<h4 class="bg-danger">This article is a work in progress. Maven is
hard, and making this work cleanly may take me a while.</h4>

[GitHub pages](https://pages.github.com/) are amazing. It's a free,
high-performance web site that every GitHub user gets just for signing
up. Add to that all the cool stuff you can do with
[Jekyll](http://jekyllrb.com/) and a `gh-pages` branch and it is
pretty hard to resist. You might even consider using it for templating
and deploying your mod's site or documentation.

[Maven](http://maven.apache.org) is similarly cool, if a little less
obvious. As a long-time part of the Java ecosystem, Minecraft mod
developers are already using it, perhaps without even realizing
it. Once set up, Maven allows us to use and create shared pieces of Java
without really thinking about it. Adding a few lines to a Gradle build
file lets us build complex projects with myriad dependencies with
little effort.

The main problem that you can solve with Maven is the old practice of
copying part of other projects into your own, or having to chase down
a variety of dependent .jar files and other mods to get your own mod
to compile. Set up correctly, compiling and debugging a mod can be as easy as

- Check out the code (from GitHub or elsewhere).
- Run `gradlew setupDecompWorkspace runClient`.

TODO

```groovy
apply plugin "maven-publish"

publishing {
    repositories {
        maven {
            url "/Users/kylev/Work/maven"
        }
    }

    publications {
        mavenJava(MavenPublication) {
            from components.java
        }
    }
}
```
