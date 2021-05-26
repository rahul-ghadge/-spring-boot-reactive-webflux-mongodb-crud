#spring-boot-reactive-webflux-mongodb-crud


> docker --version

> docker pull mongo


`docker run <image-name>` creates and runs a container using the specified image name  
`docker ps` lists all the containers currently up/running in local docker  
`docker ps -a` lists all the containers, also the ones stopped  
`docker stop <container-name>` stops the specified container with name
`docker stop <container-id>` stops the specified container with id (first unique chars will work)  
`docker rm <container-name>` stops and removes the specified container with name  
`docker rm <container-id>` stops and removes the specified container with id  


> docker run -d  --name mongo-on-docker  -p 27107:27017 -e MONGO_INITDB_ROOT_USERNAME=mongo -e MONGO_INITDB_ROOT_PASSWORD=mypassword

Above command will mongo image on port **27017** port with username as **mongo** and password as **mypassword**
--name is optional   
**-d** for detach mode to run in background  
**-p** to expose port outside the container  
**-e** for passing properties outside from container


