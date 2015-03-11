function displayLoggedInUser()
{
	 $('.login-content').append( $.session.get('user'));
}