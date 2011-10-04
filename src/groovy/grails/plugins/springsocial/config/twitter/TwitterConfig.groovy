/* Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grails.plugins.springsocial.config.twitter

import javax.inject.Inject

import org.springframework.social.connect.ConnectionFactoryLocator
import org.springframework.social.connect.ConnectionRepository
import org.springframework.social.connect.support.ConnectionFactoryRegistry
import org.springframework.social.connect.ConnectionFactory

import grails.plugins.springsocial.twitter.SpringSocialTwitterUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.social.twitter.api.Twitter
import org.springframework.social.twitter.api.impl.TwitterTemplate
import org.springframework.social.twitter.connect.TwitterConnectionFactory
import org.springframework.util.Assert

@Configuration
class TwitterConfig {
  @Inject
  ConnectionRepository connectionRepository

  @Bean
  ConnectionFactory twitterConnectionFactory() {
    println "Configuring SpringSocial Twitter"
    def twitterConfig = SpringSocialTwitterUtils.config.twitter
    def consumerKey = twitterConfig.consumerKey
    def consumerSecret = twitterConfig.consumerSecret
    Assert.hasText(consumerKey, "The Twitter consumerKey is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.twitter.consumerKey='yourConsumerKey'")
    Assert.hasText(consumerSecret, "The Twitter consumerSecret is necessary, please add to the Config.groovy as follows: grails.plugins.springsocial.twitter.consumerSecret='yourConsumerSecret'")
    new TwitterConnectionFactory(consumerKey, consumerSecret)
  }

  @Bean
  @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
  Twitter twitter() {
    def twitter = connectionRepository.findPrimaryConnection(Twitter)
    twitter != null ? twitter.getApi() : new TwitterTemplate()
  }
}
