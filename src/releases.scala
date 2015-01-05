object releases	{
	class version(major:Int, minor:Int, patch1:Int, patch2:Int)	{
		private final val MAJOR = major;
		private final val MINOR = minor;
		private final val PATCH1 = patch1;
		private final val PATCH2 = patch2;
		final val vers = this.MAJOR + "." + this.MINOR + "." + this.PATCH1 + "." + this.PATCH2;
	};
	final val release = new version(0, 0, 2, 5);
};

/** After patch v0.0.0.15 all changes are to be stored here:

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
	moved methods choose_target and check_untargetable_states.

in file game_manager.scala:
	created printList() method for printing a list of countries.
	created start_turn() method for managing in turn actions.
	created choose_target() method for choosing an enemy to nuke (only available if at war.)
	created enter_combat() method for choosing how many nukes to launch at the enemy.
	created attack() method for dealing the damage the nukes dealt and the enemy's response to your nuclear attack( should include their allies ).
	created DefconCheck() method for checking max number of nukes able to launch depending on Defcon level.

in file functions.scala:
	created start_states() method for showing statistics of the game to the player at the end of the session.

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
Slightly changes releases.scala version class.

---------------

BUILD v0.0.1.0:
deleted file(s):
	classes.scala.

created new file: releases.scala:
	contains class version describing current release number.


in functions.scala:
	Made convert_non_nuclear_state method less slightly wordy.
	Changed printed strings to be more 'immersive'.

in player_events, scripted_events.scala:
	Changed file structure of player_events and scripted_events and made it use the game manager 'better'.

in countries.scala:
	Renamed West German and East German variables to follow 3 character length variable name rules for country variable names.
	Added some more non nuclear countries(with placeholder populations):
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
