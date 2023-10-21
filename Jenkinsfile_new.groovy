pipeline {
    agent any
    stages {
        stage('tf-version') {
            steps {
                echo "Running Tf-Version"
                sh "terraform -v"

            }
        }
        stage('tf-init') {
            steps {
                echo "Running Tf-init"
                sh "terraform init"
            }
        }
    }
}