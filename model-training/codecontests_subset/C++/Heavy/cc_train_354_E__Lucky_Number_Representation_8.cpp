#include <bits/stdc++.h>
using namespace std;
const int D[3] = {0, 4, 7};
int trail[7];
int val[80], pn;
int des[80][7];
bool dp[20][50];
int trav[20][50], from[20][50];
long long ans[7];
void dfs(int cur, int sum, int bound) {
  if (cur == 6) {
    for (int i = 0; i < 6; i++) des[pn][i] = trail[i];
    val[pn++] = sum;
    return;
  }
  for (; bound < 3; bound++) {
    trail[cur] = D[bound];
    dfs(cur + 1, sum + D[bound], bound);
  }
}
int main() {
  pn = 0;
  dfs(0, 0, 0);
  int t;
  cin >> t;
  while (t--) {
    long long d;
    cin >> d;
    int pos = 0;
    memset(dp, 0, sizeof(dp));
    dp[0][0] = true;
    while (d) {
      int toGet = (int)(d % 10);
      for (int i = 0; i < 50; i++) {
        if (!dp[pos][i]) continue;
        for (int j = 0; j < pn; j++) {
          int nxt = val[j] + i;
          if (nxt % 10 != toGet) continue;
          dp[pos + 1][nxt / 10] = true;
          trav[pos + 1][nxt / 10] = j;
          from[pos + 1][nxt / 10] = i;
        }
      }
      pos++;
      d /= 10;
    }
    if (!dp[pos][0])
      cout << "-1" << endl;
    else {
      memset(ans, 0, sizeof(ans));
      int cur = 0;
      for (int i = pos; i; i--) {
        int kk = trav[i][cur];
        for (int j = 0; j < 6; j++) ans[j] = ans[j] * 10 + des[kk][j];
        cur = from[i][cur];
      }
      cout << ans[0];
      for (int i = 1; i < 6; i++) cout << " " << ans[i];
      cout << endl;
    }
  }
  return 0;
}
