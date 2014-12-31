object releases	{
	class version(major:Int, minor:Int, patch1:Int, patch2:Int)	{
		private final val MAJOR = major;
		private final val MINOR = minor;
		private final val PATCH1 = patch1;
		private final val PATCH2 = patch2;
		final val versionStr = release.MAJOR + "." + release.MINOR + "." + release.PATCH1 + "." + release.PATCH2;
	};
	final val release = new version(0, 0, 1, 1);
	
};

/** After patch v0.0.0.15 all changes are to be stored here:

BUILD v0.0.1.1:
	Slightly changes releases.scala version class.

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