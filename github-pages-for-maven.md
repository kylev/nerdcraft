---
title: GitHub Pages for Maven
layout: default
---

<p class="bg-danger">This article is a work in progress. Maven is
hard, and making this work cleanly may take me a while.</p>

[GitHub pages](https://pages.github.com/) are amazing. It's a free,
high-performance web site that every GitHub user gets just for signing
up. Add to that all the cool stuff you can do with Jekyll and a
`gh-pages` branch and it is pretty hard to resist.

[Maven](http://maven.apache.org) is similarly cool. It's a mechanism
that Minecraft mod developers are already using, perhaps without even
realizing it. Once set up, it allows us to use and create shared
pieces of Java without really thinking about it. Adding a few lines to
a Gradle build file lets us build complex projects with myriad
dependencies with little effort.

However, publishing Maven is a little more difficult (or at least
mysterious) than it should be. This is my attempt to remedy that,
using GitHub's Pages mechanisms for free hosting.

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
