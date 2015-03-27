object month	{

	class Month(month:Int)
	{
		var CurrentMonth = month;
		
		if (CurrentMonth > 12)
			CurrentMonth = 12;
		else if (CurrentMonth < 12)
			CurrentMonth = 1;
		
		def +(that:Int):Int =
		{
			return this.CurrentMonth + that;
		};
		
		def +=(that:Int) =
		{
			this.CurrentMonth += that;
		};
		
		def >(that:Int):Boolean =
		{
			return this.CurrentMonth > that;
		};
		
		def <(that:Int):Boolean =
		{
			return this.CurrentMonth < that;
		};
		
		def ==(that:Int):Boolean =
		{
			return this.CurrentMonth == that;
		};
		
		def update(that:Int)
		{
			this.CurrentMonth = that;		
		};
		
		def toStringIntForm():String =
		{
			return this.CurrentMonth.toString(); 
		};
		
		override def toString():String =
		{
			val cm = this.CurrentMonth;
			
			if 		(cm == 1)	{ return "January"; 	};
			else if (cm == 2)	{ return "February"; 	};
			else if (cm == 3)	{ return "March"; 		};
			else if (cm == 4)	{ return "April"; 		};
			else if (cm == 5)	{ return "May"; 		};
			else if (cm == 6)	{ return "June";		};
			else if (cm == 7)	{ return "July"; 		};
			else if (cm == 8)	{ return "August"; 		};
			else if (cm == 9)	{ return "September"; 	};
			else if (cm == 10)	{ return "Octobor";  	};
			else if (cm == 11)	{ return "November";	};
			else if (cm == 12)	{ return "December"; 	};
		
			throw new Exception("CurrentMonth: " + this.toStringIntForm() + " is out of range 1-12.");
		};
		
	}
	
}