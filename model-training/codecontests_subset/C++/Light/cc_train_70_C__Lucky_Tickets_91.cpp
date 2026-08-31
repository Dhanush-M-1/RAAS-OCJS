#include <bits/stdc++.h>
using namespace std;
int MX, MY, W;
class rational {
 public:
  int x, y;
  rational() {}
  rational(int x1, int y1) {
    x = x1;
    y = y1;
  }
  bool operator<(const rational r) const {
    return 1ll * x * r.y < 1ll * y * r.x;
  }
};
const int LEN = 100010;
map<rational, int> m1, m2;
rational r[LEN], rr[LEN];
int rev(int x) {
  int n = 0;
  while (x != 0) {
    n = n * 10 + x % 10;
    x /= 10;
  }
  return n;
}
int main() {
  cin >> MX >> MY >> W;
  for (int i = 0; i < LEN; i++) {
    r[i].x = i;
    r[i].y = rev(i);
    rr[i].x = r[i].y;
    rr[i].y = r[i].x;
  }
  for (int i = 1; i <= MX; i++) m1[r[i]]++;
  m2[rational(1, 1)] = 1;
  int minx = LEN + 1, miny = 1;
  int curw = m1[rational(1, 1)], cur = 1;
  if (curw >= W) {
    minx = MX;
    miny = 1;
  }
  int maxw = 0;
  for (int i = MX; i >= 1; i--) {
    while (cur < MY && curw < W) {
      cur++;
      m2[rr[cur]]++;
      curw += m1[rr[cur]];
    }
    if (maxw < curw) maxw = curw;
    if (cur == MY && curw < W) break;
    if (curw >= W && ((i * cur < minx * miny) || (minx > LEN))) {
      minx = i;
      miny = cur;
    }
    curw -= m2[r[i]];
    m1[r[i]]--;
  }
  if (minx > LEN)
    cout << "-1\n";
  else
    cout << minx << " " << miny << "\n";
  exit(0);
}
