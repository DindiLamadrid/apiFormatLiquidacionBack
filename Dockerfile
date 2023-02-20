#FROM eclipse-temurin:17-jdk
#VOLUME /tmp
#EXPOSE 8082
#RUN mkdir -p /app/
#RUN mkdir -p /app/logs/
#COPY build/libs/apiFormatLiquidacionBack-1.0.0.jar apiFormatLiquidacionBack-1.0.0.jar
#ENTRYPOINT ["java","-jar","/apiFormatLiquidacionBack-1.0.0.jar"]
#
#
