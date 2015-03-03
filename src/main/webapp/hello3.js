function displayLoggedInUser()
{
	 $('.greeting-content3').append( $.session.get('user'));
}