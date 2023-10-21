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
        stage('stage3') {
            steps {
                sh "pwd"
                sh "whoami"
            }
        }
        stage('terraform version'){
            steps {
                sh "terraform -v"
            }
        }
    }
}