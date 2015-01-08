object scripted_events {
	import game_manager._, countries._, globalVar._;

	def scripted_events( game_manager: gm, ply: country ) = {
		if ( ply.Name == "The United States of America" ) { usa_scripted_events( game_manager ); }
		else if ( ply.Name == "The Soviet Union" ) { sov_scripted_events( game_manager ); }
		else if ( ply.Name == "France" ) { bri_scripted_events( game_manager ); }
		else if ( ply.Name == "The United Kingdom" ) { fra_scripted_events( game_manager ); }
		else if ( ply.Name == "China" ) { chi_scripted_events( game_manager ); }
	};

	//Private may or may not work in this scenario. In the event of any errors check this first.
	private final def usa_scripted_events( game_manager: gm ) = {
		if ( game_manager.Month == 2 && game_manager.Year == 1985 ) {}
		else if ( game_manager.Month == 3 && game_manager.Year == 1985 ) {}
	};
	private final def sov_scripted_events( game_manager: gm ) = {};
	private final def bri_scripted_events( game_manager: gm ) = {};
	private final def fra_scripted_events( game_manager: gm ) = {};
	private final def chi_scripted_events( game_manager: gm ) = {};
}