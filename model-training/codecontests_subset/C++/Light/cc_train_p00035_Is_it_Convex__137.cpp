#include <iostream>
#include <complex>

using namespace std;

typedef complex<double> P;

#define EPS (1.0e-11)
#define EQ(a,b) (abs((a)-(b)) < EPS)
#define EQV(a,b) ( EQ((a).real(), (b).real()) && EQ((a).imag(), (b).imag()) )

double cross(P a, P b) {
    return (a.real() * b.imag() - a.imag() * b.real());
}


int main()
{
    double x[4], y[4];
    char comma;

    while (cin >> x[0] >> comma >> y[0]) {
        for (int i = 1; i < 4; i++) 
            cin >> comma >> x[i] >> comma >> y[i];

        double ck = 1;
        for (int i = 0; i < 4; i++) {
            ck *= cross(P(x[(i + 1) % 4] - x[i], y[(i + 1) % 4] - y[i]), 
                        P(x[(i + 2) % 4] - x[i], y[(i + 2) % 4] - y[i]));
        }
        if (ck > EPS)
            cout << "YES" << endl;
        else 
            cout << "NO" << endl;
    }
    
    return 0;
}