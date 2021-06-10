package cmsc256;
import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingLab {
	
	public static void main(String[] args) throws Exception{
		//create the Bridges object
		Bridges bridges = new Bridges(0, "singhg24", "816756910631");
		DataSource ds = bridges.getDataSource();
		List<ActorMovieIMDB> movieData = null;
	
		try {
			movieData = ds.getActorMovieIMDBData();
		}
		catch (Exception e) {
			System.out.println("Unable to connect to Bridges.");
		}
	

		
		Collections.sort(movieData, new ActorComparator());
		System.out.println("The following actors appeared in the movie, Being John Malkovich:");

		for(ActorMovieIMDB actor : movieData) {
			if(actor.getMovie().equalsIgnoreCase("Being_John_Malkovich_(1999)")) {
				System.out.println(actor.getActor());

			}
		}
	}
}
	