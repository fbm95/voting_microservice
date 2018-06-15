FROM java:8
VOLUME /tmp
COPY app-voting.jar app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://172.17.8.101:27017/votingapp","-jar","/app.jar"]
EXPOSE 1221

# docker build -f Dockerfile -t voting_img .
# docker run -d --name results -p 1221:1221 voting_img
