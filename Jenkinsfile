pipeline {

    environment {
        TARGET_IMAGE_NAME = 'order'
        REGISTRY = "dockerhub"
        REGISTRY_LINK = 'https://hub.docker.com/'
    }

    agent any

    stages {
        stage('DOCKER-BUILD') {
            steps {
                script {
                    dockerImage = docker.build("${TARGET_IMAGE_NAME}")
                }
            }
        }
        stage('DOCKER-PUSH') {
            steps {
                script {
                    docker.withCredentials(''+REGISTRY_LINK, ''+REGISTRY);
                    dockerImage.push(''+${BUILD_NUMBER})
                    dockerImage.push('latest');
                }
            }
        }
    }
}
