object functions {
	import globalVar._, countries._;

	def pickNation():country = {
		var retry = false;
		var ply:country = null;
		echo( "Input nuclear power desired to simulate," );
		do {
			retry = false;
			echo( "Choices include: [1]United States, [2]United Kingdom, [3]France, [4]China, [5]Soviet Union." );
			var r = readLine().toLowerCase;
			if 		( usa.Nicks.contains( r ) || r == "1") { ply = usa; untargetable_states = List( usa ); } //Alter this to include NATO / Warsaw pact.
			else if ( bri.Nicks.contains( r ) || r == "2") { ply = bri; untargetable_states = List( bri ); }
			else if ( fra.Nicks.contains( r ) || r == "3") { ply = fra; untargetable_states = List( fra ); }
			else if ( chi.Nicks.contains( r ) || r == "4") { ply = chi; untargetable_states = List( chi ); }
			else if ( sov.Nicks.contains( r ) || r == "5") { ply = sov; untargetable_states = List( sov ); }
			else {
				retry = true;
				echo( "Invalid choice. Retry." );
			}
		} while ( retry );
		echo( "Now simulating: " + ply.Name );
		
		return ply;
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