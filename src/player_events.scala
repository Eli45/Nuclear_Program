object player_events {
	import game_manager._, globalVar._;
	def player_events( game_manager: gm ) = {
		if 		( game_manager.player.Name == "The United States of America" ) 	{ usa_events(); }
		else if ( game_manager.player.Name == "The Soviet Union" ) 				{ sov_events(); }
		else if ( game_manager.player.Name == "France" ) 						{ fra_events(); }
		else if ( game_manager.player.Name == "The United Kingdom" ) 			{ bri_events(); }
		else if ( game_manager.player.Name == "China" ) 						{ chi_events(); }
	};
	//Private may or may not work in this scenario. In the event of any errors check this first.
	private final def usa_events() = {

	};
	private final def sov_events() = {

	};
	private final def fra_events() = {

	};
	private final def bri_events() = {

	};
	private final def chi_events() = {

	};
}