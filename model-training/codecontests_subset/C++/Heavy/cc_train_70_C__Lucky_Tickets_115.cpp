#include <bits/stdc++.h>
using namespace std;
long long mx, my, w;
map<double, int> a, b;
int rev(long long x) {
  long long ret = 0;
  while (x) {
    ret *= 10;
    ret += x % 10;
    x /= 10;
  }
  return ret;
}
long long get(long long x, long long y) {
  a.clear();
  for (long long i = 1; i <= y; ++i) {
    double tmp = 1.0 * rev(i) / i;
    a[tmp]++;
  }
  long long ret = 0;
  for (long long i = 1; i <= x; ++i) {
    double tmp = 1.0 * i / rev(i);
    ret += a[tmp];
  }
  return ret;
}
int main() {
  cin >> mx >> my >> w;
  if (get(mx, my) < w) {
    puts("-1");
    return 0;
  }
  int nx = mx, ny = 1, ax = mx, ay = my;
  long long now = get(nx, ny);
  a.clear();
  for (long long i = 1; i <= nx; ++i) {
    a[1.0 * i / rev(i)]++;
  }
  b.clear();
  for (long long i = 1; i <= ny; ++i) {
    b[1.0 * rev(i) / i]++;
  }
  while (nx >= 1 && ny <= my) {
    if (now < w) {
      ny++;
      double tmp = 1.0 * rev(ny) / ny;
      now += a[tmp];
      b[tmp]++;
    } else {
      if (1ll * nx * ny < 1ll * ax * ay) {
        ax = nx;
        ay = ny;
      }
      double tmp = 1.0 * nx / rev(nx);
      nx--;
      now -= b[tmp];
      a[tmp]--;
    }
  }
  cout << ax << " " << ay << endl;
  return 0;
}
