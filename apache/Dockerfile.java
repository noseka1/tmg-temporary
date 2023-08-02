FROM registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift:1.15 AS build

COPY HelloWorld.java HelloWorld.java
RUN javac HelloWorld.java

FROM registry.access.redhat.com/ubi8/openjdk-8-runtime:1.16

COPY --from=build /home/jboss/HelloWorld.class /home/jboss/HelloWorld.class

CMD java HelloWorld
