pipeline {
    agent any
    tools {
        maven 'maven3.8.6'
        jdk 'java11'
   }
    stages {
        stage('Clean workspace') {
            steps {
                script {
                    deleteDir()
                }
            }
        }
        stage('Checkout') {
            steps {
                script {
                checkout([$class: 'GitSCM',
                            branches: [[name: '*/main']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions: [
                            [$class: 'SparseCheckoutPaths', sparseCheckoutPaths:[[$class:'SparseCheckoutPath', path:'Java-App/']]],
                            ],
                            submoduleCfg: [],
                            userRemoteConfigs: [[credentialsId: 'github-pat',
                            url: 'https://github.com/Usmanasim11/AR-final-demo.git']]])
                }
            }
        }
// *** comment the below stage when using without Docker  ***
        // stage('Build and Run') {
        //     steps {
        //       // sh 'mvn -version'
        //         dir ('Java-App') {
        //             sh 'mvn clean install'
        //             sh 'mvn clean package'
        //             //sh 'mvn spring-boot:run'
        //         }
        //     }
        // }
        // stage('Publishing Junit Tests report ') {
        //     steps {
        //         junit 'Java-App/target/surefire-reports/*.xml'
        //     }   
        // }
        // stage('Publishing Code Coverage') {
        //     steps {
        //         dir ('Java-App') {
        //             jacoco()}
        //     }   
        // }  
        // stage('Deploy') {
        //     steps {
        //         dir ('Java-App') {
        //             sh 'sh ./jenkins/scripts/deliver.sh' }
        //     }
        // }
        
// *** Uncomment the below stage when using Docker  ***
         stage('Deploy with Docker Compose') {
             steps {
                script {
                    // Bring down the previous deployment
                    sh "docker-compose -f Java-App/docker-compose.yml down -v"

                    // Update the docker-compose.yml file with the new image tag
                    def buildNumber = env.BUILD_NUMBER 

                    sh "sed -i 's/image: Java-App:.*/image: Java-App:${buildNumber}/' Java-App/docker-compose.yml"
                    // Bring up the latest deployment
                    sh "docker-compose -f Java-App/docker-compose.yml up -d"
                }
            }
        }
    }
}