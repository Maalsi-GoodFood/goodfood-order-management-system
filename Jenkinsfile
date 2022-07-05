pipeline {

    environment {
        TARGET_IMAGE_NAME = 'order'
        REGISTRY = "dockerhub"
        REGISTRY_LINK = 'https://hub.docker.com/'
    }

    agent none

    stages {
        stage('TESTS') {
            agent {
                docker { image "openjdk:latest" }
            }
            steps {
                //Mettre ici l'ordre de build genre npm build.
            }
            steps {
                //TODO METTRE ICI Le lancement des tests (npm test par exemple)
            }
        }
        stage('DOCKER-BUILD') {
            agent any
            steps {
                script {
                    dockerImage = docker.build(TARGET_IMAGE_NAME)
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
