# Developer Notes

## maven

- This project uses `maven-wrapper`:
  - Use `./mvnw` from the command-line.
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
  - `maven-failsafe-plugin` is ordered _after_ `jgiven-maven-plugin` to ensure the jgiven report are generated before a
    build is failed. 
  - `spring-javaformat-maven-plugin` is wired into the process-sources phase to automatically reformat source code.
  - Unsolved scenarios:
    - Upgrades to plugins an dependencies:
      - For some plugins and dependencies we specify a version as a property, because the parent POM and dependency BOMs
        do not specify a version or use too old a version.
      - However, if a newer parent POM or dependency BOM defines the dependency or plugin properly then this will result
        in an unnecessary or possibly conflicting definition in our local POM.

## Intellij plugins

- Error Prone Compiler - if not picked up when imported into IDE, enable with:
  
  File | Settings | Compiler | 'Java Compiler' and select 'Javac with error-prone' in 'Use compiler' box. 
- Maven Wrapper Plugin (jenv) - IDE plugin does not install maven binary, user needs to run `./mvnw` to trigger install.
- spring-javaformat - should auto activate when jar in classpath.
 
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
- Scenario tests are suffixed with `ST` rather than `Test` to avoid scenario tests being picked up by
  `maven-surefire-plugin`, which will fail the build before reports can be generated if a test fails.
- `ST` suffix is configured with via `@JGivenConfiguration` annotation on the `SimpleSpringST` base class. 
  
## spring javaformat

- spring javaformat still insists on _tabs_ instead of spaces (which is totally weird).
- But considering auto-formatters are supposed to take away the problem, how much should we bother?
- Like the way that the spring javaformat intellij plugin auto-activates when the jar is in the classpath, that way you
  don't have to turn it on in the settings.
  - No point in trying to post-process tabs into spaces after the maven plugin runs as this will just annoy the IDE
    plugin.
- Looked at the google java formatter, but you have to turn on the intellij formatter manually.
- XML, etc. could be covered by `spotless`, I guess, but we don't really have a problem there at the moment.

## pubsub emulator

- https://cloud.google.com/pubsub/docs/emulator
- https://stackoverflow.com/questions/51290024/spring-boot-cloud-gcp-cannot-connect-to-local-google-pubsub-emulator
- https://stackoverflow.com/questions/54988955/how-to-connect-spring-gcp-pubsubtemplate-to-local-instance
- `gcloud beta emulators pubsub start --project=PUBSUB_PROJECT_ID [options]` where `PUBSUB_PROJECT_ID` can be any
  syntactically valid id.

## Oddities

- spring integration http inbound gateway issues
  - has trouble serializing empty map, throwing '*' not allowed for Content-Type
  - trying to restrict via request-mapping produces=application/json does not work
  - trying to set response header does not work
  - trying to set view as jsonView does not work
  - adding Accept: application/json works
  - changing response value to simple type works

## TODO

[] sdkman env for java version
[] skaffold?
[] docker image?
[] spring javaformat checkstyle? needs IDE plugin too.
