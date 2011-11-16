/**
 * Aditya Gande Period 3
 * Time Taken: 1 hour
 * Comments: This programm was very easy to complete.
 * The concepts are very similar to the intro class.
 * I now have a better knowledge of class and methods that
 * I hope to show off during the next test.
 */
import gpdraw.*;

public class Rectangle {

	private double myX;
	private double myY;
	private double myWidth;
	private double myHeight;
	private SketchPad paper = new SketchPad(500,500);
	private DrawingTool pen = new DrawingTool(paper);

    public Rectangle() {
		myX = 0;
		myY = 0;
		myWidth = 0;
		myHeight = 0;
    }

    public Rectangle(double x, double y, double width, double height){
    	myX = x;
    	myY = y;
    	myWidth = width;
    	myHeight = height;
    }

    public double getPerimeter(){
    	double per = myWidth * 2;
    	per =+ (myHeight*2);
    	return per;
    }

    public double getArea(){
    	return myWidth * myHeight;
    }

    public void draw(){
    	pen.up();
    	pen.move(myX,myY);
    	pen.down();
    	pen.move((myX + myWidth), myY);
    	pen.move((myX+myWidth), (myY + myHeight));
    	pen.move(myX, (myY + myHeight));
    	pen.move(myX, myY);
    }


}