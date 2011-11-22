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
package grails.plugins.springsocial.twitter

import org.springframework.social.twitter.api.Twitter

class SpringSocialTwitterController {

    def twitter
    def connectionRepository

    def beforeInterceptor = [action: this.&auth, except: 'login']

    def index = {
        def model = ["profile": twitter.userOperations().getUserProfile()]
        render(view: "/springsocial/twitter/index", model: model)
    }

    def timeline = {
        def id = params.id ?: "home"
        def tweets
        switch (id) {
            case "home":
                tweets = twitter.timelineOperations().getHomeTimeline()
                break
            case "user":
                tweets = twitter.timelineOperations().getUserTimeline()
                break
            case "public":
                tweets = twitter.timelineOperations().getPublicTimeline()
                break
            case "mentions":
                tweets = twitter.timelineOperations().getMentions()
                break
            case "favorites":
                tweets = twitter.timelineOperations().getFavorites()
                break
            default:
                tweets = twitter.timelineOperations().getHomeTimeline()
                break
        }

        render view: SpringSocialTwitterUtils.config.twitter.page.timeLine, model: ['timeline': tweets]

    }

    def profiles = {
        def id = params.id ?: "friends"
        def profiles
        switch (id) {
            case "friends":
                profiles = twitter.friendOperations().getFriends()
                break
            case "followers":
                profiles = twitter.friendOperations().getFollowers()
                break
            default:
                profiles = twitter.friendOperations().getFriends()
                break
        }
        render view: SpringSocialTwitterUtils.config.twitter.page.profiles, model: ['profiles': profiles]
    }

    def messages = {
        def dmListType = params.id ?: 'received'
        def directMessages
        switch (dmListType) {
            case 'received':
                directMessages = twitter.directMessageOperations().getDirectMessagesReceived()
                break
            case 'sent':
                directMessages = twitter.directMessageOperations().getDirectMessagesSent()
                break
            default:
                directMessages = twitter.directMessageOperations().getDirectMessagesReceived()
                break
        }
        render view: SpringSocialTwitterUtils.config.twitter.page.directMessages, model: ['directMessages': directMessages, 'dmListType': dmListType]
    }

    def trends = {
        def trends = twitter.searchOperations().getCurrentTrends()
        render view: SpringSocialTwitterUtils.config.twitter.page.trends, model: ['trends': trends]
    }

    def tweet = {
        def message = params.message
        twitter.timelineOperations().updateStatus(message)
        redirect(action: timeline, params: [id: 'user'])
    }

    def search = {
        def query = params.query
        def tweets = twitter.searchOperations().search(query).getTweets()
        flash.message = "Search result for '${query}'"
        render view: SpringSocialTwitterUtils.config.twitter.page.timeLine, model: ['timeline': tweets]
    }

    def login = {
        render(view: SpringSocialTwitterUtils.config.twitter.page.connect)
    }

    def auth() {
        if (!isConnected()) {
            redirect(action: 'login')
            return false
        }
    }

    Boolean isConnected() {
        connectionRepository.findPrimaryConnection(Twitter)
    }

}
