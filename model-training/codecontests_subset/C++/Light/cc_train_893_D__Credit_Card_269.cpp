#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
int n, d, mx[100005], a[100005], pre[100005], ans, cur, f;
int main() {
  cin >> n >> d;
  for (int i = 0; i < n; i++) cin >> a[i];
  pre[0] = a[0];
  for (int i = 1; i < n; i++) pre[i] = pre[i - 1] + a[i];
  mx[n - 1] = pre[n - 1];
  for (int i = n - 2; i > -1; i--) mx[i] = max(mx[i + 1], pre[i]);
  for (int i = 0; i < n; i++) {
    if (pre[i] > d) f = 1;
    if (!a[i] && pre[i] + cur < 0) {
      cur = d - mx[i];
      ans++;
      if (pre[i] + cur < 0) f = 1;
    }
  }
  if (f)
    cout << "-1\n";
  else
    cout << ans << '\n';
  return 0;
}
