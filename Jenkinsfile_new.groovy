pipeline {
    agent any
    stages {
        stage('tf-version') {
            steps {
                echo "Running Tf-Version"
                sh "terraform -v"

            }
        }
    }
}