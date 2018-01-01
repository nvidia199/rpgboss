package rpgboss.editor.map_generator


/*
  Author: Asma Oualmakran
  Class: Container: constructs a container which is a subsection
                    of a canvas / game field
        parameters:
                  x: type -> Integer, the horizontal starting point of the canvas/field
                  y: type -> Integer, the vertical starting point of the canvas/field
                  h: type -> Integer, the horizontal end point of the canvas/field
                  w: type -> Integer, the vertical end point of the canvas/field
       Use: To subsection the game field or other subsections.
   case class is used, the data generated by the class is immutable.
 */


case class Container(x:Int, y:Int, h:Int, w:Int) extends Tcontainer {

  val left_bound  = this.x
  val upper_bound = this.y
  val lower_bound = this.h
  val right_bound = this.w
  val width = right_bound - left_bound
  val height = lower_bound - upper_bound


  /*
    Function: point
    Parameters:
      x: Int
        Use: The x coordinate of the point.
      y: Int
        Use: The y coordinate of the point.
    Return: Tuple2[Int, Int]
    Use: Takes 2 integers and converts them to a tuple to use as coordinates.
   */
  override def point(x:Int, y:Int):Tuple2[Int, Int] = {
    val point = (x,y)
    return point
  }


  /*
    Function: size
    Parameters: n/a
    Returns: Int
    Use: Calculate the surface of the container.
   */

  override def size():Int = {
    val surface = width*height
    return surface
  }

  /*
    Function: center
    Parameters: n/a
    Returns: Tuple2[Int, Int]
    Use: Calculate the center point of the container.
   */
  override def center():Tuple2[Int, Int] = {

    val hor_center = ((w - x)/2)
    val ver_center = ((h - y)/2)

    val center = point(hor_center,ver_center)
    return center
  }


}

