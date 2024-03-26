pipeline{
    agent any

    environment {
        VAR1 = "building"
    }

    stages {
        stage('Build') {
            steps {
                echo "VAR1 value is ${VAR1}"
            }
        }
    }
}