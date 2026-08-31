#include <bits/stdc++.h>
using namespace std;
vector<int> D;
int rev(int x) {
  if (D[x] != -1) return D[x];
  int p = 1;
  while (1) {
    if (p >= x) {
      if (p > x) p /= 10;
      break;
    }
    p *= 10;
  }
  int res = 0;
  while (x) {
    res += (x % 10) * p;
    p /= 10;
    x /= 10;
  }
  D[x] = res;
  return res;
}
int gcd(int a, int b) {
  while (b != 0) {
    int t = a % b;
    a = b;
    b = t;
  }
  return a;
}
int main() {
  istream &in = cin;
  D.resize(100001, -1);
  int mx, my, w, cnt = 0;
  in >> mx >> my >> w;
  map<pair<int, int>, int> MX, MY;
  long long x, y;
  for (x = 1; x <= mx; x++) {
    int rx = rev(x);
    int g = gcd(x, rx);
    if (x / g == 1 && rx / g == 1) {
      int tt = 0;
    }
    MX[make_pair(x / g, rx / g)]++;
  }
  int cw = 0;
  long long ax, ay;
  for (y = 1; y <= my; y++) {
    int ry = rev(y);
    int g = gcd(y, ry);
    pair<int, int> p = make_pair(ry / g, y / g);
    cw += MX[p];
    MY[p]++;
    if (cw >= w) break;
  }
  if (cw < w) {
    cout << -1;
    return 0;
  }
  x = mx;
  ax = x;
  ay = y;
  for (; x >= 1;) {
    int rx = rev(x);
    int g = gcd(x, rx);
    pair<int, int> px = make_pair(x / g, rx / g);
    int decr = MY[px];
    MX[px]--;
    x--;
    cw -= decr;
    if (cw >= w && x * y < ax * ay) {
      ax = x;
      ay = y;
    }
    if (cw < w) {
      bool ok = false;
      for (;;) {
        if (y == my) break;
        y++;
        int ry = rev(y);
        int g = gcd(y, ry);
        pair<int, int> py = make_pair(ry / g, y / g);
        int inc = MX[py];
        MY[py]++;
        cw += inc;
        if (cw >= w) {
          if (x * y < ax * ay) {
            ax = x;
            ay = y;
          }
          ok = true;
          break;
        }
      }
      if (!ok) {
        break;
      }
    }
  }
  cout << ax << " " << ay;
  return 0;
}
