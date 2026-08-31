#include <bits/stdc++.h>
using namespace std;
const long long maxn = (long long)2e6 + 5;
const int nnn = 1048590;
const int inf = numeric_limits<int>::max() - 1;
long long dx[] = {0, 1, 0, -1};
long long dy[] = {1, 0, -1, 0};
long long dxx[] = {0, 1, 0, -1, 1, 1, -1, -1};
long long dyy[] = {1, 0, -1, 0, 1, -1, 1, -1};
long long A = 3, B = 1;
long long ask(long long x, long long y, long long s) {
  cout << "? " << x << ' ' << y << '\n';
  fflush(stdout);
  long long e;
  cin >> e;
  fflush(stdout);
  return e;
}
void solve() {
  long long a = 0, b = 0;
  long long big = ask(0, 0, 0);
  for (long long i = 29; i >= 0; i--) {
    long long s = (1LL << i);
    long long p1, p2;
    p1 = ask(a | s, b, s);
    p2 = ask(a, b | s, s);
    if (p1 == p2) {
      if (big == 1)
        a |= s;
      else
        b |= s;
      big = p1;
    } else {
      if (p1 == -1) a |= s, b |= s;
    }
  }
  cout << "! " << a << ' ' << b << '\n';
  fflush(stdout);
  return;
}
int main() {
  long long T;
  T = 1;
  long long CT = 0;
  while (T--) {
    solve();
  }
  return 0;
}
