#include <bits/stdc++.h>
using namespace std;
int n, d, i, a, ans, l, r;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0), cout.tie(0);
  cin >> n >> d;
  l = r = 0;
  for (i = 1; i <= n; i++) {
    cin >> a;
    if (a) {
      l += a;
      r += a;
      if (l > d) {
        return puts("-1");
      }
      if (r > d) r = d;
    } else {
      if (l < 0) l = 0;
      if (r < 0) r = d, ans++;
    }
  }
  return !(cout << ans);
}
