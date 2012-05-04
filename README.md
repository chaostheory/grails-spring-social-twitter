Spring Social Twitter Grails Plugin
================================

Getting Started
-------------------------

### Installation

You can install this plugin in one of two ways:

1) Install the plugin by running the install-plugin command.

	grails install-plugin spring-social-twitter

OR

2) Add *compile ":spring-social-twitter:0.1.31"* to your BuildConfig.groovy file's *plugins* bloc in the conf directory. _You probably have to change the version value to match this plugin's current version._

	plugins {
        compile ":spring-social-twitter:0.1.31"
    }

### Configuration

Add your Twitter public key and secret to the Config.groovy file in the conf directory.

    grails.plugins.springsocial.twitter.consumerKey='twitterconsumerkey'
    grails.plugins.springsocial.twitter.consumerSecret='twittersecret'