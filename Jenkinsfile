timestamps {
    node {
        stage('Checkout') {
            checkout scm
        }

        if (BRANCH_NAME == 'local') {
            stage('Build') {
                jobDsl(additionalClasspath: 'src/main/groovy', removedJobAction: 'DELETE', removedViewAction: 'DELETE',
                targets: 'jobs/**/*.groovy', unstableOnDeprecation: true)
            }
        }
    }
}
