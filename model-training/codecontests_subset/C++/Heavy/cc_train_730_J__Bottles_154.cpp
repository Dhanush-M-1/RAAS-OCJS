#include <bits/stdc++.h>
using namespace std;
int n, k, dp[105][10005];
struct node {
  int now, lim;
};
node nod[105];
bool nodecmp(node x, node y) { return x.lim > y.lim; }
using namespace std;
int main() {
  cin >> n;
  int water = 0, maxx = 0;
  for (int i = 1; i <= n; i++) {
    cin >> nod[i].now;
    water += nod[i].now;
  }
  for (int i = 1; i <= n; i++) {
    cin >> nod[i].lim;
    maxx += nod[i].lim;
  }
  sort(nod + 1, nod + n + 1, nodecmp);
  int k = 0;
  int temp = water;
  while (temp > 0) {
    k++;
    temp -= nod[k].lim;
  }
  cout << k << " ";
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int x = maxx; x >= nod[i].lim; x--) {
      for (int j = 1; j <= k; j++) {
        if (dp[j - 1][x - nod[i].lim] != -1) {
          dp[j][x] = max(dp[j][x], dp[j - 1][x - nod[i].lim] + nod[i].now);
        }
      }
    }
  }
  int ans = 0;
  for (int i = water; i <= maxx; i++) {
    ans = max(ans, dp[k][i]);
  }
  cout << water - ans << endl;
}
