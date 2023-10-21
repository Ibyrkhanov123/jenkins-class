pipeline {
    agent any
    stages {
        stage('stage1') {
            steps {
                echo "Running Stage1"
                sh "pwd"
                sh "whoami"
            }
        }
    }
}