pipeline {
    agent any
    environment {
        Var1 = 'Value1'
    }
    stages {
        stage('build') {
            steps {
                echo "Var1 value is ${Var1}"
            }
        }
    }
}