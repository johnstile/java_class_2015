package line;

/*
 *
 * By: John Stile <john@stilen.com>
 * Assignment: Lab1 (part B)
 *
 * Given: 2 points ( x1,y1 and x2,y2 ), only one line passes though this
 * This classes defines a line using four integers.
 * The methods have been written for you,
 * but you need to test them.
 * In fact, there just might be a bug!
 * 1. Fill in the main method
 */

// Line class with points stored
public class Line1 {
	// Instance variables for this class
	int	x1, y1, x2, y2;

	// returns the slope of the line. This is a ratio of rise over run.
	double slope() {
		double slope = ( y1 - y2 ) / ( x1 - x2 );
		return slope;
	}

	// returns true if the point given as parameters is on the line
	// algorithm: check that the lines between this point and our
	// other points have the same slope.
	boolean pointOnLine( int x, int y ) {
		// first slope is between the passed in point and x1,y1
		double slope1 = ( y - y1 ) / ( x - x1 );
		// slope between parameter point and x2,y2
		double slope2 = ( y - y2 ) / ( x - x1 );
		// if the slopes are equal, then the point is on the line
		return ( slope1 == slope2 );
	}

	// who remembers this stuff? http://planetmath.org/anglebetweentwolines
	// does.
	double angleTo( Line1 otherLine ) {
		double differenceInSlopes = slope() - otherLine.slope();
		double denominator = 1 + ( slope() * otherLine.slope() );
		double angleInDegrees = Math.abs( differenceInSlopes / denominator );
		return angleInDegrees;
	}

	// Use main() to test your Line1 class
	public static void main( String[] args ) {
		System.out.println( "testing Line1" );
		// Set myLine to contain a reference to a new line object.
		Line1 myLine = new Line1();
		// Initialize myLine's x1 and y1 to the point (5, 10),
		// and initialize myLine's x2 and y2 to the point (45, 50).
		myLine.x1 = 5;
		myLine.x2 = 10;
		myLine.y1 = 45;
		myLine.y2 = 50;

		// Print the line's slope, which should be 1 (or, 45 degrees).
		double mySlope = myLine.slope();
		System.out.println( "The Slope of myLine is:" + mySlope );

		// check that (10,15) is on the line
		boolean onLine = myLine.pointOnLine( 10, 15 );
		if ( onLine ) {
			System.out.println( "Point 10,15 is on the line!" );
		}
		else {
			System.out.println( "Point 10,15 is not on the line!" );
		}
		// check that the angle between this line and another line
		// defined by (5,10) and (10,20) is about 1/3
		Line1 myLine2 = new Line1();
		myLine2.x1 = 5;
		myLine2.x2 = 10;
		myLine2.y1 = 10;
		myLine2.y2 = 20;
		double mySlope2 = myLine2.slope();
		double myAngleTo = myLine.angleTo( myLine2 );
		System.out.println( "myLine angleTo myLine2 is:" + myAngleTo );
	}
}
