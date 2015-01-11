object functions {
	import globalVar._, countries._;

	def pickNation() = {
		var retry = false;
		echo( "Input nuclear power desired to simulate," );
		do {
			retry = false;
			echo( "Choices include: United States, United Kingdom, France, China, Soviet Union." );
			var r = readLine().toLowerCase;
			if ( usa.Nicks.contains( r ) ) { player = usa; untargetable_states = List( usa ); } //Alter this to include NATO / Warsaw pact.
			else if ( sov.Nicks.contains( r ) ) { player = sov; untargetable_states = List( sov ); }
			else if ( fra.Nicks.contains( r ) ) { player = fra; untargetable_states = List( fra ); }
			else if ( bri.Nicks.contains( r ) ) { player = bri; untargetable_states = List( bri ); }
			else if ( chi.Nicks.contains( r ) ) { player = chi; untargetable_states = List( chi ); }
			else {
				retry = true;
				echo( "Invalid choice. Retry." );
			}
		} while ( retry );
		echo( "Now simulating: " + player.Name );
	};

	/* --- Statistics functions --- */
	def stats_start() = {
		echo( "Type in a command to view statistics and other information. (Type 'help' to see a list of commands)" )
		var repeat = true;
		while ( repeat ) {
			var r = readLine().toLowerCase;
			if ( r == "help" ) {
				echo( "'help': Displays this menu." )
				echo( "'population': Displays statistics on the world populations." )
				echo( "'nukes': Displays statistics on nukes fired and casualties." )
				echo( "'timeline': Displays events occured in game." )
				echo( "'replay': Re-sets all game statistics, restarts the game, and allows you to pick a new country." )
				echo( "'terminate': Terminates the program." )
			}
			else if ( r == "population" ) {

			}
			else if ( r == "nukes" ) {

			}
			else if ( r == "timeline" ) {

			}
			else if ( r == "replay" ) {

			}
			else if ( r == "terminate" ) {
				repeat = false;
				echo( "Simulation terminated" );
			}
			else {
				echo( r + " is not a valid command. Please try again." );
			}
		}
	}
};