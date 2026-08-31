#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, k, a;
  long long ans = 1e18;
  scanf("%d%d%d", &n, &m, &k);
  vector<int> lst(n + 1, 0);
  vector<int> sz(k + 1);
  for (int i = 0; i < m; i++) {
    scanf("%d", &a);
    lst[a] = -1;
  }
  if (lst[0] == -1) {
    cout << -1;
    return 0;
  }
  for (int i = 1; i <= k; i++) {
    scanf("%d", &sz[i]);
  }
  for (int i = 0; i <= n; i++) {
    if (lst[i] != -1)
      lst[i] = i;
    else
      lst[i] = lst[i - 1];
  }
  for (int i = 1; i <= k; i++) {
    int j = 0;
    long long s = 0;
    bool f = true;
    while (j < n) {
      if (j + i >= n || lst[j + i] != j) {
        s++;
        if (j + i <= n)
          j = lst[j + i];
        else
          j = n;
      } else {
        s = 1e18;
        f = false;
        break;
      }
    }
    if (f) s = s * sz[i];
    ans = min(ans, s);
  }
  if (ans == 1e18)
    cout << -1;
  else
    cout << ans;
  return 0;
}
