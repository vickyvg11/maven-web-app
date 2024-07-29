pipeline {
    agent any 

    environment {
        GIT_BRANCH='master'
        GIT_ID= 'ID_2_git'
        GIT_URL= 'https://github.com/vickyvg11/maven-web-app.git'
    }

    stages {
        stage ('CheckOut the code') {
            steps {
                git branch:"${GIT_BRANCH}",
                credentialsId: "${GIT_ID}",
                url:"${GIT_URL}"
            }
        }

      stage ('Build app') {
        steps {
            sh 'ls -lrt'
        }
      }  
      
    }
}