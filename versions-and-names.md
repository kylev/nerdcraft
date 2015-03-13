---
title: Versions and Names
layout: default
---

### Versions and Naming

> There are only two hard things in computer science: cache
> invalidation, naming things, and off-by-one errors.
>
> <footer>Phil Karlton (and others)</footer>

There are a lot of jokes about naming things in the software
engineering world. This is probably because it is one of the things
that, if done wrong, can continue to haunt you for the life of a
project. Every single line you write further entrenches that
name. Even with modern IDEs that make it easy to refactor and rename,
things can be aggravating.  Mix in public APIs against which other
people are writing who-knows-how-much code, and a developer is likely
to have a serious "I can't believe I named it that!" moment.

That said, there are some pretty well-worn conventions for both naming
and versioning that, when applied to mod development, can ease several
types of pain.

#### Java Package Names

This one should be easy: there is a mention of the
[Maven and Java community's guide on how to name things](http://maven.apache.org/guides/mini/guide-naming-conventions.html)
right there in the default `build.gradle`.

I know it will seem silly, but I do recommend using only lower case
letters for your Java packages.  This has long been the convention,
it's derived from the DNS system, and it'll look "normal" to any Java
programmer that looks at your code. That's a good thing: clean code
encourages participation and help!

If you have a domain name, like me, it's easy: Just reverse the parts
and tack on an extra period followed by the all-lowercase name of your
project. For me, that means this repository contains code in the
`com.kylev.nerdingcraft` package.

If you don't have a domain and are using GitHub, it has become the
convention to use the `<username>.github.io` that GitHub uses for your
free [GitHub Pages](https://pages.github.com/) site. Again, just
reverse the parts (in lowercase) and tack on the project name. Using
this convention, I'd call my mod `io.github.kylev.nerdingcraft`.

Failing either of these cases, the main rules are to be unique and avoid
stepping on others' toes:

- Don't use a simple word or name. Your package `karen` or
`awesomemod` is likely to get confused with something created by
another Karen or developer doing something awesome.

- Don't use a package that isn't your own. As much as you love
Minecraft putting your package inside the `net.minecraft` or
`com.mojang` namespace is going to cause confusion. And if your mod
breaks and people start tweeting at [jeb_](https://twitter.com/jeb_),
you're gonna have a bad day.

#### Mod Names for Computers and Humans

TODO

#### Version Numbers

TODO

#### Automating It

TODO

One of the fist things I do when I start a Java project with Gradle is
to create a `gradle.properties` file. This will be loaded by Gradle on
every build or task. Defining a few base variables provides me a
1-stop place to change the versions or parameters for the build. It
also makes automated builds easier down the road.

For a mod project, I start with something like this.

```properties
# The version of my mod
modVersion = 0.1.2
# The version of Minecraft to build against
minecraftVersion = 1.7.10
# The version of Forge to use for the build
forgeVersion = 10.13.2.1291
```

As you can see, I'm treating each versioned "thing" separately. The
derived names that combine those "things" are easy to build out of
these basic parts. For example:

```groovy
# The combined Minecraft and Forge version
"${minecraftVersion}-${forgeVersion}"
# The version of Minecraft this version of the mod is built for
"${minecraftVersion}-${modVersion}"
```
