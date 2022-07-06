pipeline {

    environment {
        REGISTRY_CREDENTIALS = 'dockerhub'
        REGISTRY_LINK = 'https://hub.docker.com'
        USERNAME = 'cesigoodfood';
        REGISTRY_NAME = 'registry'
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
                    dockerImage = docker.build('' + USERNAME + '/' + REGISTRY_NAME)
                }
            }
        }
        stage('DOCKER-PUSH') {
            agent any
            steps {
                script {
                    docker.withRegistry('', ''+REGISTRY_CREDENTIALS) {
                        dockerImage.push(''+BUILD_NUMBER)
                        dockerImage.push('latest')
                    })

                }
            }
        }    
        stage('Remove Unused docker image') {
            agent any
            steps{
                sh "docker rmi $USERNAME/$REGISTRY_NAME:$BUILD_NUMBER"
            }
        }
    }
}
