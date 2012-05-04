Spring Social Twitter Grails Plugin
================================

Getting Started
-------------------------

### You can install this plugin in one of two ways:

1) You can install the plugin by running the install-plugin command.

	grails install-plugin spring-social-twitter

2) You can add, compile ":spring-social-twitter:0.1.31", to your BuildConfig.groovy file in the conf directory. Note: You may have to change the version value to match this plugin's current version.

	plugins {
        compile ":spring-social-twitter:0.1.31"
    }

### Add your Twitter public key and secret to the Config.groovy file in the conf directory.

    grails.plugins.springsocial.twitter.consumerKey='twitterconsumerkey'
    grails.plugins.springsocial.twitter.consumerSecret='twittersecret'