#include <cstdio>
#include <complex>

using namespace std;

typedef complex<double> P;

int cross(P a, P b)
{
    return imag(conj(a) * b);
}

int ccw(P a, P b, P c)
{
    b -= a;
    c -= a;
    if (cross(b, c) > 0)   return +1; // counter clockwise
    if (cross(b, c) < 0)   return -1; // clockwise
    // if (dot(b, c) < 0)     return +2; // c--a--b on line
    // if (norm(b) < norm(c)) return -2; // a--b--c on line
    return 0;
}

int main()
{
    for (;;) {
        P p[4];
        double x, y;
        if (scanf("%lf,%lf,", &x, &y) == EOF)
            break;
        p[0] = P(x, y);
        scanf("%lf,%lf,", &x, &y);
        p[1] = P(x, y);
        scanf("%lf,%lf,", &x, &y);
        p[2] = P(x, y);
        scanf("%lf,%lf,", &x, &y);
        p[3] = P(x, y);

        int sign = ccw(p[0], p[1], p[2]);
        if (ccw(p[1], p[2], p[3]) == sign
                && ccw(p[2], p[3], p[0]) == sign
                && ccw(p[3], p[0], p[1]) == sign)
            puts("YES");
        else
            puts("NO");
    }

    return 0;
}