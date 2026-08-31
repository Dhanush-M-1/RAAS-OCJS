#include <bits/stdc++.h>
using namespace std;
int maxx, maxy, w, x, y, c, ansx, ansy;
map<double, int> p, q;
double t;
int rev(int x) {
  int ans = 0;
  while (x > 0) {
    ans = ans * 10 + (x % 10);
    x /= 10;
  }
  return ans;
}
int main() {
  cin >> maxx >> maxy >> w;
  for (int i = 1; i <= maxx; i++) {
    t = i * 1.0 / rev(i);
    p[t]++;
  }
  x = maxx;
  while (y <= maxy && x >= 1) {
    if (c >= w) {
      if (ansx * ansy > x * y || !ansx) {
        ansx = x;
        ansy = y;
      }
      t = (x * 1.0) / rev(x);
      c -= q[t];
      p[t]--;
      x--;
      continue;
    }
    if (y >= maxy) {
      y = maxy + 1;
      continue;
    }
    if (c < w && y < maxy) {
      y++;
      t = (rev(y) * 1.0) / y;
      c += p[t];
      q[t]++;
    }
  }
  if (!ansx)
    cout << -1 << endl;
  else
    cout << ansx << " " << ansy << endl;
}
