# Developer Notes

## maven

- This project uses `maven-wrapper`:
  - Use `./mvnw` from the command-line.
  - If using intellij with the jenv maven wrapper plugin, you need to run `./mvnw` from the command-line first to
    trigger installation.
  - `maven-enforcer-plugin` is used:
    - To force plugin versions to be declared (via `pluginManagement`.)
    - To force dependency convergence (via `dependencyManagement`.)
    - To force maven version (to match `.mvn/maven-wrapper.properies`.)
    - Versions are declared as maven properties. 
  - `spring-cloud-dependencies` BOM is using in project pom, so should override settings in `spring-dependencies` BOM.
  - `maven-versions-plugin` is enabled and can be used to detect possible version upgrades for dependencies or plugins.
    - using `./mvnw versions:display-property-updates` gives the most sane output, as it only checks for later versions
      where a property is defined.
    - `display-dependency-updates` displays upgrades for any dependency, but often the curated dependency versions used
      by the spring BOMs will use an older version for stability.
    - `display-plugin-updates` doesn't produce too much output, but effectively has the same problem as
      `display-dependency-updates`.
  - unsolved scenarios:
    - for some plugins and dependencies we specify a version as a property, because the parent POM and dependency BOMs
      do not specify a version or use too old a version. However, if a newer parent POM or dependency BOM defines the
      dependency or plugin properly then this will result in an unnecessary or possibly conflicting definition in our
      local POM.