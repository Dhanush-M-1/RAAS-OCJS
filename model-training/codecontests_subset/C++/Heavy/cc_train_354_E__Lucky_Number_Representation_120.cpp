#include <bits/stdc++.h>
#pragma comment(linker, "/stack:256000000")
using namespace std;
const int N = 729;
string s;
int dp[22][10], prid[22][10], prmod[22][10], num[800][6];
long long ans[6];
int sum[50];
int go(int pos, int mod) {
  if (dp[pos][mod] != -1) {
    return dp[pos][mod];
  }
  if (pos == 20) {
    if (mod == 0)
      return dp[pos][mod] = 1;
    else
      return dp[pos][mod] = 0;
  }
  for (int i = 0; i < (50); i++) {
    if (sum[i] == -1) continue;
    if ((mod + i) % 10 == s[pos] - '0') {
      if (go(pos + 1, (mod + i) / 10) == 1) {
        prid[pos + 1][(mod + i) / 10] = i;
        prmod[pos + 1][(mod + i) / 10] = mod;
        return dp[pos][mod] = 1;
      }
    }
  }
  return dp[pos][mod] = 0;
}
int main() {
  memset(sum, -1, sizeof(sum));
  for (int i = 0; i < (N); i++) {
    int x = i, t = 243;
    for (int j = 0; j < (6); j++) {
      num[i][j] = x / t;
      x %= t;
      t /= 3;
    }
    int tmp = 0;
    for (int j = 0; j < (6); j++) {
      if (num[i][j] == 1)
        num[i][j] = 4;
      else if (num[i][j] == 2)
        num[i][j] = 7;
      tmp += num[i][j];
    }
    if (sum[tmp] == -1) sum[tmp] = i;
  }
  int tst;
  scanf("%d", &tst);
  for (int _ = 0; _ < (tst); _++) {
    cin >> s;
    while ((int)(s).size() < 20) s = "0" + s;
    reverse((s).begin(), (s).end());
    memset(dp, -1, sizeof(dp));
    memset(prid, -1, sizeof(prid));
    memset(prmod, -1, sizeof(prmod));
    if (go(0, 0)) {
      memset(ans, 0, sizeof(ans));
      int pos = 20, mod = 0;
      while (pos > 0) {
        int id = sum[prid[pos][mod]];
        for (int i = 0; i < (6); i++) {
          ans[i] *= 10;
          ans[i] += num[id][i];
        }
        mod = prmod[pos][mod];
        --pos;
      }
      for (int i = 0; i < (6); i++) {
        cout << ans[i] << " ";
      }
      cout << "\n";
    } else {
      cout << -1 << "\n";
    }
  }
  return 0;
}
