pipeline {
    agent any
    parameters {
        string(name: 'git_branch', description: 'Enter a branch name', defaultValue: 'dev')
    }
    stages {
        stage('stage1') {
            steps {
                echo "${git_branch}"
            }
        }
        stage('stage2') {
            steps {
                echo "${git_branch}"
            }
        }
    }
}