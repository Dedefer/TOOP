FROM openjdk:8

RUN echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list
RUN curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add
RUN apt-get update
RUN apt-get install sbt

WORKDIR /src

# this just to speed up image assembly
COPY project /src/project

RUN cd /src && sbt exit

COPY . /src

RUN sbt 'project toopHTTP4S' assembly

CMD java -jar toop-http4s/target/scala-*/toop-http4s-assembly-*.jar $PORT
