FROM java:8
VOLUME /tmp
ADD chef-challenge-service-0.0.1.jar chef-challenge-service-0.0.1.jar
RUN bash -c 'touch /chef-challenge-service-0.0.1.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/chef-challenge-service-0.0.1.jar"]