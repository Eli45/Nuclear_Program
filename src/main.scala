object main	{
	import classes._, countries._, publicVar._
	//Move these to functions
	def pickNation() =	{
		var retry = false;
		do	{
			retry = false;
			println("What nuclear powered nation would you like to play as?\nChoices include: United States, United Kingdom, France, China, Soviet Union.");
			var r = readLine().toLowerCase;
			if (usa.Nicks.contains(r))		{ player = usa; untargetable_states = List(usa); }
			else if (sov.Nicks.contains(r))	{ player = sov; untargetable_states = List(sov); }
			else if (fra.Nicks.contains(r))	{ player = fra; untargetable_states = List(fra); }
			else if (bri.Nicks.contains(r))	{ player = bri; untargetable_states = List(bri); }
			else if (chi.Nicks.contains(r))	{ player = chi; untargetable_states = List(chi); }
			else	{
				retry = true;
				println("Invalid choice. Try again");
			}
		} while (retry)
		println("You chose to play as: " + player.Name);
	}
	//^ Move these to functions.
	
	def main(args: Array[String]) =	{
		pickNation();
		
	}
}