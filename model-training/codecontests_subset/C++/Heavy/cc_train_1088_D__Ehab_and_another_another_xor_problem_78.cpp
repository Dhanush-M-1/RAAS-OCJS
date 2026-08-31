#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const int iinf = 1 << 30;
const long long linf = 2e18;
const int MOD = 1000000007;
void print(int x) {
  cout << x << endl;
  exit(0);
}
void PRINT(string x) {
  cout << x << endl;
  exit(0);
}
void douout(double x) { printf("%lf\n", x + 0.0000000001); }
int Q(int x, int y) {
  printf("? %d %d\n", x, y);
  fflush(stdout);
  cin >> x;
  return x;
}
signed main() {
  int a = 0, b = 0, t = Q(0, 0), x, y, i = 1 << 30;
  while (i >>= 1) {
    x = Q(a | i, b);
    y = Q(a, b | i);
    if (x == y)
      (t > 0 ? a : b) |= i, t = x;
    else if (!~x)
      a |= i, b |= i;
  }
  printf("! %d %d", a, b);
}
