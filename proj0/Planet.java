public class Planet {
    public double xxPos;       // Planet's current x position
    public double yyPos;       // Planet's current y position
    public double xxVel;       // Planet's current velocity in the x direction
    public double yyVel;       // Planet's current velocity in the y direction
    public double mass;   
    public String imgFileName; // The name of file corresponds to the image of the plane
    private static final double G = 6.67e-11;  // the gravitational constant

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
        double r, dx, dy, SquareD, left, right, error = 0.01;

        dx = p.xxPos - this.xxPos; 
        dy = p.yyPos - this.yyPos; 
        dx = dx > 0.0 ? dx : -dx;      // distance should be positive or 0
        dy = dy > 0.0 ? dy : -dy;

        SquareD = dx*dx + dy*dy;
        right = SquareD;
        left = 0.0;
        r = (right+left) / 2.0;
        while (right - left > error) {
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

    /** calculate the force exerted on this planet by the given planet */
    public double calcForceExertedBy(Planet p) {
        double force;
        force = G * (p.mass * this.mass) / (this.calcDistance(p) * this.calcDistance(p));
        return force;
    }

    /** calculate the force exerted in the X and Y directions */
    public double calcForceExertedByX(Planet p) {
        double ForceX;

        ForceX = this.calcForceExertedBy(p) * (p.xxPos-this.xxPos) / this.calcDistance(p);
        return ForceX;
    }
    public double calcForceExertedByY(Planet p) {
        double ForceY;

        ForceY = this.calcForceExertedBy(p) * (p.yyPos-this.yyPos) / this.calcDistance(p);
        return ForceY;
    }

    /** calculate the force exerted in X and Y direction by all planets in array */
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double AllForce = 0.0;

        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                AllForce += this.calcForceExertedByX(p);
            }
        }
        return AllForce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double AllForce = 0.0;

        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                AllForce += this.calcForceExertedByY(p);
            }
        }
        return AllForce;
    }

    /** update the position and velocity depending on duration of the force */ 
    public void update(double dt, double fX, double fY) {
        this.xxVel = this.xxVel + dt * (fX / this.mass);
        this.yyVel = this.yyVel + dt * (fY / this.mass);
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }  
}

