def call(buildResult) {
  switch(buildResultt) {
    case "SUCCESS":
      slackSend color: "good",
                message: "${env.JOB_NAME} build ${env.BUILD_NUMBER} was successful!  Hurrah!!"
      break

    case "FAILURE":
      slackSend color: "danger",
                message: "${env.JOB_NAME} build ${env.BUILD_NUMBER} failed.  Who broke the build?!"
      break

    case "UNSTABLE":
      slackSend color: "warning",
                message: "${env.JOB_NAME} build ${env.BUILD_NUMBER} appears to be unstable.  Someone should investigate."
      break
    default:
      slackSend color: "danger",
                message: "${env.JOB_NAME} build ${env.BUILD_NUMBER} returned an unexpected result.  See the logs to find out more."
  }
}