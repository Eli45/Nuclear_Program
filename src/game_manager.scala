object game_manager	{
	import countries._, globalVar._;
	class gm()	{	//game_manager
		var Defcon = 5; //Lowest level of readiness. Possibly move to specific country basis.
		var Month = 1;
		var Year = 1985;
		var past_dates:List[String] = List("1/1985");
		private var max_nukes = 0;
		/* ^ Update by:
		 * past_dates = past_dates :+ (Month.toString + "/" + Year.toString);
		 */

		def nextTurn() =	{
			this.Month += 1;
			if (this.Month > 12)	{
			  this.Month = 1; this.Year += 1;
			};
			this.past_dates = this.past_dates :+ (this.Month.toString + "/" + this.Year.toString);
		};
		
		private def DefconCheck() =	{
		  if (this.Defcon > 5)	{
		    this.Defcon = 5;
		  };
		  else if (this.Defcon < 1)	{
		    this.Defcon = 1;
		  };
		  
		  if (this.Defcon == 5)	{
		    this.max_nukes = 0;
		  };
		  else if (this.Defcon == 4)	{
		    this.max_nukes = 15;
		  };
		  else if (this.Defcon == 3)	{
		    this.max_nukes = 50;
		  };
		  else if (this.Defcon == 2)	{
		    this.max_nukes = 300;
		  };
		  else if (this.Defcon == 1)	{
		    this.max_nukes == 2000;
		  }
		};

		def exec_scripted_events() =	{
			import scripted_events._;
			scripted_events(this, player);
		};

		def exec_player_events() =	{
			import player_events._;
			player_events(this);
		};
		//destroy probably won't be used.
		def destroy(cntry:country) =	{
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nukes = 0;
			cntry.Nicks = null;
		};
		def destroy(cntry:non_nuke_country) =	{
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nicks = null;
		};

		//GM Controlled turn input options etc:
		//Put the below inside the attack country function(to be added later.)
		def start_turn() =	{
			this.DefconCheck();
			println("Press enter to start your turn.");
			readLine();
			println("Turn started. Input commands. (use 'help' for a list of commands.)");
			var repeat = true;
			while (repeat)	{
				var r = readLine().toLowerCase;
				if (r == "help")	{	//prints commands available for use to the player.
					println("To Add Later");
				}
				else if (r == "nuke")	{
					if (enemy_states_nuclear.nonEmpty || enemy_states_non_nuke.nonEmpty && this.Defcon != 5)	{
						this.choose_target();
					}
					else if (this.Defcon == 5)	{
						println("You cannot attack any states at this time due your defcon level of 5");
					}
					else	{
						println("You cannot attack any states at this time.");
					}
				}
				else if (r == "end")	{
					println("Turn ended.");
					repeat = false;
				}
				else	{
					println(r + " is an unrecognized command.");
				}
			}
			//end turn
		};

		def choose_target() =	{
			var can_attack = false;
			if (enemy_states_nuclear.nonEmpty)	{
				println("You are at war with these nuclear countries: " + this.printList_nuclear(enemy_states_nuclear));
				can_attack = true;
			}
			if (enemy_states_non_nuke.nonEmpty)	{
				println("You are at war with these non nuclear countries: " + this.printList_non_nuke(enemy_states_non_nuke));
				can_attack = true;
			};
			if (can_attack)	{
				println("Who would you like to attack of these states?\nPressing enter with no input will result in no nuclear exchange.");
				var repeat = true;
				while (repeat)	{
					repeat = false;	
					var r = readLine().toLowerCase;
					if (r != "")	{
						println("No nuclear weapons exchanged currently.");
						repeat = false;
					}
					else	{
					  var found_target = false;
					  for (i <- 0 to enemy_states_nuclear.length - 1)	{	//Checks for nuclear targets and attacks them.
					    if (enemy_states_nuclear(i).Nicks.contains(r))	{
					      found_target = true;
					      this.enter_combat(enemy_states_nuclear(i));
					    }
					  };
					  if (!found_target)	{
						  for (i <- 0 to enemy_states_non_nuke.length - 1)	{	//Checks for non_nuclear targets and attacks them
						    if (enemy_states_non_nuke(i).Nicks.contains(r))	{
						      found_target = true;
						      this.enter_combat(enemy_states_non_nuke(i));
						    }
						  }
					  };
					  if (!found_target)	{	//If we still haven't found a target we display a message and loop again.
					    println(r + " is not a nation you are at war with. Please try again.");
					    repeat = true;
					  }
					}
				}
			}
		};
		
		//These enter_combat methods are very wasteful with repeated code but because of the way I've set up  my country/non_nuke_country divide it has to be written like this.
		//I need to come back later and devise a better way of handling the two different types of enemies.
		def enter_combat(enemy: country) =	{
		  println(s"How many nukes would you like to launch?\nYou may launch a maximum number of $max_nukes nuclear weapons.\nYou currently have " + player.Nukes + " nuclear weapons.");
		  var repeat = true;
		  	  while (repeat)	{
			  try	{
				  var r = readInt();
				  if (r > max_nukes)	{
					  println(s"$r is greater than the maximum number of nuclear weapons you can launch. ($max_nukes)");
					  repeat = true;
				  }
				  else if (r > player.Nukes)	{
					  println(s"$r is greater than the current number of nuclear weapons you have: " + player.Nukes);
					  repeat = true;
				  }
				  else	{
					  repeat = false;
					   this.attack(enemy, r);
				  };
				 
			  }
			  catch	{
			  	  case e:Exception => println("Invalid input. Please retry."); repeat = true;
			  }
			};
		};
		
		def enter_combat(enemy: non_nuke_country) =	{
		  println(s"How many nukes would you like to launch?\nYou may launch a maximum number of $max_nukes nuclear weapons.\nYou currently have " + player.Nukes + " nuclear weapons.");
		  var repeat = true;
		  	  while (repeat)	{
			  try	{
				  var r = readInt();
				  if (r > max_nukes)	{
					  println(s"$r is greater than the maximum number of nuclear weapons you can launch. ($max_nukes)");
					  repeat = true;
				  }
				  else if (r > player.Nukes)	{
					  println(s"$r is greater than the current number of nuclear weapons you have: " + player.Nukes);
					  repeat = true;
				  }
				  else	{
					  repeat = false;
					   this.attack(enemy, r);
				  };
				 
			  }
			  catch	{
			  	  case e:Exception => println("Invalid input. Please retry."); repeat = true;
			  }
			};
		};
		//As I said, very wasteful. MUST REVISE.
		
		def attack(arg:country, nukes:Int) =	{
		  
		};
		def attack(arg:non_nuke_country, nukes:Int) =	{
		  
		};

		final private def printList_nuclear(arg: List[country]) =	{
			for (i <- 0 to arg.length - 1)	{
				if (i != arg.length - 1)	{
					print(arg(i).Name + ", ");
				}
				else	{
					print("and " + arg(i).Name + ".");
				}
			}
		};
		final private def printList_non_nuke(arg: List[non_nuke_country]) =	{
			for (i <- 0 to arg.length - 1)	{
				if (i != arg.length - 1)	{
					print(arg(i).Name + ", ");
				}
				else	{
					print("and " + arg(i).Name + ".");
				}
			}
		};

		def check_untargetable_states(enemy:String):Boolean =	{
			var valid = true;
			for (i <- 0 to untargetable_states.length - 1)	{
				if (untargetable_states(i).Name == enemy)	{ valid = false; }
			}
			return valid;
		};

		//when checking: if valid not true then retry;
		def convert_non_nuclear_state_to_nuclear(non_nuclear_state:non_nuke_country, nukes:Int):country =	{
			return new country(non_nuclear_state.Name, non_nuclear_state.Pop , nukes);
		};
	}
};
