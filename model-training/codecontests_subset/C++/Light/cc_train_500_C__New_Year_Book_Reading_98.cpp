#include <bits/stdc++.h>
using namespace std;
long long int n, m, wt[505], ord[505], a[1005];
vector<long long int> v, v1, v2;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long int i, j, k;
  cin >> n >> m;
  for (i = 1; i <= n; i++) {
    cin >> wt[i];
  }
  j = 1;
  for (i = 1; i <= m; i++) {
    cin >> a[i];
    if (ord[a[i]] == 0) {
      v.push_back(a[i]);
      ord[a[i]] = 1;
    }
  }
  long long int ans = 0, p, q;
  for (i = 1; i <= m; i++) {
    v1 = v;
    j = a[i];
    for (k = 0; k < v1.size(); k++) {
      if (v1[k] == j) break;
      ans += wt[v1[k]];
    }
    v2.clear();
    v2.push_back(a[i]);
    for (p = 0; p < k; p++) v2.push_back(v1[p]);
    for (p = k + 1; p < v1.size(); p++) v2.push_back(v1[p]);
    v = v2;
  }
  cout << ans << "\n";
  return 0;
}
