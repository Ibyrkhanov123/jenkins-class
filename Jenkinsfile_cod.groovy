pipeline {
    agent any
    parameters {
        choice(name: 'branch', description: 'Select a branch name', choices: ['dev', 'main'])
    }
    stages {
        stage('stage1') {
            steps {
                echo "${params.git_branch}"
            }
        }
        stage('stage2') {
            steps {
                echo "${params.git_branch}"
            }
        }
    }
}