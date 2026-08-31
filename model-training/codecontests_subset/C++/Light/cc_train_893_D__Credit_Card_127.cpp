#include <bits/stdc++.h>
using namespace std;
int main() {
  ios ::sync_with_stdio(0);
  int n, d;
  cin >> n >> d;
  int ans = 0;
  int mx = 0, nw = 0, lst = -1;
  for (int i = 0; i < n; ++i) {
    int a;
    cin >> a;
    if (a == 0) {
      if (!~lst || mx > d - max(0, -nw)) {
        if (nw < 0) ++ans, lst = i;
        nw += max(0, -nw);
        mx = 0;
      } else {
        mx += max(0, -nw);
        nw += max(0, -nw);
      }
    } else {
      mx = max(mx, nw += a);
    }
    if (mx > d) {
      cout << -1 << endl;
      return 0;
    }
  }
  cout << ans << endl;
  return 0;
}
