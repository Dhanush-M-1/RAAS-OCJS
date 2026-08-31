#include <bits/stdc++.h>
using namespace std;
#pragma GCC optimize("O3")
int main() {
  ios_base::sync_with_stdio(false), cin.tie(NULL), cout.tie(NULL);
  int n, ans;
  cin >> n;
  int p[n], h[n], l, r;
  for (int i = 0; i < (n); ++i) {
    cin >> p[i] >> h[i];
  }
  if (n == 1) {
    ans = 1;
  } else {
    ans = 2;
    for (int i = (1); i <= (n - 2); ++i) {
      l = p[i] - p[i - 1];
      r = p[i + 1] - p[i];
      if (l > h[i]) {
        ++ans;
      } else if (r > h[i]) {
        p[i] += h[i];
        ++ans;
      }
    }
  }
  cout << ans << endl;
  return 0;
}
