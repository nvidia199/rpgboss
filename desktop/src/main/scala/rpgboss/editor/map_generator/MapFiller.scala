package rpgboss.editor.map_generator

import rpgboss.editor.MapViewTools.Pencil
import rpgboss.editor.{MapLayers, MapViewState}
import rpgboss.model.resource.RpgMap


class MapFiller (mapvs: MapViewState, genMap:MapGenerator){

  /*
  val iter: Int = _
  val seed: Int = _
  val width = RpgMap.initXSize
  val height = RpgMap.initYSize

  val mapGen = new MapGenerator(iter, seed, height, width)
  */
  val yBorder:Int = 2       // borders are used so the containers won't be completely filled leafs section empty
  val xBorder:Int = 2
  val containList = genMap.findFinalChambers()
  val tCode = Array(Array(Array(RpgMap.autotileByte, 1.toByte, 0.toByte)))

  val selectedLayer = MapLayers.Bot

  mapvs.begin()
  for(z <- 0  to containList.length-1){
    val container = containList(z)
    for(i <- (container.leftBound + xBorder) to (container.rightBound - xBorder)){            //horizontal loop
      for(j <- (container.upperBound + yBorder) to (container.lowerBound - yBorder)){          // vertical Loop

        val point = container.point(i,j)
        Pencil.onMouseDown(mapvs, tCode, selectedLayer, point._1, point._2)
      }
    }

  }
  mapvs.commit()


}
