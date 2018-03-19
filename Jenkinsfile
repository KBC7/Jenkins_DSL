
node {
   def commit_id
   stage('Preperation') {
     checkout scm
     sh "git rev-parse --short HEAD > .git/commit-id"
     commit-id= readFile('.git/commit-id').trim()
   }
   stage('test') {
     def myTestContainer = docker.image('node:4.6')
     myTestContainer.pull()
     myTestContainer.inside {
       sh 'npm install --only=dev'
       sh 'npm test'
     }
   }
   stage('test with a db') {
     def mysql = docker.image('mysql').run("-e MYSQL_ALLOW_EMPTY_PASSWORD=yes")
     def myTestContainer = docker.image('node:4.6')
     myTestContainer.pull()
     myTestContainer.inside("--link ${mysql.id}:mysql") {
          sh 'npm install --only=dev'
          sh 'npm test'  
     }
     mysql.stop()
   }
}
   
