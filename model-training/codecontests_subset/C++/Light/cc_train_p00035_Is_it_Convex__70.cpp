#include <cstdio>

using namespace std;

int side(double a, double b, double c, double d) {
  return a * d - b * c >= 0 ? 1 : -1;
}

int main() {
  double x[8], y[8];
  while (scanf("%lf,%lf", x, y) == 2) {
    for (int i = 1; i < 4; i++)
      scanf(",%lf,%lf", x+i, y+i);
    for (int i = 0; i < 4; i++)
      x[i+4] = x[i];
    int s = 0;
    for (int i = 0; i < 4; i++)
      s += side(x[i+1]-x[i], y[i+1]-y[i], x[i+2]-x[i+1], y[i+2]-y[i+1]);
    puts((s == 4 || s == -4) ? "YES" : "NO");
  }
  return 0;
}