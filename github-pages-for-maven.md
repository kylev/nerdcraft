---
title: GitHub Pages for Maven
layout: default
---

<h4 class="bg-danger">This article is a work in progress. Maven is
hard, and making this work cleanly may take me a while.</h4>

[GitHub pages](https://pages.github.com/) are amazing. It's a free,
high-performance, generated web site that every GitHub user gets just
for signing up. Add to that all the cool stuff you can do with
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
copying part of other projects into your own (usually in a `src/api`
directory), or having to chase down a variety of dependent .jar files
and other mods to get your own mod to compile. Set up correctly,
compiling and debugging a mod can be as easy as

- Check out the code (from GitHub or elsewhere).
- Run `gradlew setupDecompWorkspace runClient`.

In just minutes, a running Minecraft instance with the mod loaded.
How cool is that? Now anyone that wants to submit a fix, or a partner
that you're working with, can compile/test/run in few commands, and
everything you need to keep in sync (like other mods or libraries) is done
via the source code and `build.gradle`.

First, you should understand that the line `apply plugin: 'forge'`
already gives us much of what we need. That plugin also applies the
`maven` plugin
([see here](https://github.com/MinecraftForge/ForgeGradle/blob/master/src/main/java/net/minecraftforge/gradle/user/UserBasePlugin.java#L66)). So, you're halfway there!

So all we need to do is configure the uploadArchives task, and the
only part that isn't set for us is the place we want to publish to. Just
add something like this to your `build.gradle`:

```groovy
uploadArchives {
    repositories {
        mavenDeployer {
            repository(url: 'file://localhost/Users/kylev/Work/maven')
        }
    }
}
```

You'll see my directories in the repository URL there; you'll want to
replace that with your own. And don't be thrown off by the weird
"URL": it's just a
[file URL scheme](http://en.wikipedia.org/wiki/File_URI_scheme)
location.

TODO Setting up gh-pages, Deobf jar, API jar, skipping distrib jar
https://github.com/AbrarSyed/SecretRoomsMod-forge/blob/master/build.gradle
