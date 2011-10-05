class SpringSocialTwitterGrailsPlugin {
  // the plugin version
  def version = "0.1.14"
  // the version or versions of Grails the plugin is designed for
  def grailsVersion = "1.3.0 > *"
  // the other plugins this plugin depends on
  Map dependsOn = ['springSocialCore': '0.1.14 > *']
  // resources that are excluded from plugin packaging
  def pluginExcludes = [
      "grails-app/views/error.gsp"
  ]

  def author = "Domingo Suarez Torres"
  def authorEmail = "domingo.suarez@gmail.com"
  def title = "Spring Social Twitter"
  def description = '''\\
Spring Social Twitter plugin.
'''


  // URL to the plugin's documentation
  def documentation = "http://grails.org/plugin/spring-social-twitter"

  def doWithWebDescriptor = { xml ->
    // TODO Implement additions to web.xml (optional), this event occurs before
  }

  def doWithSpring = {
    // TODO Implement runtime spring config (optional)
    xmlns context: "http://www.springframework.org/schema/context"
    context.'component-scan'('base-package': "grails.plugins.springsocial.config.twitter")
  }

}
