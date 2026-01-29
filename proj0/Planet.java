

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;

        return Math.pow((dx *dx + dy * dy), 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        return (6.67 * Math.pow(10, -11) * this.mass * p.mass) / (Math.pow((this.calcDistance(p)), 2));
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        
        return this.calcForceExertedBy(p) * dx / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        
        return this.calcForceExertedBy(p) * dy / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double result = 0.0;
        for (Planet planet : planets){
            if (this.equals(planet)){
                continue;
            }
            result += this.calcForceExertedByX(planet);
        }
        return result;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double result = 0.0;
        for (Planet planet : planets){
            if (this.equals(planet)){
                continue;
            }
            result += this.calcForceExertedByY(planet);
        }
        return result;
    }

    public void update(double dt, double xN, double yN){
        double xAccelarate = xN / mass;
        double yAccelarate = yN / mass;

        xxVel += xAccelarate * dt;
        yyVel += yAccelarate * dt;

        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }




}
