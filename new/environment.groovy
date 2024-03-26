pipeline{
    agent any

    environment {
        VAR1 = "building"
        VAR2 = "testing"
        AWS_ACCESS_KEY = credentials('aws-access-key')
    }

    stages {
        stage('Build') {
            steps {
                echo "VAR1 value is ${VAR1}"
                echo "AWS access key is ${AWS_ACCESS_KEY}"
            }
        }
        stage('test') {
            steps {
                echo "VAR2 value is ${VAR2}"
            }
        }
    }
}