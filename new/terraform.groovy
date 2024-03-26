pipeline{

    agent any

    stages{
        stage('terraform init') {
            steps{
                sh 'terraform -v'
                sh 'terraform init'
            }
        }

        stage('terraform validate') {
            steps{
                sh 'terraform validate'
            }
        }
        stage('terraform plan') {
            steps{
                sh 'terraform plan'
            }
        }
        stage('terraform apply') {
            steps{
                sh 'terraform apply -auto-approve'
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
        cleanup {
            cleanWs()
            dir("${workspace_tmp}"){
                deleteDir()
            }
        }
    }
}
