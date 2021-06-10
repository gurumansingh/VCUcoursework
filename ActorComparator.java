package cmsc256;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bridges.connect.Bridges;
import bridges.connect.DataSource;
import bridges.data_src_dependent.ActorMovieIMDB;

public class ActorComparator implements Comparator<ActorMovieIMDB>{		

	@Override
	public int compare(ActorMovieIMDB o1, ActorMovieIMDB o2) {
		return o1.getActor().compareTo(o2.getActor());
	}
}
