import processing.core.PApplet;
import processing.core.PImage;

/**
 * Description: A program that animates Kobe Bryant and a basketball with a basketball hoop in the background
 * @author: L. Pei 
 */

public class Sketch extends PApplet {
	// global variables

  // declare global image variables
  PImage imgHoop;
  PImage imgKobe;

  // ball coordinates
  float fltBallX = width/4;
  float fltBallY = height/8;
  float fltBallDiameter = width/5;

  // ball speed
  float fltBallSpeedX = 1;
  float fltBallSpeedY = 3;

  // Kobe's coordinates
  float fltKobeX = 25;
  float fltKobeY = 375;

  // Kobe's speed
  float fltKobeSpeedX = 3;


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
    // assign images to global image variables
    imgHoop = loadImage("bball-hoop.jpg");
    imgHoop.resize(width, height);

    imgKobe = loadImage("mamba.png");
    imgKobe.resize(width/5, height/6);

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // basketball hoop background
    image(imgHoop, 0, 0);

    // basketball animated linearly with collision detection
    fill(245, 111, 66);
    ellipse(fltBallX, fltBallY, fltBallDiameter, fltBallDiameter);
    fltBallX += fltBallSpeedX;
    fltBallY += fltBallSpeedY;
    
    if (fltBallX < 0 + 15 || fltBallX > width - 10) {
      fltBallSpeedX *= -1;
    }
  
    if (fltBallY < 0 + 15 || fltBallY > height - 15) {
      fltBallSpeedY *= -1;
    }
    
    // Kobe Bryant animated parabolically with collision detection
    image(imgKobe, fltKobeX, fltKobeY);
    
    float fltParabola = (float)Math.pow(1.5 * fltKobeX - 200, 2);

    fltKobeX = fltKobeX + fltKobeSpeedX;
    fltKobeY = fltParabola / 225;

    if (fltKobeX < 0 || fltKobeX > width - 80) {
      fltKobeSpeedX *= -1;
    }
    if (fltKobeY < 0 + 15 || fltKobeY > height - 15) {
      fltParabola *= -1;
    }
  }
}