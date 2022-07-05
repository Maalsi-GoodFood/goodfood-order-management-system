pipeline {

    environment {
        TARGET_IMAGE_NAME = 'order'
        REGISTRY = "dockerhub"
        BUILD_ENV_IMAGE = "openjdk:latest"
        REGISTRY_LINK = 'https://hub.docker.com/'
    }

    agent {
        docker { image BUILD_ENV_IMAGE }
    }
    stages {
        stage('DOCKER-BUILD') {
            steps {
                script {
                    dockerImage = docker.build(TARGET_IMAGE_NAME)
                }
            }
        }
        stage('DOCKER-PUSH') {
            steps {
                script {
                    docker.withCredentials(''+REGISTRY_LINK, ''+REGISTRY);
                    docker.push(''+${BUILD_NUMBER})
                    docker.push('latest');
                }
            }
        }
    }
}
