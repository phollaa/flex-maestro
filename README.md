# FlexMaestro service

FlexMaestro readme generated using Twilio
[dropwizard4-archetype] (https://code.hq.twilio.com/twilio/twilio-shared-poms/tree/master/twilio-dropwizard-service-pom/dropwizard4-archetype).**.

The `dropwizard4-archetype` introduces a number of new features over the previous service template used by Paved Path, including:


- Introduction of Java EE9 APIs based on the jakarta namespace
- Java 17 required
- Migration from Dropwizard 1.x/2.x to Dropwizard 4.x
- Easier developer experience -- run the service from IDE, command-line, or container.
- Automatic source formatting to the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html) for nit-free pull requests.

**Update this README with actual service documentation and remove this boilerplate!**

## Getting Started

Find the YAML file in the server module's `src/main/resources/openapi`
directory, and edit it to describe the API your service will provide.

## Running locally

Use the local.env file to set up local environment variables.
These variables are referred directly by docker-compose

### Docker

---
**_NOTE:_**  In order to build your service completely locally you need to have Docker installed locally. In order to
build your service using Buildkite you need `buildkite-maven-build` to be of version `v1.14` or newer.
---

In the integration test module there are tests that will test that the docker image can be built and that
it behaves nominally. The scaffolding test is `ContainerIT`.  The behavior is that if running locally (on your laptop)
it will access the running service on the `localhost` interface.

If the build is running in Buildkite (maven inside a docker container), the test will have to connect through the
bridge network's gateway interface and a `gateway.file` property is set to map the gateway address.

If you just want to build and start the container from your command prompt (inside the repository root):

```bash
$ mvn clean package
$ docker compose up --build --wait --remove-orphans
```

Or you can use the script which is part of the integration test suite, it requires `Dockerfile` & `docker-compose.yml`
to be in parent directory of the helper script.

```bash
$ ./service-ctl.sh --help
Service managment script
Usage:
  ./service-ctl.sh <-b|--build> <-g|--detect-gateway [gateway file]> <-s|--start [gateway file]> <-t|--teardown [gateway file]> <-h|--help>
  -b or --build builds the service image
  -g or --detect-gateway checks the gateway ip [gateway file location]
  -s or --start starts the service [gateway file location]
  -t or --teardown tears down the service [gateway file location]
  -h or --help prints the usage

```

So for example to start the service
```bash
$ ./service-ctl.sh --build --start docker-gateway.txt
```
To run the tests against the container

```bash
$ mvn verify
```

To stop the container
```bash
$./service-ctl.sh --teardown docker-gateway.txt
```


### IntelliJ IDEA

The latest IntelliJ IDEA edition is recommended. You can request a download of the IntelliJ Ultimate Edition from
ServiceNow if you're currently using the community edition.

Install the following plugins for IntelliJ from its Marketplace:

- `google-java-format`: automatic source formatter. You will be prompted to enable it on a per-project basis.
- `Save Actions`: _(optional)_ if you want to invoke automatic source formatting on save. Note that source formatting is already invoked automatically as part of the build.

Import ordering is not handled by the `google-java-plugin`, unfortunately. If you want to fix the order of imports in
source files, download the [IntelliJ Java Google Style](https://raw.githubusercontent.com/google/styleguide/gh-pages/intellij-java-google-style.xml)
file and import it into File → Settings → Editor → Code Style.

* Download [EnvFile](https://github.com/Ashald/EnvFile) from IntelliJ plugin marketplace.
* Follow usage to add local.env file to the environment variables
* Program Arguments: `server conf/service.yaml`

## JVM Settings

### GC Settings

### Diagnostics Settings
