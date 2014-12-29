object game_manager	{
	class gm()	{	//game_manager
		var Defcon = 5; //Lowest level of readiness. Possibly move to specific country basis.
		var Month = 1;
		var Year = 1985;
		var past_dates:List[String] = List("1/1985");
		/* ^ Update by:
		 * past_dates = past_dates :+ (Month.toString + "/" + Year.toString);
		 */
		
		def choice() =	{}; //player attack options.
		
		def nextTurn() =	{
			this.Month += 1;
			if (this.Month > 12)	{
			  this.Month = 1; this.Year += 1;
			};
			this.past_dates = this.past_dates :+ (this.Month.toString + "/" + this.Year.toString);
		};
		
		def exec_scripted_events() =	{
			import scripted_events._;
			scripted_events(this);
		};
		
		def exec_player_events() =	{
			import player_events._;
			player_events(this);
		}
	}
	
}