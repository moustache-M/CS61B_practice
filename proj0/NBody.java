public class NBody {

    /** return a double corresponding to the radius of the universe in the file */
    public static double readRadius(String FileName) {
        In in = new In(FileName);
        int PlanetsNumber = in.readInt();
        double PlanetsRadius = in.readDouble();
        return PlanetsRadius;
    }

    /** return an array of Planets corresponding to the planets in the file */
    public static Planet[] readPlanets(String FileName) {
        In in = new In(FileName);
        Planet Planets[] = new Planet[5] ;
        int PlanetsNumber = in.readInt();
        double PlanetsRadius = in.readDouble();
        for(int i = 0; i < 5; i++) {
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
}
