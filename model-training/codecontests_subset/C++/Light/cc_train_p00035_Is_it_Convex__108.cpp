#include <cstdio>
#include <iostream>
#include <complex>

using namespace std;

double cross(complex<double> A, complex<double> B)
{
  return A.real() * B.imag() - A.imag() * B.real();
}

int main()
{
  complex<double> p[4];
  double x, y;
  while (scanf("%lf,%lf", &x, &y) == 2) {
    p[0] = complex<double>(x, y);
    for (int i = 1; i < 4; i++) {
      scanf(",%lf,%lf", &x, &y);
      p[i] = complex<double>(x, y);
    }
    
    if (cross(p[2] - p[0], p[1] - p[2]) * cross(p[2] - p[0], p[3] - p[2]) < 0 &&
	cross(p[3] - p[1], p[0] - p[3]) * cross(p[3] - p[1], p[2] - p[3]) < 0) {
      printf("YES\n");
    } else {
      printf("NO\n");
    }
  }
  return 0;
}