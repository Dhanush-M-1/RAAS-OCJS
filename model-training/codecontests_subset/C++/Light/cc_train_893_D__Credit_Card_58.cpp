#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 10;
int n, d, maxn, minn, ans;
int a[N];
int main() {
  cin >> n >> d;
  for (int i = 1; i <= n; i++) cin >> a[i];
  for (int i = 1; i <= n; i++) {
    if (a[i] == 0) {
      if (maxn < 0) {
        maxn = d;
        minn = 0;
        ans++;
      } else if (minn < 0)
        minn = 0;
    } else {
      minn += a[i];
      maxn = min(maxn + a[i], d);
      if (minn > d) {
        cout << -1;
        return 0;
      }
    }
  }
  cout << ans;
  return 0;
}
