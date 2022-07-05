pipeline {

    environment {
        TARGET_IMAGE_NAME = 'order'
        REGISTRY = "dockerhub"
        BUILD_ENV_IMAGE = "openjdk:latest"
        REGISTRY_LINK = 'https://hub.docker.com/'
    }

    agent {
        docker { image "${BUILD_ENV_IMAGE}" }
    }
    stages {
        stage('DOCKER-BUILD') {
            steps {
                script {
                    dockerImage = docker.build(env.TARGET_IMAGE_NAME)
                }
            }
        }
        stage('DOCKER-PUSH') {
            steps {
                script {
                    docker.withCredentials(''+env.REGISTRY_LINK, ''+env.REGISTRY);
                    dockerImage.push(''+${env.BUILD_NUMBER})
                    dockerImage.push('latest');
                }
            }
        }
    }
}
