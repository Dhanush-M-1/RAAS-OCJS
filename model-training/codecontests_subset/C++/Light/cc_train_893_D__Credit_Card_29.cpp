#include <bits/stdc++.h>
using namespace std;
int gcd(int f, int s) {
  if (s == 0)
    return f;
  else
    return gcd(s, f % s);
}
int const N = 200005;
long long const mod = 1000 * 1000 * 1000 + 7;
int main() {
  int from = 0, to = 0, ans = 0;
  int a, mx;
  cin >> a >> mx;
  for (int i = 0; i < a; i++) {
    int t;
    cin >> t;
    if (t == 0) {
      if (to < 0) {
        from = 0;
        to = mx;
        ans++;
      } else if (from < 0) {
        from = 0;
      }
    } else {
      if (t > 0) {
        if (from + t > mx) {
          printf("-1\n");
          return 0;
        }
        from += t;
        to = min(mx, to + t);
      } else {
        from += t;
        to += t;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
