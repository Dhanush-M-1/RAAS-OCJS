#include <bits/stdc++.h>
using namespace std;
int xc, yc;
long long gcd(long long x, long long y) {
  while (x > 0 && y > 0)
    if (x > y)
      x %= y;
    else
      y %= x;
  return x + y;
}
bool chk(long long x, long long y, long long xa, long long ya, long long xb,
         long long yb) {
  if (xa == 0 && ya == 0) return (xc == x && yc == y);
  x = xc - x;
  y = yc - y;
  long long t1 = xb * ya - yb * xa;
  long long t2 = x * ya - y * xa;
  if (t1 == 0) return t2 == 0 && (x % gcd(xa, xb) == 0);
  if (t2 % t1 != 0) return false;
  long long b = t2 / t1;
  if (xa != 0) return ((x - b * xb) % xa) == 0;
  return ((y - b * yb) % ya) == 0;
}
bool chk(pair<int, int> x, pair<int, int> a, pair<int, int> b) {
  return chk(x.first, x.second, a.first, a.second, b.first, b.second);
}
int main(int argc, char** argv) {
  int xa, ya;
  int xb, yb;
  cin >> xa >> ya >> xc >> yc >> xb >> yb;
  vector<pair<int, int> > v1, v2, v3;
  v1.push_back(make_pair(xa, ya));
  v1.push_back(make_pair(-xa, -ya));
  v1.push_back(make_pair(-ya, xa));
  v1.push_back(make_pair(ya, -xa));
  v2.push_back(make_pair(xb, yb));
  v2.push_back(make_pair(-xb, -yb));
  v3.push_back(make_pair(-yb, xb));
  v3.push_back(make_pair(yb, -xb));
  for (int i = 0; i < 4; ++i)
    for (int j = 0; j < 2; ++j)
      for (int k = 0; k < 2; ++k)
        if (chk(v1[i], v2[j], v3[k])) {
          cout << "YES" << endl;
          return 0;
        }
  cout << "NO" << endl;
  return 0;
}
