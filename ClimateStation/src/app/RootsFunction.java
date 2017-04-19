package app;

import org.ejml.data.Complex64F;
import org.ejml.data.DenseMatrix64F;
import org.ejml.factory.DecompositionFactory;
import org.ejml.interfaces.decomposition.EigenDecomposition;

public class RootsFunction{

    public Complex64F[] findRoots(double[] coefficients) {
    int N = coefficients.length-1;

    // Construct the companion matrix
    DenseMatrix64F c = new DenseMatrix64F(N,N);

    double a = coefficients[N];
    for( int i = 0; i < N; i++ ) {
        c.set(i,N-1,-coefficients[i]/a);
    }
    for( int i = 1; i < N; i++ ) {
        c.set(i,i-1,1);
    }

    // use generalized eigenvalue decomposition to find the roots
    EigenDecomposition<DenseMatrix64F> evd =  DecompositionFactory.eig(N, false);

    evd.decompose(c);

    Complex64F[] roots = new Complex64F[N];

    for( int i = 0; i < N; i++ ) {
        roots[i] = evd.getEigenvalue(i);
    }
        return roots;
    }
//    public static void main(String[] args) {
//        RootsFunction r = new RootsFunction();
////        double[] arr = new double[]{0.0984, 0.1030,2.4035,-285.7895};
//        double[] arr = new double[]{-285.7895, 2.4035,0.1030,0.0984};
//        Complex64F[] roots =r.findRoots(arr);
//        for (Complex64F rar : roots){
//            System.out.println(rar.getReal() + "+ j"+rar.getImaginary());
//        }
//        
//    }
}

