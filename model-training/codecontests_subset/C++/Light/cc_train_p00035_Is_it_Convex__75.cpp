#include <cstdio>
#include <complex>
using namespace std;

int main()
{
    while (true)
    {
        double x[4];
        double y[4];
        if (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",
                x+0, y+0, x+1, y+1, x+2, y+2, x+3, y+3) != 8)
            break;

        complex<double> c[4];
        for (int i=0; i<4; i++)
            c[i] = complex<double>(x[i], y[i]);

        int l = 0;
        int r = 0;
        for (int i=0; i<4; i++)
        {
            complex<double> a = c[(i+2)%4] - c[(i+1)%4];
            complex<double> b = c[(i+1)%4] - c[(i+0)%4];
            (arg(a/b)>0 ? l : r)++;
        }
        puts(l==4 || r==4 ? "YES" : "NO");
    }
}