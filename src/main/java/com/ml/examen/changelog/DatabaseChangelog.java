package com.ml.examen.changelog;

import org.jongo.Jongo;
import org.jongo.MongoCollection;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;

@ChangeLog
public class DatabaseChangelog {

  @ChangeSet(order = "001", id = "planets", author = "rcollados")
  public void loadPlantes(Jongo jongo){
	  MongoCollection coll = jongo.getCollection("planets");
	  coll.insert("{ name: \"Vulcano\", position:{x:0, y:0}, radious:1000,  angle:0, angularSpeed:-3}");
	  coll.insert("{ name: \"Ferengi\", position:{x:0, y:0}, radious:500, angle:0, angularSpeed:-1}");
	  coll.insert("{ name: \"Betasoide\", position:{x:0, y:0}, radious:2000, angle:0, angularSpeed:5}");
  }
  
  @ChangeSet(order = "002", id = "galaxy", author = "rcollados")
  public void loadGalaxy(Jongo jongo){
	  MongoCollection mycollection = jongo.getCollection("galaxies");
	  mycollection.insert("{name: \"galaxy\", planets:"
	  		+ "[{ name: \"Vulcano\", position:{x:0, y:0}, radious:1000,  angle:0, angularSpeed:-3},"
	  		+ "{ name: \"Ferengi\", position:{x:0, y:0}, radious:500, angle:0, angularSpeed:-1},"
	  		+ "{ name: \"Betasoide\", position:{x:0, y:0}, radious:2000, angle:0, angularSpeed:5}]}");
  }
}