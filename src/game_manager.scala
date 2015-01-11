object game_manager {
	import countries._, globalVar._;
	class gm() { //game_manager
		var Month = 1;
		var Year = 1985;
		var past_dates: List[String] = List( "1/1985" );
		/* ^ Update by:
		 * past_dates = past_dates :+ (Month.toString + "/" + Year.toString);
		 */

		def nextTurn() = {
			this.Month += 1;
			if ( this.Month > 12 ) {
				this.Month = 1; this.Year += 1;
			};
			this.past_dates = this.past_dates :+ ( this.Month.toString + "/" + this.Year.toString );
		};

		private def DefconCheck( cntry: country ) = {
			if ( cntry.Defcon > 5 ) {
				cntry.Defcon = 5;
			};
			else if ( cntry.Defcon < 1 ) {
				cntry.Defcon = 1;
			};

			if ( cntry.Defcon == 5 ) {
				cntry.update_max_nukes( 0 );
			};
			else if ( cntry.Defcon == 4 ) {
				cntry.update_max_nukes( 15 );
			};
			else if ( cntry.Defcon == 3 ) {
				cntry.update_max_nukes( 50 );
			};
			else if ( cntry.Defcon == 2 ) {
				cntry.update_max_nukes( 300 );
			};
			else if ( cntry.Defcon == 1 ) {
				cntry.update_max_nukes( 2000 );
			}
		};

		def exec_scripted_events() = {
			import scripted_events._;
			scripted_events( this, player );
		};

		def exec_player_events() = {
			import player_events._;
			player_events( this );
		};
		//destroy probably won't be used.
		def destroy( cntry: country ) = {
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nukes = 0;
			cntry.Nicks = null;
		};

		/*	DEPRECATED
		def destroy(cntry:non_nuke_country) =	{
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nicks = null;
		};
		*/

		//Starts current turn and waits for input commands then promptly calls the correct method based on input.
		def start_turn() = {
			DefconCheck( player );
			if (this.Month == 1 && this.Year == 1985)	{ echo( "Press enter to start your turn." ); };
			else	{ echo( "Press enter to start the next turn" ); };
			readLine();
			echo( "Turn started. Input commands. (use 'help' for a list of commands.)" );
			var repeat = true;
			var can_nuke = true;
			while ( repeat ) {
				var r = readLine().toLowerCase;
				if ( r.startsWith( "help" ) ) { //prints commands available for use to the player.
					if ( r == "help" )	{
						echo( """Options:
	nuke
	end
	help
	help 'command'
	terminate""" );	//This is ugly but whatever.
					};
					else	{
						try	{
							var args = r.split(' ');
							if (args(1) == "nuke")	{ echo( "Allows the user to choose a hostile state to nuke." ); }
							else if (args(1) == "end")	{ echo( "Ends the current turn and starts the next month." ); }
							else if (args(1) == "help")	{ echo( "Shows command options." ); }
							else if (args(1) == "terminate")	{ echo( "Terminates the simulation." ); }
						} catch	{
							case e:Exception => echo("Invalid command.");
						}
					}
				}
				else if ( r == "nuke" && can_nuke ) {
					if ( enemy_states.nonEmpty && player.Defcon != 5 ) {
						can_nuke = false;
						this.choose_target();
					}
					else if ( player.Defcon == 5 ) {
						echo( "You cannot attack any states at this time due your defcon level of 5" );
					}
					else {
						echo( "You cannot attack any states at this time." );
					}
				}
				else if ( r == "end" ) {
					echo( "Turn ended." );
					repeat = false;
				}
				else if ( r == "terminate" )	{
					echo( "Simulation terminated." );
					while (true)	{};
				}
				else {
					echo( r + " is an unrecognized command." );
				}
			}
			//end turn
		};

		private def choose_target() = {
			var can_attack = false;
			if ( enemy_states.nonEmpty ) {
				echo( "You are at war with these countries: " + this.printList_nuclear( enemy_states ) );
				can_attack = true;
			};
			/*	DEPRECATED
			if (enemy_states_non_nuke.nonEmpty)	{
				echo("You are at war with these non nuclear countries: " + this.printList_non_nuke(enemy_states_non_nuke));
				can_attack = true;
			};
			*/
			if ( can_attack ) {
				echo( "Who would you like to attack of these states?\nPressing enter with no input will result in no nuclear exchange." );
				var repeat = true;
				while ( repeat ) {
					repeat = false;
					var r = readLine().toLowerCase;
					if ( r != "" ) {
						echo( "No nuclear weapons exchanged currently." );
						repeat = false;
					}
					else {
						var found_target = false;
						for ( i <- 0 to enemy_states.length - 1 ) { //Checks for nuclear targets and attacks them.
							if ( enemy_states( i ).Nicks.contains( r ) ) {
								found_target = true;
								this.enter_combat( enemy_states( i ) );
							}
						};
						if ( !found_target ) { //If we still haven't found a target we display a message and loop again.
							echo( r + " is not a nation you are at war with. Please try again." );
							repeat = true;
						}
					}
				}
			}
		};

		//These enter_combat methods are very wasteful with repeated code but because of the way I've set up  my country/non_nuke_country divide it has to be written like this.
		//I need to come back later and devise a better way of handling the two different types of enemies.
		def enter_combat( enemy: country ) = {
			echo( s"How many nukes would you like to launch?\nYou may launch a maximum number of " + player.max_nukes + " nuclear weapons.\nYou currently have " + player.Nukes + " nuclear weapons." );
			var repeat = true;
			while ( repeat ) {
				try {
					var r = readInt();
					if ( r > player.max_nukes ) {
						echo( s"$r is greater than the maximum number of nuclear weapons you can launch. (" + player.max_nukes + ")" );
						repeat = true;
					}
					else if ( r > player.Nukes ) {
						echo( s"$r is greater than the current number of nuclear weapons you have: " + player.Nukes );
						repeat = true;
					}
					else {
						repeat = false;
						this.attack( enemy, r );
					};

				}
				catch {
					case e: Exception => echo( "Invalid input. Please retry." ); repeat = true;
				}
			};
		};

		def attack( arg: country, nukes: Int ) = {

		};

		final private def printList_nuclear( arg: List[country] ) = {
			for ( i <- 0 to arg.length - 1 ) {
				if ( i != arg.length - 1 ) {
					print( arg( i ).Name + ", " );
				}
				else {
					print( "and " + arg( i ).Name + "." );
				}
			}
		};

		//This is sort of redundant if I'm going down the path of only being able to target those that you are at 'war' with. Should be changed.
		def check_untargetable_states( enemy: String ): Boolean = {
			for ( i <- 0 to untargetable_states.length - 1 ) {
				if ( untargetable_states( i ).Name == enemy ) { return false; }
			}
			return true;
		};
		//when checking: if valid not true then retry;

		/*	DEPRECATED
		def convert_non_nuclear_state_to_nuclear(non_nuclear_state:non_nuke_country, nukes:Int):country =	{
			return new country(non_nuclear_state.Name, non_nuclear_state.Pop , nukes);
		};
		*/
	}
};