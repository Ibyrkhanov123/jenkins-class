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
                dir("app-infra") {
                    echo "Running Tf-init"
                    sh "terraform init"
                }
            }
        }
        stage('tf-validate') {
            steps {
                dir("app-infra") {
                    echo "running Tf-Validate"
                    sh "terraform validate"
                }
            }
        }
        stage('tf-plan') {
            steps {
                dir("app-infra") {
                    echo "running Tf-plan"
                    sh "terraform plan"
                }
            }
        }
        stage('tf-apply') {
            steps {
                dir("app-infra") {
                    echo "running Tf-apply"
                    sh "terraform apply --auto-approve"
                }
            }
        }
    }
}