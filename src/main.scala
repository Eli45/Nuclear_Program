object main	{
	import classes._, game_manager._, countries._, globalVar._;
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
		} while (retry);
		println("You chose to play as: " + player.Name);
	};
	//Put the below inside the attack country function(to be added later.)
	def check_untargetable_states(enemy:String):Boolean =	{
		var valid = false;
		for (i <- 0 to untargetable_states.length - 1)	{
			if (untargetable_states(i).Name == enemy)	{ valid = true; }
		}
		return valid;
	};
	
	//^ Move these to functions.
	
	def main(args: Array[String]) =	{
		var gm = new gm();
		pickNation();
		while (player.Pop > 0)	{
			gm.exec_player_events();
			gm.exec_scripted_events();
			/*
			 * Choose target.
			 * Combat between target and player.
			 */
			gm.nextTurn();
		}
	}
}