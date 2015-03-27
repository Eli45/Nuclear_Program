object releases {
	class version( major: Int, minor: Int, patch1: Int, patch2: Int ) {
		private final val MAJOR = major;
		private final val MINOR = minor;
		private final val PATCH1 = patch1;
		private final val PATCH2 = patch2;
		final val vers = this.MAJOR + "." + this.MINOR + "." + this.PATCH1 + "." + this.PATCH2;
	};
	final val release = new version( 0, 0, 4, 0 );
}; /** Changelogs:

BUILD v0.0.4.0:
created file countryJSON.scala:
	uses JSON info of country populations in 2014 to create a hashmap.
	
in file countries.scala:
	created mutable list countryList to contain a list of all countries contained within the provided JSON info.
	old system is still present however eventually alliance system and will somehow need to be created to be compatible with the JSON system.
	
in file game_manager.scala:
	fixed "No nuclear weapons exchanged" bug.
	made choosing your country easier.
	made presentation of date and command choice better.
	implemented new Month class.

in file main.scala:
	removed dependency on global variable player.
	
in file globalVar.scala:
	removed global variable player.
	
created file month.scala: 
	class Month will represent month better and make our depiction of time passing more obvious to the user.
---------------

BUILD v0.0.3.3:
in file game_manager.scala:
	created help option in turn.
	created terminate option in turn.
	
---------------

BUILD v0.0.3.0:

re-did country system so that each country is treated equally under the same class instead of as a separate independent class.
this solves the problem of requiring method overloading for every method in which we must deal with both nuclear states and non nuclear states.

in countries.scala and game_manager.scala:
	all countries now treated as the same class.
	deprecated non_nuke_country class.
	moved Defcon variable to a country-by-country basis.
	moved max_nukes variable to a country-by-country basis.]
	created method update_max_nukes() for updating max_nukes available to fire.
	created method set_nukes() for setting the current numbers of nukes available.
	created method give_nukes() for giving the country ( or taking away ) a specified number of nukes.

in all other files:
	fixed various bugs that occurred because of this change.
	removed various un-needed variables and methods that are now useless because of this change.

---------------

BUILD v0.0.2.5:
created in file countries.scala:
	new countries:
		persia
		iraq
		syria
		isreal
		palestine
		jordan
		afghanistan
		pakistan
		india

in file functions.scala:
	moved methods choose_target and check_untargetable_states to game_manager.scala.

in file game_manager.scala:
	created printList() method for printing a list of countries.
	created start_turn() method for managing in turn actions.
	created choose_target() method for choosing an enemy to nuke (only available if at war.)
	created enter_combat() method for choosing how many nukes to launch at the enemy.
	created attack() method for dealing the damage the nukes dealt and the enemy's response to your nuclear attack( should include their allies ).
	created DefconCheck() method for checking max number of nukes able to launch depending on Defcon level.

in file functions.scala:
	created start_stats() method for showing statistics of the game to the player at the end of the session.

---------------

BUILD v0.0.2.0:
created in file countries.scala:
	new countries:
	Denmark
	Luxembourg
	Greece

	Hungary
	Czechoslovakia

created in file globalVar.scala:
	NATO and Warsaw pact:
		NATO:
			USA
			UK
			France
			West Germany
			Netherlands
			Belgium
			Luxembourg
			Norway
			Italy
			Spain
			Portugal
			Iceland
			Turkey
			Greece
		Warsaw Pact:
			Soviet Union
			East Germany
			Bulgaria
			Romania
			Czechoslovakia
			Hungary

---------------

BUILD v0.0.1.1:
slightly changes releases.scala version class.

---------------

BUILD v0.0.1.0:
deleted file(s):
	classes.scala.

created new file: releases.scala:
	contains class version describing current release number.


in functions.scala:
	made convert_non_nuclear_state method less slightly wordy.
	changed printed strings to be more 'immersive'.

in player_events, scripted_events.scala:
	changed file structure of player_events and scripted_events and made it use the game manager 'better'.

in countries.scala:
	renamed West German and East German variables to follow 3 character length variable name rules for country variable names.
	added some more non nuclear countries(with placeholder populations):
		Switzerland
		Italy
		Yugoslavia
		Austria
		Spain
		Portugal
		Albania
		Bulgaria
		Romania
		Turkey
		Norway
		Sweden
		Finland
		Ireland
		Iceland
		Morocco
		Algeria
		Tunisia
		Libya

---------------

BUILD v0.0.0.15:
created new file: ChangeLog.txt
created new file: functions.scala:
	moved pickNation(), check_untargetable_states() from main.scala to functions.scala.

new class in countries.scala:
	non_nuke_country: to be used for countries with no nuclear arms.

new function in game_manager.scala:
	destroy:
		used to delete countries after a conversion from a non_nuke_state to a country or vise-versa.

new function in functions.scala:
	convert_non_nuclear_state_to_nuclear:

**/ 
