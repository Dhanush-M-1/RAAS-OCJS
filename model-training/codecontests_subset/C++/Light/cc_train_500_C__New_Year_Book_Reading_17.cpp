#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int wg[502], mr[1003], n, i, j, m, sm = 0, vis[502];
  cin >> n >> m;
  for (i = 1; i <= n; i++) cin >> wg[i];
  for (i = 1; i <= m; i++) cin >> mr[i];
  for (i = 1; i <= m; i++) {
    for (j = 1; j <= n; j++) vis[j] = 0;
    for (j = i - 1; j >= 1 && mr[j] != mr[i]; j--) {
      if (vis[mr[j]] == 0) {
        vis[mr[j]] = 1;
        sm += wg[mr[j]];
      }
    }
  }
  cout << sm;
  return 0;
}
