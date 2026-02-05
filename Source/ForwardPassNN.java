public class ForwardPassNN {

    // Activation functions
    public static double sigmoid(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    public static double relu(double x) {
        return Math.max(0, x);
    }

    public static void main(String[] args) {
        // Step 1: Input vector
        double[] X = {0.5, 0.2, 0.1};  // 3 features

        // Step 2: Weights and biases
        // Hidden layer (3 inputs -> 2 neurons)
        double[][] W1 = {
            {0.1, 0.2},
            {0.4, 0.5},
            {0.7, 0.9}
        };
        double[] b1 = {0.01, 0.02};

        // Output layer (2 inputs -> 1 neuron)
        double[][] W2 = {
            {0.3},
            {0.6}
        };
        double[] b2 = {0.05};

        // Step 3: Forward pass
        // Hidden layer computation
        double[] z1 = new double[2];
        double[] a1 = new double[2];

        for (int j = 0; j < 2; j++) {
            z1[j] = b1[j];
            for (int i = 0; i < 3; i++) {
                z1[j] += X[i] * W1[i][j];
            }
            a1[j] = relu(z1[j]); // apply ReLU
        }

        // Output layer computation
        double[] z2 = new double[1];
        double[] a2 = new double[1];

        for (int j = 0; j < 1; j++) {
            z2[j] = b2[j];
            for (int i = 0; i < 2; i++) {
                z2[j] += a1[i] * W2[i][j];
            }
            a2[j] = sigmoid(z2[j]); // apply Sigmoid
        }

        // Step 4: Print results
        System.out.println("Input: ");
        for (double v : X) System.out.print(v + " ");
        System.out.println("\nHidden layer linear output (z1): ");
        for (double v : z1) System.out.print(v + " ");
        System.out.println("\nHidden layer activation (a1): ");
        for (double v : a1) System.out.print(v + " ");
        System.out.println("\nOutput layer linear output (z2): " + z2[0]);
        System.out.println("Final output (a2): " + a2[0]);
    }
}
