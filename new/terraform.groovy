pipeline{

    agent any
    parameters {
        choice(name: 'CHOICE', description: 'Terraform Apply or Destroy' , choices: ['apply', 'destroy'])
    }
    options{
            buildDiscarder(logRotator(numToKeepStr: '4'))
    }       timeout(time: 20, unit: 'MINUTES')
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
                input(message: 'Type "yes" to approve deployment')
                sh "terraform ${params.CHOICE} -auto-approve"
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
