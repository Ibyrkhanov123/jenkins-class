pipeline {
    agent any
    environment {
        Var1 = 'Value1'
        Var2 = 'Value2'

    }
    stages {
        stage('build') {
            steps {
                echo "Var1 value is ${Var1}"
            }
        }
        stage('test') {
            steps {
                echo "Var2 value is ${Var2}"
            }
        }
        stage('variables') {
            steps {
                echo "${BUILD_ID}"
                echo "${JOB_NAME}"
            }
        }
    }
}