pipeline {
    agent any
    stages {
        stage('stage1') {
            steps {
                echo "Running Stage1"
            }
        }
        stage('stage2') {
            steps {
                echo "Running Stage2"
            }
        }
    }
}