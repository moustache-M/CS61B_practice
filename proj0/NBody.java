public class NBody {

    /** return a double corresponding to the radius of the universe in the file */
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int PlanetsNumber = in.readInt();
        double UniverseRadius = in.readDouble();
        return UniverseRadius;
    }

    /** return an array of Planets corresponding to the planets in the file */
    public static Planet[] readPlanets(String FileName) {
        In in = new In(FileName);
        int PlanetsNumber = in.readInt();
        Planet Planets[] = new Planet[PlanetsNUmber] ;
        double PlanetsRadius = in.readDouble();
        for(int i = 0; i < PlanetsNumber; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, img); 
        }
        return Planets;
    }

    public static void main(String[] args) {
        double T, dt, radius;
        In in;
        Planet[] Planets = new Planet[5];
        String filename;
        String imgBackGround = "images/starfield.jpg";

        T = Double.parseDouble(args[0]);
        dt = Double.parseDouble(args[1]);
        filename = args[2];
        in = new In(filename);
        radius = readRadius(filename);
        Planets = readPlanets(filename); 

        /** sets up the universe from
         * -radius, -radius up to radius, radius */
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, imgBackGround);

        StdDraw.enableDoubleBuffering();
        for (int time = 0; time < T; time += dt) {
            double[] xForce = new double[Planets.length];
            double[] yForce = new double[Planets.length];
            for (int i = 0; i < Planets.length; i++) {
                xForce[i] = Planets[i].calcNetForceExertedByX(Planets);
                yForce[i] = Planets[i].calcNetForceExertedByY(Planets);
            }
            for (int i = 0; i < Planets.length; i++) {
                Planets[i].update(dt, xForce[i], yForce[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, imgBackGround);
            for (int i = 0; i < Planets.length; i++) {
                Planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(3);
        }

        StdOut.printf("%d\n", Planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < Planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel,
                    Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
        }
    }


}
