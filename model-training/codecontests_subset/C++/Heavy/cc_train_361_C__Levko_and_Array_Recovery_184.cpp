#include <bits/stdc++.h>
using namespace std;
long long com[5005], lft[5005], rgt[5005], val[5005], ar[5005], ans[5005];
bool chk[5005];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie();
  int n, q;
  cin >> n >> q;
  for (int i = 1; i <= n; i++) ans[i] = (long long)1e18;
  for (int i = 1; i <= q; i++) {
    cin >> com[i] >> lft[i] >> rgt[i] >> val[i];
  }
  for (int i = q; i >= 1; i--) {
    if (com[i] == 1) {
      for (long long j = lft[i]; j <= rgt[i]; j++) {
        ans[j] -= val[i];
      }
    } else {
      for (long long j = lft[i]; j <= rgt[i]; j++) {
        ans[j] = min(ans[j], val[i]);
      }
    }
  }
  for (int i = 1; i <= n; i++) ar[i] = min(ans[i], (long long)1000000000);
  for (int i = 1; i <= q; i++) {
    if (com[i] == 1) {
      for (long long j = lft[i]; j <= rgt[i]; j++) ar[j] += val[i];
    } else {
      long long mx = (long long)-(1e18);
      for (long long j = lft[i]; j <= rgt[i]; j++) mx = max(mx, ar[j]);
      if (mx != val[i]) {
        cout << "NO" << endl;
        return 0;
      }
    }
  }
  cout << "YES" << endl;
  cout << min(ans[1], (long long)1e9);
  for (int i = 2; i <= n; i++) cout << " " << min(ans[i], (long long)1e9);
  cout << endl;
  return 0;
}
