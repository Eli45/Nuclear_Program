[NEW CHANGES HERE](src/releases.scala)

moved to releases.scala

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
		converts a non nuclear state to a nuclear powered state.
