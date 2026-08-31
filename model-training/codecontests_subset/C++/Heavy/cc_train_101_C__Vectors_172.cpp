#include <bits/stdc++.h>
#pragma GCC optimize("O2")
#pragma comment(linker, "/STACK:16777216")
using namespace std;
const int N = 1001;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long x, y, dx, dy, xx, yy;
bool ok(long long tx, long long ty) {
  long long d = gcd(abs(dx), abs(dy));
  if (d == 0) {
    return tx == 0 && ty == 0;
  }
  if (tx % d || ty % d) return false;
  long long temp = dx * dx + dy * dy;
  if (temp == 0) {
    return tx == ty;
  } else {
    long long sum1 = tx * dx + dy * ty;
    long long sum2 = dy * tx - dx * ty;
    return sum1 % temp == 0 && sum2 % temp == 0;
  }
}
bool judge() {
  if (ok(x - xx, y - yy) || ok(x + xx, y + yy) || ok(x + yy, y - xx) ||
      ok(x - yy, y + xx))
    return true;
  return false;
}
int main() {
  while (cin >> x >> y >> xx >> yy >> dx >> dy) {
    puts(judge() ? "YES" : "NO");
  }
}
