pipeline { 
    agent any 
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
                    // Start the SSH agent 
                    sshagent(credentials: ['c78c0348-18f0-4d31-ae84-4467c1180f2a']) { 
                        // Manually add the host key to known hosts
                        sh 'ssh-keyscan github.com >> ~/.ssh/known_hosts' 
                        // Run your Git commands here 
                        sh 'git clone git@github.com:rehmanjaffar/javaApp.git' 
                    } 
                } 
            } 
        }
        stage('test') {
            steps {
                script {
                    def jdk11 = tool name: 'JDK11', type: 'hudson.model.JDK'
                    env.JAVA_HOME = "${jdk11}"
                    
                    echo "JAVA_HOME: ${env.JAVA_HOME}" // Print JAVA_HOME for debugging
                    
                    // Build the Maven application
                    dir('javaApp') {
                        // Build the Maven application
                        sh 'mvn clean'
                        sh 'mvn package'
                        sh 'java -cp target/jb-hello-world-maven-0.2.0.jar hello.HelloWorld'
                    }
                }
            }
        }
    } 
}
