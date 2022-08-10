timestamps {
    node {
        stage('Checkout') {
            checkout scm
        }

        if (BRANCH_NAME == 'local') {
            stage('Build') {
                jobDsl(removedJobAction: 'DELETE', removedViewAction: 'DELETE', sandbox: true
                targets: 'jobs/**/*.groovy', unstableOnDeprecation: true)
            }
        }
    }
}
