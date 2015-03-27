object main {
	import game_manager._, countries._, globalVar._, functions._, releases._;

	def main( args: Array[String] ) = {
		echo( "Running release version [" + release.vers + "] of nuclear command simulation." );
		var gm = new gm(pickNation());
		
		while ( gm.player.Pop > 0 ) {
			gm.exec_player_events();
			gm.exec_scripted_events();
			gm.start_turn();
			/*
			 * Choose target.
			 * Combat between target and player.
			 */
			gm.nextTurn();
		}
	}
};