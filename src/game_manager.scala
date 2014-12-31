object game_manager	{
	import countries._, globalVar._;
	class gm()	{	//game_manager
		var Defcon = 5; //Lowest level of readiness. Possibly move to specific country basis.
		var Month = 1;
		var Year = 1985;
		var past_dates:List[String] = List("1/1985");
		/* ^ Update by:
		 * past_dates = past_dates :+ (Month.toString + "/" + Year.toString);
		 */
		
		def choice() =	{}; //player attack options. --Possibly remove this from gm or maybe not.
		
		def nextTurn() =	{
			this.Month += 1;
			if (this.Month > 12)	{
			  this.Month = 1; this.Year += 1;
			};
			this.past_dates = this.past_dates :+ (this.Month.toString + "/" + this.Year.toString);
		};
		
		def exec_scripted_events() =	{
			import scripted_events._;
			scripted_events(this, player);
		};
		
		def exec_player_events() =	{
			import player_events._;
			player_events(this);
		};
		def destroy(cntry:country) =	{
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nukes = 0;
			cntry.Nicks = null;
		};
		def destroy(cntry:non_nuke_country) =	{
			cntry.Name = null;
			cntry.Pop = 0;
			cntry.Nicks = null;
		};
	}
	
}