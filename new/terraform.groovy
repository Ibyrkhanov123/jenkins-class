pipeline{

    agent any
    parameters {
        string(name: 'ACTION', description: 'Terraform Apply or Destroy' , defaultValue: 'terraform apply -auto-approve', trim: true)
    }
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
                sh $params.ACTION
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
