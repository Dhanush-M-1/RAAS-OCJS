#include <bits/stdc++.h>
using namespace std;
int n, m;
int k;
bool debug = false;
long long xa, xb, xc, ya, yb, yc;
long long X[5], Y[5];
long long d[4][2][2] = {
    {{1, 0}, {0, 1}}, {{-1, 0}, {0, -1}}, {{0, 1}, {-1, 0}}, {{0, -1}, {1, 0}}};
bool dd(long long x2, long long y2) {
  long long dx = xa - x2, dy = ya - y2;
  long long t1 = -(xc * dx + yc * dy) / (xc * xc + yc * yc);
  long long t2;
  if (yc != 0) {
    t2 = -(dx + xc * t1) / yc;
  } else {
    t2 = (dy + yc * t1) / xc;
  }
  return (xa + xc * t1 + yc * t2 == x2 && ya + yc * t1 - xc * t2 == y2);
}
int main() {
  cin >> xa >> ya >> xb >> yb >> xc >> yc;
  for (int i = 0; i < 4; i++) {
    X[i] = d[i][0][0] * xb + d[i][0][1] * yb;
    Y[i] = d[i][1][0] * xb + d[i][1][1] * yb;
  }
  if (xc == 0 && yc == 0) {
    for (int i = 0; i < 4; i++) {
      if (xa == X[i] && ya == Y[i]) {
        puts("YES");
        return 0;
      }
    }
  } else {
    for (int i = 0; i < 4; i++)
      if (dd(X[i], Y[i])) {
        puts("YES");
        return 0;
      }
  }
  puts("NO");
  return 0;
}
