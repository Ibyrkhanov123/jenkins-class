pipeline{
    agent any

    environment {
        VAR1 = "building"
        VAR2 = "testing"
    }

    stages {
        stage('Build') {
            steps {
                echo "VAR1 value is ${VAR1}"
            }
        }
        stage('test') {
            steps {
                echo "VAR2 value is ${VAR2}"
            }
        }
    }
}