object game_manager	{
	class gm()	{	//game_manager
		var Defcon = 5; //Lowest level of readiness. Possibly move to specific country basis.
		var month = 1;
		var year = 1985;
		var past_dates:List[String] = List("1/1985");
		/* ^ Update by:
		 * past_dates = past_dates :+ (month.toString + "/" + year.toString);
		 */
		
		def updateDates =	{
			this.month += 1;
			if (this.month > 12)	{
			  this.month = 1; this.year += 1;
			}
			this.past_dates = this.past_dates :+ (this.month.toString + "/" + this.year.toString);
		}
	}
	
}