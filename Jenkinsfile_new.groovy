pipeline {
    agent any
    parameters {
        booleanParam(name: 'APPLY_DESTROY', defaultValue: true, description: 'Select whether to apply or destroy')
    }
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
                    echo "Running Tf-Validate"
                    sh "terraform validate"
                }
            }
        }
        stage('tf-plan') {
            steps {
                dir("app-infra") {
                    echo "Running Tf-plan"
                    sh "terraform plan"
                }
            }
        }
        stage('tf-apply') {
            steps {
                dir("app-infra") {
                    echo "Running Tf-apply/destroy"
                    if (params.APPLY_DESTROY) {
                        sh "terraform apply --auto-approve"
                    } else {
                        sh "terraform destroy --auto-approve"
                    }
                }
            }
        }
    }
    post {
        success {
            echo "The pipeline ran successfully"
        }
        failure {
            echo "The pipeline failed :("
        }
        always {
            cleanWs()
        }
    }
}
