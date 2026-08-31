#include <bits/stdc++.h>
using namespace std;
vector<int> v[500001];
int num[300005];
int main() {
  int n, m, uu, vv, ans = 0;
  scanf("%d%d", &n, &m);
  int a[n + 1];
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= m; i++) {
    scanf("%d%d", &uu, &vv);
    v[vv].push_back(uu);
  }
  for (int i = 0; i < v[a[n]].size(); i++) num[v[a[n]][i]]++;
  for (int i = n - 1; i >= 1; i--) {
    if (num[a[i]] == n - i - ans)
      ans++;
    else {
      for (int j = 0; j < v[a[i]].size(); j++) {
        num[v[a[i]][j]]++;
      }
    }
  }
  printf("%d\n", ans);
  return 0;
}
