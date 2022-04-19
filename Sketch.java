import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	// global variables

  // declare image variable for background
  PImage imgHoop;

  // ball dimensions
  float fltBallX = width/4;
  float fltBallY = width/8;
  float fltBallDiameter = width/5;

  // ball speed
  float fltBallSpeedX = 1;
  float fltBallSpeedY = 3;


  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    imgHoop = loadImage("bball-hoop.jpg");
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // basketball hoop background
    image(imgHoop, 0, 0);
    imgHoop.resize(width, width);

    // animated basketball
    fill(245, 111, 66);
    ellipse(fltBallX, fltBallY, fltBallDiameter, fltBallDiameter);
    fltBallX += fltBallSpeedX;
    fltBallY += fltBallSpeedY;
    
    //collision detection
    if (fltBallX < 0 + 15 || fltBallX > width - 10) {
      fltBallSpeedX *= -1;
    }
  
    if (fltBallY < 0 + 15 || fltBallY > height - 15) {
      fltBallSpeedY *= -1;
    }
  }
}