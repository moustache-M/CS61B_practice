import synthesizer.GuitarString;

/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
public class GuitarHero {
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/'";

    public static double freq_fromula(int keyOrder) {
        return 440 * Math.pow(2, (keyOrder - 24)/12);
    }


    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        synthesizer.GuitarString[] PianoKey = new synthesizer.GuitarString[37];

        for (int i = 0; i < 37; i++) {
            double freq = freq_fromula(i);
            PianoKey[i] = new synthesizer.GuitarString(freq);
        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int keyOrder = -1;
                keyOrder = keyboard.indexOf(key);

                if (keyOrder >= 0) {
                    PianoKey[keyOrder].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < 2; i++) {
                sample += PianoKey[i].sample();
                System.out.println(sample);
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (int i = 0; i < 2; i++) {
                PianoKey[i].tic();
            }
        }
    }
}


