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
  - `forbiddenapis` plugin used to detect use of apis we want to avoid.
  - `jgiven-maven-plugin` is used to generate html report in `verify` phase.
    - potentially we could use a BDDTest marker and not fail fast on tests to generate failures for reports.
  - Unsolved scenarios:
    - Upgrades to plugins an dependencies:
      - For some plugins and dependencies we specify a version as a property, because the parent POM and dependency BOMs
        do not specify a version or use too old a version.
      - However, if a newer parent POM or dependency BOM defines the dependency or plugin properly then this will result
        in an unnecessary or possibly conflicting definition in our local POM.

## jgiven

- spring and junit5:
  - Created spring scenario test base class as described in:
    https://stackoverflow.com/questions/53972799/is-it-possible-to-combine-jgiven-spring-with-jgiven-junit-5
  - Once next version of jgiven is released that class should be included by jgiven.
- Although jgiven maven plugin works when running a maven build, the location for report files needs to be set via
  system properties when running outside of maven.
  - This is a problem when running tests in IDE as this isn't particularly convenient.
  - Instead we mark the `/jgiven-reports` directory as ignored.
- Also encountered an odd issue with HelloStage class not being recognised as being marked with `@JGivenStage` when
  explicitly declared as a `@Bean` in an inner spring configuration class.
  - Not sure what that was about, as separating the spring configuration class and picking up the stage via component
    scanning appears to be a more sensible use-case anyway. 
  

## TODO

[] spring formatter
[] errorprone for compiler
[] sdkman env for java version
[] skaffold?
[] docker image?