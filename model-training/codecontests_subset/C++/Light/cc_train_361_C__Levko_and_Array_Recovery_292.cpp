#include <bits/stdc++.h>
using namespace std;
int a[5010], b[5010], t[5010], l[5010], r[5010], m[5010];
int n, k;
int main() {
  cin >> n >> k;
  fill(b, b + (n + 5), 1e8);
  for (int i = 1; i <= k; i++) {
    cin >> t[i] >> l[i] >> r[i] >> m[i];
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += m[i];
    else
      for (int j = l[i]; j <= r[i]; j++) b[j] = min(b[j], m[i] - a[j]);
  }
  fill(a, a + (n + 5), 0);
  for (int i = 1; i <= k; i++) {
    int M = -1e9;
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; j++) a[j] += m[i];
    else {
      for (int j = l[i]; j <= r[i]; j++) M = max(M, a[j] + b[j]);
      if (M != m[i]) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; i++) cout << b[i] << " ";
  return 0;
}
