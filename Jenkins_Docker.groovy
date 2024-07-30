pipeline {
    agent any 

    environment {
        GIT_BRANCH='master'
        GIT_ID= 'ID_2_git'
        GIT_URL= 'https://github.com/vickyvg11/maven-web-app.git'
    }

    options {
        disableConcurrentBuilds()
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '3'))
    }
    stages {
            stage ('Git Checkout') {
        steps {
                git branch:"${GIT_BRANCH}",
                credentialsId: "${GIT_ID}",
                url:"${GIT_URL}"
                
            }

            stage('Build app') {
            agent {
                docker {
                    image 'maven:latest'
                    args '-v maven_web_app:/app'
                }
            }
            steps {
                sh 'mvn clean package'
            }
      }  
    }
}
}