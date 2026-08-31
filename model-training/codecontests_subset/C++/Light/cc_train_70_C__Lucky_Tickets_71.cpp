#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000 * 100 + 100;
map<double, set<long long> > mp;
long long n, maxx, maxy, x, y, w, rev[maxn], d[maxn], cnt, ansx, ansy,
    l = (1ll << 50);
void check(long long x, long long y) {
  if (x * y < l) {
    l = x * y;
    ansx = x;
    ansy = y;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin >> maxx >> maxy >> w;
  for (int i = 1; i < maxn; i++) {
    int x = i, y = 0;
    while (x) {
      y *= 10;
      y += x % 10;
      x /= 10;
    }
    double z = double(i) / double(y);
    rev[i] = y;
    mp[z].insert(i);
    d[i] = mp[z].size();
  }
  y = maxy;
  for (x = 1; x <= maxx; x++) {
    double z = double(rev[x]) / double(x);
    if (mp[z].size()) {
      set<long long>::iterator it = mp[z].upper_bound(y);
      if (it == mp[z].end())
        cnt += mp[z].size();
      else {
        int c = *mp[z].upper_bound(y);
        cnt += d[c] - 1;
      }
    }
    if (cnt < w) continue;
    while (cnt >= w) {
      check(x, y);
      double z = double(rev[y]) / double(y);
      if (mp[z].size()) {
        set<long long>::iterator it = mp[z].upper_bound(x);
        if (it == mp[z].end())
          cnt -= mp[z].size();
        else {
          int c = *mp[z].upper_bound(x);
          cnt -= (d[c] - 1);
        }
      }
      y--;
    }
  }
  if (!ansx && !ansy) {
    cout << -1 << endl;
    return 0;
  }
  cout << ansx << " " << ansy << endl;
  return 0;
}
