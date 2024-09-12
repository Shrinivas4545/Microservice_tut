# Creating image

1. Give jar name in pom.xml inside build
    - <finalName>spring-boot-docker</finalName>
    - Ex. 
        <build>
        <plugins>
            <plugin>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-maven-plugin</artifactId>
                </plugin>
            </plugins>
        <finalName>spring-boot-docker</finalName>
        </build>

2. Create **Dockerfile** in project
3. 
    - FROM openjdk:11
    - EXPOSE 8080
    - ADD target/spring-boot-docker.jar spring-boot-docker.jar 
    - ENTRYPOINT ["java", "jar", "/spring-boot-docker.jar"]
4. Run as => Maven Install
    - .jar files will be created at target folder
5. Open windows powershell and go to folder where want create image
6. docker build -t spring-boot-docker .
    - to create image 
7. docker images
    - check if docker img is created
8. docker run -p 9090:8080 spring-boot-docker
    - run the image

## To delete all local Docker images, you can follow these steps:

1. Stop all running containers (since you cannot delete images if containers are running from them):
bash
Copy code
docker stop $(docker ps -aq)
2. Delete all containers:
bash
Copy code
docker rm $(docker ps -aq)
3. Delete all images:
You can delete all images with the following command:

- bash
- Copy code
- docker rmi $(docker images -q)
- Explanation:
docker ps -aq: Lists the IDs of all containers (both running and stopped).
docker stop and docker rm: Stop and remove all containers.
docker images -q: Lists the IDs of all images.
docker rmi: Removes the images based on their IDs.
4. Force delete images (optional):
If some images are in use and you encounter errors, you can force-remove them with:

bash
Copy code
docker rmi -f $(docker images -q)
This command forces the deletion of all images, even if they are in use by stopped containers.

5. Clean up dangling images and unused data:
You can also run this command to remove dangling images and other unused Docker resources:

bash
Copy code
docker system prune -a
This command will:

Remove all stopped containers.
Remove all unused images.
Remove all unused networks and build caches.
