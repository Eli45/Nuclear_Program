//Look at EvenMoreTests.scala
//See Test.scala for diceroll concept
object Variables {
		var n = BigInt("0")
		var nukes = BigInt("0")
		var e_nukes = BigInt("0")
		var rus_nukes = BigInt("39197")
		var us_nukes = BigInt("23368")
		var uk_nukes = BigInt("422")
		var fra_nukes = BigInt("360")
		var chi_nukes = BigInt("243")
		var ruspop = BigInt("277700000")
		var uspop = BigInt("237000000")
		var frapop = BigInt("56830000")
		var ukpop = BigInt("56550000")
		var chipop = BigInt("1051000000")
		var plypop = BigInt("0")
		var e_pop = BigInt("0")
		var nukepop = ruspop + uspop + frapop + ukpop + chipop + plypop
		var vaguepop = BigInt("4840000000")
		var vaguepopend = BigInt("4840000000") - ruspop - uspop - frapop - ukpop - chipop - plypop	//3160920000
		var total_deaths = BigInt("0")
		var ply_deaths = BigInt("0")
		var nukesFired = BigInt("0")
		var ply_casualties = BigInt("0")
		var nukepopend = BigInt("0")
		var world_deaths = BigInt("0")
		var last_plypop = BigInt("0")
		
		var month = 1
		var year = 1985
		var defcon = 0
		var maxNuke = 0
		var army = 0
		var e_army = 0
		
		var plyrus = false
		var plyusa = false
		var plyfra = false
		var plyuk = false
		var plychi = false
		var tooMany = false
		var badName = false
		var cont = false
		var self_nuke = false
		var noNuke = false
		var game = true
		var tooBigDeath = false
		var ChinaSupport = false
		var AskedChina = false
		var stop = false
		var loss = false
		var four_1985 = false
		var five_1985 = false
		var six_1985 = false
		var noEvents = true
		
		var enemy = ""
		var ply = ""
		var deathMonth = ""
		var deathYear = ""
		var nuke_state = Array("Russia","Soviet Union","United States","US","USA","France","United Kingdom","UK","Britain","China","USSR")
		//^Above could be done better with a hashMap but I'm not going to be bothered to convert it.^
		var nickNames = Map("a" -> "a")
 
		val df = new java.text.DecimalFormat(",###")
		val playableNations = Map("ussr" -> "The Soviet Union",
		"soviet union" -> "The Soviet Union",
		"russia" -> "The Soviet Union",
		"the soviet union" -> "The Soviet Union",
		"united kingdom" -> "The United Kingdom", 
		"britain" -> "The United Kingdom",
		"england" -> "The United Kingdom",
		"the united kingdom" -> "The United Kingdom", 
		"the united states of america" -> "The United States of America",
		"united states of america" -> "The United States of America",
		"the united states" -> "The United States of America",
		"america" -> "The United States of America",	
		"usa"-> "The United States of America",
		"france" -> "France",
		"china" -> "China")
}

object NuclearProgram extends App {
			//Stuff over here is optional to add and simply makes it better.
	  //Stuff here must be fixed for functionality.
	  
			//Add different pop deaths for more densely pact countries.
			//Add dicerolls for how much the enemy responds to your attack.
				//Add percent of nuked nations population that dies each day from irradiation.
	  //Try to optimize reset function. (not even implemented as of right now. Make it.)
			//DICEROLLS	WORKING ON IT. STILL NEED MORE.
			//Add more deaths for more powerful nation's nukes.
				//Add more in-depth stats.
	  //Add a line that also makes it so you can't nuke your allies.
				//ADD MORE COUNTRIES ESPECIALLY ALL OF NATO AND WARSAW PACT.
			//Work on console formatting of println's.
	  //More scripted events.
	  //Check enemy casualties when they have 0 nukes or their population is 0. It is wrong if their population was already hurt. Implement solution similar to last_plypop?

  
	//Ask about this. And if it is a possible way of making a reset function thing possible.
	import Variables._	//Doesn't work as is. See "MoreTests.scala" for possible way to make it. Doesn't work yet though.
	
	def nations = 	{
		do	{
			var r = readLine();
			r = r.toLowerCase()
			if (playableNations.contains(r))	{
				ply = playableNations.apply(r)
			}
			if (ply == "The Soviet Union")	{
				badName = false
				nukes = 39197
				plypop = 277700000
				ruspop = 0
				plyrus = true
				nickNames += ("ussr" -> "The Soviet Union",
					  	"soviet union" -> "The Soviet Union", 
					  	"russia" -> "The Soviet Union", 
					  	"the soviet union" -> "The Soviet Union")
			}
			else if (ply == "The United States of America")	{
				badName = false
				nukes = 23368
				plypop = 237000000
				uspop = 0
				plyusa = true
				nickNames += ("the united states of america" -> "The United States of America",
						"united states of america" -> "The United States of America",
						"america" -> "The United States of America",	
						"usa"-> "The United States of America")
			}
			else if (ply == "France")	{
				badName = false
				nukes = 360	  
				plypop = 56830000
				frapop = 0
				plyfra = true
				nickNames += ("france" -> "France")
			}
			else if (ply == "The United Kingdom")	{
				badName = false
				nukes = 422	  
				plypop = 56550000
				ukpop = 0
				plyuk = true
				nickNames += ("united kingdom" -> "The United Kingdom", 
						"britain" -> "The United Kingdom",
						"england" -> "The United Kingdom",
						"the united kingdom" -> "The United Kingdom")
			}
			else if (ply == "China")	{
				badName = false			  
				nukes = 243
				plypop = 1051000000
				chipop = 0
				plychi = true
				nickNames += ("china" -> "China")
			}
			else	{
				badName = true
				println(r + " is not a nuclear state. Try again.")
			}
	} while (badName == true)
	println("You chose to play as: " +ply)
	}
	
	def who_to_nuke =	{
		println("Press enter to start your turn.")
		readLine();
		if (defcon == 0)	{
			println("You do not have permission to launch any nuclear devices at defcon level 0.")	
			noNuke = true
		}
		else if (nukes == 0)	{
			println("No more nuclear weapons in stockpile. Press enter to continue.")
			noNuke = true
		}
		else	{
			do	{
				println("You may launch "+maxNuke+" nuclear weapons at defcon level "+defcon)
				println("Who do you want to nuke? (Press enter without inputting any characters to launch no nukes.)")
				enemy = readLine();
				enemy = enemy.toLowerCase
				if (nickNames.contains(enemy))	{
					println("You cannot nuke yourself. Try again.")
					self_nuke = true
				}
				else	{self_nuke = false}
				} while (self_nuke == true)
				if (enemy.equalsIgnoreCase("nobody") || enemy.equalsIgnoreCase("wait") || enemy.equalsIgnoreCase(""))	{
					noNuke = true
					tooMany = false
				}
				else if (enemy.equalsIgnoreCase("end"))	{noNuke = true; tooMany = false;stop = true}
				else	{
					tooMany = true
					noNuke = false
				}
		}
		while (tooMany == true)	{
			println("You have " +df.format(nukes)+ " nuclear weapons.")
			println("How many nukes do you wish to launch?")
			n = readInt();
			enough_nukes;
		}
		if (noNuke == false)	{
			nukes = nukes - n
			nukesFired += n
			println(ply + " attacked " + enemy.capitalize+ " with " + df.format(n) + " nuclear weapons.")
		}
	}
	
	def enough_nukes =	{
	  if (n > maxNuke)	{
		  println("You do not have permission to launch "+n+" nuclear weapons at defcon level "+defcon)
		  tooMany = true
	  }
	  else if (n > nukes)	{
		  println("You don't have that many nukes! Try again.")
		  tooMany = true
	  }
	  else	{
		  tooMany = false
	  }
	}
	
	var r_e = false
	var u_e = false
	var f_e = false
	var b_e = false
	var c_e = false
	def nuked =	{
		if (enemy.equalsIgnoreCase(nuke_state(0)) || enemy.equalsIgnoreCase(nuke_state(1)) || enemy.equalsIgnoreCase(nuke_state(10)))	{ //rus
			e_nukes = rus_nukes
			r_e = true;u_e = false;f_e = false;b_e = false;c_e = false;noNuke = false
			enemy = "The Soviet Union"

		}
		else if (enemy.equalsIgnoreCase(nuke_state(2)) || enemy.equalsIgnoreCase(nuke_state(3)) || enemy.equalsIgnoreCase(nuke_state(4)))	{ //usa
			e_nukes = us_nukes
			r_e = false;u_e = true;f_e = false;b_e = false;c_e = false;noNuke = false
			enemy = "The United States of America"
		}
		else if (enemy.equalsIgnoreCase(nuke_state(5)))	{ //fra
			e_nukes = fra_nukes
			r_e = false;u_e = false;f_e = true;b_e = false;c_e = false;noNuke = false
			enemy = "France"
		}
		else if (enemy.equalsIgnoreCase(nuke_state(6)) || enemy.equalsIgnoreCase(nuke_state(7)) || enemy.equalsIgnoreCase(nuke_state(8)))	{	//uk
			e_nukes = uk_nukes
			r_e = false;u_e = false;f_e = false;b_e = true;c_e = false;noNuke = false
			enemy = "The United Kingdom"
		}
		else if (enemy.equalsIgnoreCase(nuke_state(9)))	{	//chi
			e_nukes = chi_nukes
			r_e = false;u_e = false;f_e = false;b_e = false;c_e = true;noNuke = false
			enemy = "China"
		}
		else	{
		  r_e = false;u_e = false;f_e = false;b_e = false;c_e = false;noNuke = false
		}
	}
	def death_calc(casualties_per_nuke:Int,ply_nukes_greater_e_nukes:Boolean) =	{	//IMPLEMENT THIS 
		if (ply_nukes_greater_e_nukes == true)	{	//Used for n > e_nukes
		  nukesFired += e_nukes
		  ply_deaths = e_nukes * casualties_per_nuke
		  total_deaths = n * casualties_per_nuke
		  plypop -= ply_deaths
		}
		else	{
		  total_deaths = n * casualties_per_nuke
		  nukesFired += n
		  e_nukes -= n
		  ply_deaths = total_deaths
		  plypop -= ply_deaths
		}
	}

	def response =	{
	  last_plypop = plypop
	  if (r_e == true || u_e == true || f_e == true || b_e == true || c_e == true)	{
		  if (e_nukes == 0)	{
			  println(enemy.capitalize + " has depleted their nuclear stockpile and cannot retaliate.")
			  ply_deaths = 0
		  }
		  else if (n >= e_nukes)	{
			  println(enemy.capitalize + " has responded with " + df.format(e_nukes) + " nuclear attacks.")
			  println()
			  death_calc(150000,true)
			  if (r_e == true)	{rus_nukes = 0}
			  else if (u_e == true)	{us_nukes = 0}
			  else if (f_e == true)	{fra_nukes = 0}
			  else if (b_e == true)	{uk_nukes = 0}
			  else if (c_e == true)	{chi_nukes = 0}
			  
		  }
		  else	{
			  println(enemy.capitalize + " has responded with " + df.format(n) + " nuclear attacks.")
			  println()
			  death_calc(150000,false)
			  if (r_e == true)	{rus_nukes = e_nukes}
			  else if (u_e == true)	{us_nukes = e_nukes}
			  else if (f_e == true)	{fra_nukes = e_nukes}
			  else if (b_e == true)	{uk_nukes = e_nukes}
			  else if (c_e == true)	{chi_nukes = e_nukes}
		  }
	  }
	  else	{
		  println(enemy.capitalize + " has no nuclear weapons and thus cannot retaliate!")
		  println()
		  ply_deaths = 0
		  total_deaths = n * 150000
		  vaguepopend -= total_deaths
	  }
	}
	
	def deaths = 	{
		if (r_e == true)	{ //rus
			ruspop -= total_deaths
			if (ruspop < 0)	{total_deaths = 277700000; ruspop = 0}	//This doesn't work if their population was damaged before their death. Look into it.
			else if (n > 28633)	{total_deaths = 277700000; ruspop = 0}
			e_pop = ruspop
			println("Soviet population: " + df.format(ruspop) + " Enemy casualties: " + df.format(total_deaths))
		}
		else if (u_e == true)	{ //usa
			uspop -= total_deaths
			if (uspop < 0)	{total_deaths = 237000000; uspop = 0}
			else if (n > 28633)	{total_deaths = 237000000; uspop = 0}
			e_pop = uspop
			println("American population: " + df.format(uspop) + " Enemy casualties: " + df.format(total_deaths))
		}
		else if (f_e == true)	{ //fra
			frapop -= total_deaths
			if (frapop < 0)	{total_deaths = 56830000; frapop = 0}
			else if (n > 28633)	{total_deaths = 56830000; frapop = 0}
			e_pop = frapop
			println("French population: " + df.format(frapop) + " Enemy casualties: " + df.format(total_deaths))
		}
		else if (b_e == true)	{	//uk
			ukpop -= total_deaths
			if (ukpop < 0)	{total_deaths = 56550000; ukpop = 0}
			else if (n > 28633)	{total_deaths = 56550000; ukpop = 0}
			e_pop = ukpop
			println("United Kingdom population: " + df.format(ukpop) + " Enemy casualties: " + df.format(total_deaths))
		}
		else if (c_e == true)	{	//chi
			chipop -= total_deaths
			if (chipop < 0)	{total_deaths = 1051000000; chipop = 0}	
			else if (n > 28633)	{total_deaths = 1051000000; chipop = 0}
			e_pop = chipop
			println("Chinese population: " + df.format(chipop) + " Enemy casualties: " + df.format(total_deaths))
		}
		else	{
			println("Enemy population and casualties could not be determined.")
			println("Theoretical casualties are up to " + df.format(total_deaths))
		}
		if (e_pop <= 0 && e_nukes > 0)	{
			println(enemy.capitalize +" has launched their remaining nuclear weapons ("+df.format(e_nukes)+") at you.")
			nukesFired += e_nukes
			ply_deaths = e_nukes * 150000
			plypop -= ply_deaths
			if (r_e == true)	{rus_nukes = 0}
			else if (u_e == true)	{us_nukes = 0}
			else if (f_e == true)	{fra_nukes = 0}
			else if (b_e == true)	{uk_nukes = 0}
			else if (c_e == true)	{chi_nukes = 0}
		}
		if (plypop > 0) {println("Your population: " + df.format(plypop) + " Your casualties: " + df.format(ply_deaths))}
	}
	
	def cont_nuke =	{
		if (plypop <= 0)	{
			plypop = 0
		  	ply_deaths = last_plypop
			println()
			deathMonth = month.toString
			deathYear = year.toString
			loss = true
			println("You will be assuredly wiped out by the incoming nuclear attack.")
			println("Would you like to launch your remaining nuclear weapons into the world at random? Y/N.")
			var r = readLine();
			if (r.equalsIgnoreCase("Y"))	{
			  var vaguedeaths = nukes * 150000;vaguepopend -= vaguedeaths
			  nukesFired += nukes
			  if (vaguedeaths > BigInt("4840000000") || vaguepopend <= 0)	{vaguepopend = 0; vaguedeaths = BigInt("4840000000")}
			  else if (vaguedeaths > (vaguepopend + chipop + frapop + ukpop + uspop + ruspop))	{
				  vaguepopend = 0
			  }
			  println("Inflicted casualties: "+df.format(vaguedeaths))
			}
			else	{
			  println("No nuclear weapons released.")
			}
			println("Your population: "+df.format(plypop) +" Your casualties: "+df.format(ply_deaths))
			println("Press enter to continue");readLine()
			cont = false
			game = false
		}
		else	{
			println("Press enter to continue.")
			println("-----------------------")
			var r = readLine();
			if (r == "end")	{cont = false;stop = true}
			else if (stop == true)	{cont = false}
			else	{cont = true;}
		}
	}
	def monthcheck =	{
		if (month > 12)	{
		  month = 1
		  year += 1
		}
		else	{}
	}
	def event_notice(msg1:String,msg2:String,msg3:String) =	{
		if	(msg1 == "")	{}
		else	{println(msg1)}
		if	(msg2 == "")	{}
		else	{println(msg2)}
		if	(msg3 == "")	{}
		else	{println(msg3)}
		println()
	}
	def nukesToDoubleThenInt(x:Double) =	{
		var newnukes = nukes
		var nukesnukes = newnukes.toDouble
		newnukes = Math.round(nukesnukes * x)
		var newnukesTwo = newnukes.toInt
		nukes = newnukesTwo
	}
	def maxNukeCheck(x:Int,y:String) =	{
		if	(y == "-")	{defcon -= x}
		else if (y == "+")	{defcon += x}
		if (defcon == 0)	{
			maxNuke = 0
		}
		else if (defcon == 1)	{
			maxNuke = 5
		}
		else if (defcon == 2)	{
			maxNuke = 20
		}
		else if (defcon == 3)	{
			maxNuke = 100
		}
		else if (defcon == 4)	{
			maxNuke = 500
		}
		else if (defcon == 5)	{
			maxNuke = 50000
		}
		else if (defcon > 5)	{
			defcon = 5
			maxNuke = 50000
		}
		println("Defcon changed to: "+defcon)
		println("Permission for "+df.format(maxNuke)+" nuclear strikes activated.")
		//println() Work on this formatting.
	}
	def scripted_events =	{
		if (month == 2 && year == 1985)	{
			noEvents = false
			var ran = Math.round(Math.random()*10)
			if (ply == "China" && ran >= 5)	{	//Strengthening
				nukes += 50
				event_notice("Chinese nuclear production has recieved a small funding increase.","Your nuclear stockpile has increased by 50 and is now: "+nukes,"")
			}
			else if (ply == "The United States of America" && ran < 5)	{	//Weakening
				nukesToDoubleThenInt(.85)
				event_notice("Bureaucrats slash nuclear funding by 15%","Your new nuclear stockpile is: " +df.format(nukes),"")
			}
			else if (ply == "The United States of America" && ran >= 5)	{	//Strengthening
				nukesToDoubleThenInt(1.15)
				event_notice("Bureaucrats vote for strengthening of nuclear arms by 15%","Your new nuclear stockpile is: "+df.format(nukes),"");
			}
			else if (ply == "The Soviet Union")	{
				event_notice("Soviet command passes to you that they intend to invade West Germany on 1/4/1985.","","")
			}
			println("The Soviet army engages in skirmishes on the German border. Tensions escalate.")
		}
		else if (month == 3 && year == 1985)	{
			noEvents = false
			var ran = Math.round(Math.random()*10)
			if (ply == "China" && ran >= 5)	{
			}	//ADD
			println("Tensions escalate as army enters full-scale battles on border. Air units engage in airstrikes.")
			if (ply == "The United States of America" || ply == "France" || ply == "The United Kingdom")	{println("The Soviet Union uses the first tactical nuclear weapon.")}
			else if (ply == "The Soviet Union")	{println("The United States uses the first tactical nuclear weapon.")}
			else	{println("The first tactical nuclear weapon is used however it is not known by which side.")}
			maxNukeCheck(1,"+");
		}
		else if (month == 4 && year == 1985)	{
			noEvents = false
			var ran = Math.round(Math.random()*10)
			if (ply == "China" && ran  >= 5)	{
			}	//ADD
			println("Soviet army invades West Germany and declares war on NATO, they are expected to reach the French border in one to two months.")
			maxNukeCheck(1,"+");
		}
		else if (month == 5 && year == 1985)	{
			noEvents = false
			println("Warsaw Pact forces reach the Rhine river.")
			maxNukeCheck(1,"+")
		}
		else	{noEvents = true}
	}
	def player_response_events =	{
			if (month == 4 && year == 1985)	{
			  four_1985 = true
				if (ply == "China")	{	//Possibly should seperate these into two nested-if statements.
					println("Soviets ask for our support in their invasion of NATO. Will you pledge to support them?")
					var r = readLine();
					if (r.equalsIgnoreCase("Y"))	{
						//Add a line that also makes it so you can't nuke your allies.
						println("Mongolia is annexed to China as payment for their support.")
						println("Chinese army assists North Korea in invasion of South Korea.")
						ChinaSupport = true
						maxNukeCheck(1,"+");
					}
					else	{
						println("Tensions are lowered as NATO's fears are lessened.")
						ChinaSupport = false
						println()
						maxNukeCheck(1,"-");
					}	
				}
				else if (ply == "The Soviet Union")	{
					println("Would you like to ask China to support your war against NATO? Y/N.")
					var r = readLine();
					if (r.equalsIgnoreCase("Y"))	{
						//Add a line that also makes it so you can't nuke your allies.
						//Check correctness of this. Not always a decline but the chances feel wrong.
						var ran = Math.round(Math.random()*10)
						if (ran >= 5)	{
							println("Mongolia is annexed to China as payment for their support.")
							println("Chinese army assists North Korea in their invasion of South Korea.")
							ChinaSupport = true
							maxNukeCheck(1,"+");
						}
						else	{
							println("China declines. Tension is lowered as NATO's fears are lessened.")
							ChinaSupport = false
							maxNukeCheck(1,"-");
						}
						AskedChina = true
					}
					else	{AskedChina = false}
				}
				else	{
					var ran = Math.round(Math.random()*10)
						if (ran >= 5)	{
							println("The Soviet Union asks china for support in their invasion.")
							ran = Math.round(Math.random()*10)	//Not anymore? very odd chances seem wrong. Same thing as other China event. Always seems to be a decline. Investigate.
							if (ran >= 5)	{
								println("China agrees to assist them in their invasion of NATO.")
								println("Chinese army assists North Korea in their invasion of South Korea.")
								ChinaSupport = true
								maxNukeCheck(1,"+");
							}
							else	{
								println("China declines. Tension is lowered as NATO's fears are lessened.")
								ChinaSupport = false
								maxNukeCheck(1,"-");
							}
						}
						else	{}//Soviets don't ask China for support.
				}
			}
			else if	(month == 5 && year == 1985)	{
				five_1985 = true
				if (ply != "The United States of America")	{
					println("NATO launches large nuclear attacks against Warsaw forces.\nCasualties are up to 50 million for the Soviets.")	
					if (ply == "The Soviet Union")	{
						println("Respond with your own nuclear attack? Y/N.")
						var r = readLine();
						if (r.equalsIgnoreCase("Y"))	{
							println("The Soviet Union responds with their own attack. Casualties are up to 45 million.")
							us_nukes -= 334;rus_nukes -= 300;nukesFired += 634;uspop -= 45000000;ruspop -= 50000000
							maxNukeCheck(2,"+")
						}
						else	{println("The Soviet Union does not retaliate.");maxNukeCheck(1,"+");us_nukes -= 334;nukesFired += 334;ruspop -= 50000000}
					}
					else {
						println("NATO launches large scale nuclear attacks against Warsaw pact members.\nThe Soviet Union responds with their own attack. Casualties range from 40 million to 50 million for both sides.")
						maxNukeCheck(2,"+")
						us_nukes -= 334
						rus_nukes -= 300
						nukesFired += 634
						uspop -= 45000000
						ruspop -= 50000000
					}
				}
				else if (ply == "The United States of America")	{
					println("Warsaw Pact forces have reached the Rhine river. Do you wish to launch large scala nuclear attacks against the Soviet Union? Y/N.\nThis attack could lead to the destruction and total annihilation of mankind.")	
					var r = readLine();
					if (r.equalsIgnoreCase("Y"))	{
						println("The United States launches large scale nuclear attacks against the Soviet Union. Casualties are up to 50 million.")
						println("The Soviet Union responds with their own attack. Casualties are up to 45 million.")
						maxNukeCheck(2,"+")
						us_nukes -= 334
						rus_nukes -= 300
						nukesFired += 634
						uspop -= 45000000
						ruspop -= 50000000
					}
					else	{}
				}
				if (ply == "China" && ChinaSupport == true)	{
					println("Would you like to launch a naval invasion of Japan? Y/N.")
					var r = readLine();
					if (r.equalsIgnoreCase("Y"))	{
						println("NATO launches nuclear attack against China.")
						println("Casualties are 70  million.")
						nukesFired += 350
						us_nukes -= 350	//200k deaths per nuke.
						chipop -= 70000000
						maxNukeCheck(2,"+")
					}
					else	{}
				}
				else	{
					var ran = Math.round(Math.random()*10)
					if (ran >= 5 && ChinaSupport == true)	{
						println("China launches large scale naval invasion of Japan.")
						println("NATO launches nuclear attack against China.")
						println("Casualties are up to 70 million.")
						us_nukes -= 350	//200k deaths per nuke.
						nukesFired += 350
						chipop -= 70000000
						maxNukeCheck(1,"+")
					}
					else if (ran < 5 && ChinaSupport == true)	{println("China pledges not to take action against Japan. Tensions are lowered.");maxNukeCheck(1,"-")}
				}
			}
			else if (month == 6 && year == 1985)	{
				six_1985 = true
				println("To be added later.")
			}
			else if (noEvents == true)	{
				println("No significant global events have taken place.")
			}
			//Remember to add '(month)_(year) = true' for any more scripted events.
		println()
		println("-----------------------")
	}
	//start
	def play =	{
		var i = 0
		println("The date is 1/"+month+"/"+year+ ". The world is on the verge of nuclear war.")
		println("Enter a nuclear armed nation's name to play as their nuclear commander.")
		println("These nations include: 'The Soviet Union', 'The United States', 'The United Kingdom', 'France', and 'China.'")
		nations;
		do	{
			if (i > 0)	{
				println("The date is 1/"+month+"/"+year+".")	//Check this
			}
			i += 1
			who_to_nuke;
			if (noNuke == false)	{
				nuked;
				response;
				deaths;
			}
			else	{
				println("No nuclear weapons exchanged.")
			}
			cont_nuke;
			if (stop == true || loss == true)	{
				cont = false; game = false
			}
			else	{
				scripted_events;
				player_response_events;
				monthcheck;
				month += 1
			}
		} while (cont == true)
	}

	play;
	nukepopend = ruspop + uspop + frapop + ukpop + chipop + plypop	//Gonna have to check these once the reset function is in. Need to include them somewhere inside the play; function. Otherwise they won't calculate.
	vaguepopend = vaguepopend + nukepopend
	if (vaguepopend <= 0)	{vaguepopend = 0; nukepopend = 0}
	world_deaths = vaguepop - vaguepopend
	println("GAME OVER")
	println("Type in a command to view statistics and other information. (Type 'help' to see a list of commands)")
	var repeat = true
	do	{
		var stats = readLine();
		if (stats.equalsIgnoreCase("help"))	{
			println("'help': Displays this menu.")		  
			println("'population': Displays statistics on the world populations.")
			println("'nukes': Displays statistics on nukes fired and casualties.")
			println("'timeline': Displays events occured in game.")
			println("'replay': Re-sets all game statistics, restarts the game, and allows you to pick a new country.")
			println("'terminate': Terminates the program.")
		}
		else if (stats.equalsIgnoreCase("population"))	{
			println("	Population Statistics")
			println("Original population of all nuclear powers: " +df.format(nukepop))
			println("Current population of all nuclear powers: " +df.format(nukepopend))
			println("Original population of the world: " +df.format(vaguepop))
			println("Current population of the world: " +df.format(vaguepopend))
		}		
		else if	(stats.equalsIgnoreCase("nukes"))	{
			println("	Nuclear Statistics")
			println("There have been "+df.format(nukesFired)+" nuclear weapons fired.")
			println("They have resulted in "+df.format(world_deaths)+" deaths.")
		}
		else if (stats.equalsIgnoreCase("timeline"))	{
			println("	Game History")
			println("On 1/1/1985 you assumed nuclear control of "+ply)
			if (four_1985 == true)	{println("On 1/4/1985 the Soviet Union invaded West Germany.")}
			if (ply == "The Soviet Union" && AskedChina == true && four_1985 == true)	{
				println("On 1/4/1985 you chose to ask China for support.")
			}
			else if (ply == "The Soviet Union" && AskedChina == false && four_1985 == true)	{
				println("On 1/4/1985 you chose to not ask China for support.")
			}
			//
			if (ply == "China" && ChinaSupport == true && four_1985 == true)	{
				println("On 1/4/1985 you chose to support the Soviet invasion of NATO.")
			}
			else if (ply == "China" && ChinaSupport == false && four_1985 == true)	{
				println("On 1/4/1985 you chose not to support the Soviet invasion of NATO.")
			}
			else if (ChinaSupport == true && AskedChina == true && four_1985 == true)	{
				println("On 1/4/1985 China supported the Soviet invasion of NATO.")
			}
			else if (AskedChina == true && ChinaSupport == false && four_1985 == true)	{
				println("On 1/4/1985 China declined to support the Soviet invasion of NATO.")
			}
			//
			if (plypop == 0)	{
				println("On 1/"+deathMonth+"/"+deathYear+" your nation, "+ply+", was defeated.")
			}
			//Add a victory?
		}
		else if (stats.equalsIgnoreCase("replay"))	{
		  repeat = true
		  game = true
		  import Variables._	//This doesn't work im crying please save me lord.
		  do	{play;} while (game == true)
		}
		else if (stats.equalsIgnoreCase("terminate"))	{
			repeat = false;
			println("Program termianted.")
		}
		else	{
			println("Invalid command.")
		}
	} while (repeat == true)
}