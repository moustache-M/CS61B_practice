public class Planet {
    public double xxPos;       // Planet's current x position
    public double yyPos;       // Planet's current y position
    public double xxVel;       // Planet's current velocity in the x direction
    public double yyVel;       // Planet's current velocity in the y direction
    public double mass;        // Planet's mass
    public String imgFileName; // The name of file corresponds to the image of the plane

    /** initialize an instance of the Planet class */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /** take in a Planet object and initialize an identical Planet object */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /** calculates the distance between two Planets */
    public double calcDistance(Planet p) {
        double r, dx, dy, SquareD, left, right, error = 0.00001;

        dx = p.xxPos - this.xxPos; 
        dy = p.yyPos - this.yyPos; 
        dx = dx > 0.0 ? dx : -dx;      // distance should be positive or 0
        dy = dy > 0.0 ? dy : -dy;

        SquareD = dx*dx + dy*dy;
        right = SquareD;
        left = 0.0;
        r = (right+left) / 2.0;
        while (right != left) {
            if (r*r > SquareD) {
                right = r;
            } else if (SquareD - r*r > error) {
                left = r;
            } else {
                break;
            } 
            r = (right+left) / 2.0;
        }
        return r;
    }
}

