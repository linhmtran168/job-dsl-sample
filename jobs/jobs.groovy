folderName = 'myjobs'

folder(folderName) {
    description('My Jobs')
}

job = freeStyleJob("$folderName/test-job")
job.with {
    description('<em style="color: red;">GENERATED JOB - MANUAL CHANGES WILL BE OVERWRITTEN</em>')
    wrappers {
        colorizeOutput()
    }
}

job.with {
    logRotator {
        numToKeep(30)
    }
}

job.with {
    steps {
        shell 'echo test linh dep trai'
    }
}

job.with {
    publishers {
        slackNotifier {
            room('Dev Team A')
            notifyAborted(true)
            notifyFailure(true)
            notifyNotBuilt(true)
            notifyUnstable(true)
            notifyBackToNormal(true)
            notifySuccess(false)
            notifyRepeatedFailure(false)
            startNotification(false)
            includeTestSummary(false)
            includeCustomMessage(false)
            commitInfoChoice('NONE')
            tokenCredentialId('slack-token')
        }
    }
}
