job('ejemplo2-job-DSL') {
	description('Job Dsl de ejemplo para el curso de Jenkins')
    scm {
      git('https://github.com/macloujulian/jenkins.job.parametrizado.git', 'main') { node ->
        node / gitConfigName('daniel')
        node / gitConfigEmail('danieldelgado_2106@hotmail.com')
      }
    }
    parameters {
    	stringParam('nombre', defaultValue = 'Daniel', decription = 'Parametro de cadena para el Job Booleano')
      	choiceParam('planeta', ['Tierra', 'Marte', 'Saturno'])
      	booleanParam('agente', false)
    }
    triggers {
     	cron('H/7 * * * *')
    }
  	steps {
      	shell("bash jobscript.sh")
  	}
}
