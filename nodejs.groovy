job('Nodejs Example')
  scm {
      git('git://github.com/wardviaene/docker-demo.git')
      }
  }
  triggers {
      scm('H/5 * * * *')
  }
  wrappers {
      nodejs('nodejs') // Manage jenkins->Configure tool->NodeJS INstallation -->name
  }
  steps {
      shell('npm install')
  }
