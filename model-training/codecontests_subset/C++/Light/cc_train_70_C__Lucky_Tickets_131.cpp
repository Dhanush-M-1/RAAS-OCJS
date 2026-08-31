#include <bits/stdc++.h>
using namespace std;
int rev(int x) {
  int res = 0;
  while (x > 0) res *= 10, res += x % 10, x /= 10;
  return res;
}
int gcd(int a, int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
pair<int, int> pt(int a, int b) {
  int g = gcd(a, b);
  return make_pair(a / g, b / g);
}
int main() {
  long long res = 1000000000000LL, rx, ry;
  int maxx, maxy, w, cur = 0;
  cin >> maxx >> maxy >> w;
  map<pair<int, int>, int> mx, my;
  for (int _n((maxx)), i(1); i <= _n; i++) mx[pt(i, rev(i))]++;
  for (int _n((maxy)), i(1); i <= _n; i++) my[pt(rev(i), i)]++;
  for (map<pair<int, int>, int>::iterator it = mx.begin(); it != mx.end(); it++)
    cur += it->second * my[it->first];
  int cx = maxx, cy = maxy;
  if (cur < w) {
    cout << -1 << endl;
    return 0;
  }
  rx = cx;
  ry = cy;
  res = (long long)(cx)*cy;
  while (cx >= 1) {
    pair<int, int> cd = pt(cx, rev(cx));
    if (cur - my[cd] >= w) {
      mx[cd]--;
      cur -= my[cd];
      cx--;
    } else
      break;
  }
  while (cx <= maxx && cy >= 1) {
    if (res > (long long)(cx)*cy) {
      res = (long long)(cx)*cy;
      rx = cx;
      ry = cy;
    }
    if (cy == 1 || cx == maxx) break;
    pair<int, int> a = pt(cx + 1, rev(cx + 1));
    pair<int, int> b = pt(rev(cy), cy);
    if (cur - mx[b] >= w) {
      my[b]--;
      cur -= mx[b];
      cy--;
    } else {
      mx[a]++;
      cur += my[a];
      cx++;
    }
  }
  cout << rx << " " << ry << endl;
  return 0;
}
