ARG VERSION_JDK="22_36"
ARG VERSION_SBT="1.10.0"
ARG VERSION_SCALA="3.4.2"
ARG VARIANT="eclipse-temurin-jammy-${VERSION_JDK}_${VERSION_SBT}_${VERSION_SCALA}"
FROM sbtscala/scala-sbt:${VARIANT}

# Install apps
RUN wget -qO- https://packages.lunarg.com/lunarg-signing-key-pub.asc | tee /etc/apt/trusted.gpg.d/lunarg.asc
RUN wget -qO /etc/apt/sources.list.d/lunarg-vulkan-jammy.list http://packages.lunarg.com/vulkan/lunarg-vulkan-jammy.list
RUN apt update
RUN apt install -y vulkan-sdk

# Build workspace
ARG workspace
WORKDIR "${workspace}"

# Set environment
RUN git config --system commit.template "${workspace}/.gitmessage"
