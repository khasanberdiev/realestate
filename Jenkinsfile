pipeline{
    agent none
    stages{
        stage('Build'){
            agent{docker, 'maven:3-alpine'}
            steps{
                echo 'hello maven'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Run'){
            agent {docker 'openjdk:17-jre'}
            steps {
                echo 'hello jdk'
                sh 'java -jar /realestate.jar'
            }
        }
    }
}


// node {

//    stage('Clone Repository') {
//         // Get some code from a GitHub repository
//         git 'https://github.com/khasanberdiev/realestate.git'
    
//    }
//    stage('Build Maven Image') {
//         docker.build("maven-build")
//    }
   
//    stage('Run Maven Container') {
       
//         //Remove maven-build-container if it exists
//         sh " docker rm -f maven-build-container"
        
//         //Run maven image
//         sh "docker run --rm --name maven-build-container maven-build"
//    }
   
//    stage('Deploy Spring Boot Application') {
        
//          //Remove maven-build-container if it exists
//         sh " docker rm -f java-deploy-container"
       
//         sh "docker run --name java-deploy-container --volumes-from maven-build-container -d -p 8080:8080 denisdbell/petclinic-deploy"
//    }

// }