pipeline {
    agent any

    stages {
        stage('stage1') {
            steps {
                sh "cat /etc/passwd"
            }
        }
        stage('stage2') {
            steps {
                sh "uname -a"
            }
        }
    }
}