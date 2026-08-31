#include <bits/stdc++.h>
using namespace std;
int w[50000], da[50000], done[50000], pos[50000], indx[50000];
int main() {
  int n, m;
  int i;
  while (cin >> n >> m) {
    for (i = 1; i <= n; i++) cin >> w[i];
    for (i = 1; i <= m; i++) cin >> da[i];
    memset(done, 0, sizeof(done));
    for (int st = 1, sum = 0; st <= m && sum < n; st++) {
      if (!done[da[st]]) {
        done[da[st]] = 1;
        pos[sum + 1] = da[st];
        indx[da[st]] = sum + 1;
        sum++;
      }
    }
    int ans = 0;
    for (i = 1; i <= m; i++) {
      int k = indx[da[i]];
      pos[0] = pos[k];
      for (int j = k - 1; j >= 1; j--) {
        ans += w[pos[j]];
        pos[j + 1] = pos[j];
        indx[pos[j + 1]] = j + 1;
      }
      pos[1] = pos[0];
      indx[pos[1]] = 1;
    }
    cout << ans << endl;
  }
  return 0;
}
