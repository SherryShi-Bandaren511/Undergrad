public class NBody{

    private static int N;
    private static double R;
    
    public static double readRadius(String filename){
        In in = new In(filename);

        N = in.readInt(); // N has already be set here 
        R = in.readDouble();
        
        return R;
    }

    public static Planet[] readPlanets(String filename){
        
        In in = new In(filename);
        int num = in.readInt(); 
        double radius = in.readDouble();
        Planet[] planets = new Planet[num];

        for (int i = 0; i < num; i++){
            planets[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());

        }
        return planets;



    }

    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();
        double T = Double.valueOf(args[0]); // change string to double
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        Double R = readRadius(filename);
        StdDraw.setScale(-R,R);


        double time = 0;
        while (time < T){
            double[] xForces = new double[N];
            double[] yForces = new double[N];

            for (int i =0; i < N; i++){
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
                
 
            }
            for (int i = 0; i < N; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

        
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (Planet planet : planets) {
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt; 
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", R);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }


        

        
    }
}
