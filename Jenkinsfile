pipeline {

    environment {
        REGISTRY_CREDENTIALS = 'dockerhub'
        REGISTRY_LINK = 'https://hub.docker.com'
        REGISTRY_NAME = 'registry/';
        TARGET_IMAGE_NAME = 'order'
    }

    agent none

    stages {
        stage('TESTS') {
            agent {
                docker { image "openjdk:latest" }
            }
            steps {
                //Mettre ici l'ordre de build genre npm build.
                //TODO METTRE ICI Le lancement des tests (npm test par exemple)
                echo "build & tests"
            }
        }
        stage('DOCKER-BUILD') {
            agent any
            steps {
                script {
                    dockerImage = docker.build('' + REGISTRY_NAME + TARGET_IMAGE_NAME)
                }
            }
        }
        stage('DOCKER-PUSH') {
            agent any
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
