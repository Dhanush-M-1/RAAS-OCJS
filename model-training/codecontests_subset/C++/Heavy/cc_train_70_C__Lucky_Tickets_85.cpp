#include <bits/stdc++.h>
using namespace std;
const int inf = 0x3f3f3f3f;
const int MOD = 1e9 + 7;
int rev[200005];
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
map<pair<int, int>, int> mpx;
map<pair<int, int>, int> mpy;
void init() {
  for (int i = 1; i <= 200000; i++) {
    int ans = i;
    int a = 0;
    while (ans) {
      a = ans % 10 + a * 10;
      ans /= 10;
    }
    rev[i] = a;
  }
}
int main() {
  init();
  int x, y, w;
  cin >> x >> y >> w;
  for (int i = 1; i <= y; i++) {
    pair<int, int> pi(i / gcd(i, rev[i]), rev[i] / gcd(i, rev[i]));
    mpy[pi]++;
  }
  int ans = 0;
  int posx, posy = y;
  for (posx = 1; posx <= x; posx++) {
    pair<int, int> pi(rev[posx] / gcd(rev[posx], posx),
                      posx / gcd(rev[posx], posx));
    mpx[pi]++;
    ans += mpy[pi];
    if (ans >= w) {
      break;
    }
  }
  int nmin = inf;
  int fx = -1;
  int fy = -1;
  if (ans >= w) {
    nmin = posx * y;
    fx = posx;
    fy = y;
  }
  int res = ans;
  while (true && posx <= x && posy >= 1 && res >= w) {
    pair<int, int> pi(posy / gcd(posy, rev[posy]),
                      rev[posy] / gcd(posy, rev[posy]));
    mpy[pi]--;
    res -= mpx[pi];
    while (res < w && posx + 1 <= x) {
      posx++;
      pair<int, int> pi(rev[posx] / gcd(rev[posx], posx),
                        posx / gcd(rev[posx], posx));
      mpx[pi]++;
      res += mpy[pi];
    }
    posy--;
    if (res >= w && posx * posy < nmin) {
      nmin = posx * posy;
      fx = posx;
      fy = posy;
    }
  }
  if (~fx && ~fy) {
    cout << fx << ' ' << fy << endl;
  } else
    cout << -1 << endl;
  return 0;
}
