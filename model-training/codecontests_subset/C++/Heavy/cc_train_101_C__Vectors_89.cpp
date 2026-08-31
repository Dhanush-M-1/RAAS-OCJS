#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:65777216")
using namespace std;
int x[3], y[3];
long long det(long long a, long long b, long long c, long long d) {
  return a * d - b * c;
}
int main() {
  for (int i(0); i < (3); i++) cin >> x[i] >> y[i];
  for (int i(0); i < (4); i++) {
    swap(x[0], y[0]);
    y[0] = -y[0];
    int a = x[1] - x[0];
    int b = y[1] - y[0];
    long long d = det(x[2], y[2], y[2], -x[2]);
    long long d1 = det(a, y[2], b, -x[2]);
    long long d2 = det(x[2], a, y[2], b);
    if (d == 0) {
      if (a == 0 && b == 0) {
        puts("YES");
        return 0;
      }
    } else {
      if (d < 0) d = -d;
      if (d1 % d == 0 && d2 % d == 0) {
        puts("YES");
        return 0;
      }
    }
  }
  puts("NO");
  return 0;
}
