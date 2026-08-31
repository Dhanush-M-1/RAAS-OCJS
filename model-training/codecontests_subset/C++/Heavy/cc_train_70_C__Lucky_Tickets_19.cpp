#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1.0);
int rev(int x) {
  int res = 0;
  while (x) {
    res = res * 10 + x % 10;
    x /= 10;
  }
  return res;
}
int gcd(int a, int b) {
  if (!b) return a;
  return gcd(b, a % b);
}
map<pair<int, int>, int> mx, my;
int X, Y, W;
int main() {
  cin >> X >> Y >> W;
  long long best = 1000111000111000LL;
  int savex = -1, savey;
  for (int y = (1), _b = (Y); y <= _b; y++) {
    int g = gcd(y, rev(y));
    my[make_pair(rev(y) / g, y / g)]++;
  }
  long long now = 0;
  long long y = Y;
  for (int x = (1), _b = (X); x <= _b; x++) {
    int g = gcd(x, rev(x));
    mx[make_pair(x / g, rev(x) / g)]++;
    now += my[make_pair(x / g, rev(x) / g)];
    while (y > 0 && now >= W) {
      if (x * y <= best) {
        best = x * y;
        savex = x;
        savey = y;
      }
      int g = gcd(y, rev(y));
      now -= mx[make_pair(rev(y) / g, y / g)];
      my[make_pair(rev(y) / g, y / g)]--;
      y--;
    }
  }
  if (savex == -1) {
    puts("-1");
    return 0;
  }
  cout << savex << ' ' << savey;
  return 0;
}
