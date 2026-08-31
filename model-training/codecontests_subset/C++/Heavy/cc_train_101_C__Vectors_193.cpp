#include <bits/stdc++.h>
using namespace std;
long long x1, y8477234, x2, y2, x3, y3, ix3, iy3;
int i;
long long sqr(long long x) { return (x * x); }
bool check(long long xx, long long yy) {
  long long aa = xx * x3 + yy * y3;
  long long bb = xx * ix3 + yy * iy3;
  long long cc = sqr(x3) + sqr(y3);
  if (cc == 0) return ((xx == 0) && (yy == 0));
  return ((aa % cc == 0) && (bb % cc == 0));
}
int main() {
  cin >> x1 >> y8477234 >> x2 >> y2 >> x3 >> y3;
  ix3 = -y3;
  iy3 = x3;
  for (i = 0; i < 4; i++) {
    swap(x1, y8477234);
    x1 = -x1;
    if (check(x2 - x1, y2 - y8477234)) break;
  }
  if (i < 4)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
