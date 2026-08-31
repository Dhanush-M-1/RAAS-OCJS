#include <bits/stdc++.h>
using namespace std;
int gcd(int a, int b) {
  if (!b) return a;
  return gcd(b, a % b);
}
pair<int, int> flip(pair<int, int> p) { return make_pair(p.second, p.first); }
int rev(int x) {
  int r = 0;
  for (; x; x /= 10) {
    r = r * 10 + x % 10;
  }
  return r;
}
pair<int, int> get(int x) {
  int rx = rev(x);
  int d = gcd(x, rx);
  pair<int, int> p(x / d, rx / d);
  return p;
}
int main() {
  int maxx, maxy, w;
  cin >> maxx >> maxy >> w;
  map<pair<int, int>, vector<int> > m;
  for (int i = 1; i <= 100000; ++i) {
    m[get(i)].push_back(i);
  }
  int y = maxy;
  int s = 0;
  int ansX = -1, ansY = -1;
  long long mn = 1LL << 60;
  for (int x = 1; x <= maxx; ++x) {
    pair<int, int> py = flip(get(x));
    s += upper_bound((m[py]).begin(), (m[py]).end(), y) - m[py].begin();
    while (y >= 1) {
      pair<int, int> px = flip(get(y));
      int d = upper_bound((m[px]).begin(), (m[px]).end(), x) - m[px].begin();
      if (s - d >= w) {
        s -= d;
        --y;
      } else {
        break;
      }
    }
    if (s >= w && (long long)x * y < mn) {
      mn = (long long)x * y;
      ansX = x;
      ansY = y;
    }
  }
  if (mn == 1LL << 60)
    puts("-1");
  else
    printf("%d %d\n", ansX, ansY);
  return 0;
}
