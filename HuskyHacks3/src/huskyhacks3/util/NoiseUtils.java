//http://flafla2.github.io/2014/08/09/perlinnoise.html


package huskyhacks3.util;


/**
 *
 * @author Benjamin
 */
public class NoiseUtils {
    
    public static double octaved_noise2(double x, double y, int octaves, double persistence) {
        double total = 0;
        double frequency = 1;
        double amplitude = 1;
        double maxValue = 0;  // Used for normalizing result to 0.0 - 1.0
        for(int i=0;i<octaves;i++) {
            total += SimplexNoise.noise(x * frequency, y * frequency) * amplitude;

            maxValue += amplitude;

            amplitude *= persistence;
            frequency *= 2;
        }

        return total/maxValue;
    }
    
    public static double octaved_noise3(double x, double y, double z, int octaves, double persistence) {
        double total = 0;
        double frequency = 1;
        double amplitude = 1;
        double maxValue = 0;  // Used for normalizing result to 0.0 - 1.0
        for(int i=0;i<octaves;i++) {
            total += SimplexNoise.noise(x * frequency, y * frequency, z * frequency) * amplitude;

            maxValue += amplitude;

            amplitude *= persistence;
            frequency *= 2;
        }

        return total/maxValue;
    } 
    
    public static double octaved_noise2v2(double x, double y, int octaves, float roughness, float scale){
        double noiseSum = 0;
        double layerFrequency = scale;
        double layerWeight = 1;
        double weightSum = 0;
	
        for (int octave = 0; octave < octaves; octave++) {
            x *= layerFrequency;
            y *= layerFrequency;
            noiseSum += SimplexNoise.noise(x, y) * layerWeight;
            layerFrequency *= 2;
            weightSum += layerWeight;
            layerWeight *= roughness;
        }
        return noiseSum / weightSum;
    }
    
    public static double complex_noise2(double x, double y, int octaves, IFunc roughness, IFunc scale){
        double n0 = SimplexNoise.noise(x,y);
        double noiseSum = 0;
        double layerFrequency = scale.of(n0);
        double layerWeight = 1;
        double weightSum = 0;
	
        for (int octave = 0; octave < octaves; octave++) {
            //x *= layerFrequency;
            //y *= layerFrequency;
            noiseSum += SimplexNoise.noise(x*layerFrequency, y*layerFrequency) * layerWeight;
            layerFrequency *= 2;
            weightSum += layerWeight;
            layerWeight *= roughness.of(n0);
        }
        return noiseSum / weightSum;
    }
    
    
    
    
}
