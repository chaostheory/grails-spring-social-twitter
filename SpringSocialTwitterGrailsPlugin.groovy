class SpringSocialTwitterGrailsPlugin {
  // the plugin version
  String version = "0.1.16"
  // the version or versions of Grails the plugin is designed for
  String grailsVersion = "1.3.0 > *"
  // the other plugins this plugin depends on
  Map dependsOn = ['springSocialCore': '0.1.16 > *']
  // resources that are excluded from plugin packaging
  List pluginExcludes = [
      "grails-app/views/error.gsp"
  ]

  String author = "Domingo Suarez Torres"
  String authorEmail = "domingo.suarez@gmail.com"
  String title = "Spring Social Twitter"
  String description = 'Spring Social Twitter plugin.'

  // URL to the plugin's documentation
  String documentation = "http://grails.org/plugin/spring-social-twitter"

  def doWithWebDescriptor = { xml ->
    // TODO Implement additions to web.xml (optional), this event occurs before
  }

  def doWithSpring = {
    // TODO Implement runtime spring config (optional)
    xmlns context: "http://www.springframework.org/schema/context"
    context.'component-scan'('base-package': "grails.plugins.springsocial.config.twitter")
  }

}
