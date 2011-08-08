<html>
<head>
    <title>Connect to Twitter</title>
    <meta name='layout' content='springSocialMain'/>
</head>

<body>

<h3>Connect to Facebook</h3>

<g:form mapping="springSocialConnect" params="[providerId: 'facebook']" method="POST">
	<input type="hidden" name="scope" value="publish_stream,offline_access" />
	<div class="formInfo">
		<p>You aren't connected to Facebook yet. Click the button to connect Spring Social Showcase with your Facebook account.</p>
	</div>
	<p><button type="submit"><img src="${createLinkTo(dir: 'images/springsocial/facebook', file: 'connect_light_medium_short.gif')}"/></button></p>
	%{--<label for="postToWall"><input id="postToWall" type="checkbox" name="postToWall" /> Tell your friends about Spring Social Showcase on your Facebook wall</label>--}%
</g:form>

</body>
</html>
