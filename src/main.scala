object main	{
	import classes._, game_manager._, countries._, globalVar._, functions._;
	
	def main(args: Array[String]) =	{
		var gm = new gm();
		pickNation();
		while (player.Pop > 0)	{
			gm.exec_player_events();
			gm.exec_scripted_events();
			/*
			 * Choose target.
			 * Combat between target and player.
			 */
			gm.nextTurn();
		}
	}
}