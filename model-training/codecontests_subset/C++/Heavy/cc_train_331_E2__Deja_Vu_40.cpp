#include <bits/stdc++.h>
using namespace std;
int n, m, i, x, y, k, a, q, h, l, r, j, p, ans, s[400], dp[51][51][110],
    dp1[51][51][110], tail1[51][51][110], tail2[51][51][110], dp3[51][110],
    sss[51][51][110], dpp[51][110], dpp1[51][110];
vector<int> ve[51][51];
bool ok1, ok2, Find, ok[51][51];
void get(int x, int y, int z) {
  q = 105;
  h = 104;
  for (int i = 1; i < ve[x][y].size(); i++) {
    s[++h] = ve[x][y][i];
    if (i == z) l = h, r = h + 1;
  }
  while (q != l && h - q + 1 <= 2 * n + 1) {
    if (ve[s[l - 1]][s[l]].size() == 0) return;
    for (int i = ve[s[l - 1]][s[l]].size() - 1; i; i--)
      s[--q] = ve[s[l - 1]][s[l]][i];
    l--;
  }
  if (h - q + 1 > 2 * n + 1) return;
  while (h != r && h - q + 1 <= 2 * n) {
    if (ve[s[r]][s[r + 1]].size() == 0) return;
    for (int i = 1; i < ve[s[r]][s[r + 1]].size(); i++)
      s[++h] = ve[s[r]][s[r + 1]][i];
    r++;
  }
  if (h - q + 1 > 2 * n + 1) return;
  dp[s[q]][s[h]][h - q + 1]++;
}
void Findtail1(int x, int y) {
  q = 105;
  h = 104;
  for (int i = 1; i < ve[x][y].size(); i++) s[++h] = ve[x][y][i];
  l = r = h;
  while (q != l && h - q + 1 <= 2 * n + 1) {
    if (ve[s[l - 1]][s[l]].size() == 0) return;
    for (int i = ve[s[l - 1]][s[l]].size() - 1; i; i--)
      s[--q] = ve[s[l - 1]][s[l]][i];
    l--;
  }
  if (h - q + 1 > 2 * n + 1) return;
  tail1[s[q]][y][h - q + 1]++;
}
void Findtail2(int x, int y) {
  q = 105;
  h = 104;
  for (int i = 1; i < ve[x][y].size(); i++) s[++h] = ve[x][y][i];
  l = r = q;
  while (h != r && h - q + 1 <= 2 * n + 1) {
    if (ve[s[r]][s[r + 1]].size() == 0) return;
    for (int i = 1; i < ve[s[r]][s[r + 1]].size(); i++)
      s[++h] = ve[s[r]][s[r + 1]][i];
    r++;
  }
  if (h - q + 1 > 2 * n + 1) return;
  tail2[x][s[h]][h - q + 1]++;
}
inline void add(int &x, int y) {
  x += y;
  if (x >= 1000000007) x -= 1000000007;
}
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d", &x, &y, &k);
    ok1 = false;
    ok2 = false;
    ve[x][y].push_back(0);
    a = 0;
    while (k--) {
      if (a != x)
        ok1 = false;
      else
        ok1 = true;
      scanf("%d", &a);
      if (a == y && ok1) ok2 = true;
      ve[x][y].push_back(a);
    }
    if (ok2) ok[x][y] = true;
  }
  for (i = 1; i <= n; i++)
    for (j = 1; j <= n; j++) {
      if (ok[i][j])
        for (p = 1; p < ve[i][j].size() - 1; p++)
          if (ve[i][j][p] == i && ve[i][j][p + 1] == j) get(i, j, p);
      if (ve[i][j].size() > 1 && ve[i][j][ve[i][j].size() - 1] == i)
        Findtail1(i, j);
      if (ve[i][j].size() > 1 && ve[i][j][1] == j) Findtail2(i, j);
    }
  for (l = 1; l <= 2 * n + 1; l++) {
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        for (p = 1; p < l; p++)
          if (tail1[i][j][p])
            for (q = 1; q <= n; q++)
              dp[i][q][l] =
                  (dp[i][q][l] + 1LL * dp[j][q][l - p] * tail1[i][j][p]) %
                  1000000007;
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        for (p = 1; p < l; p++)
          if (tail2[i][j][p])
            for (q = 1; q <= n; q++) {
              dp1[q][j][l] =
                  (dp1[q][j][l] + 1LL * dp[q][i][l - p] * tail2[i][j][p]) %
                  1000000007;
              dp1[q][j][l] =
                  (dp1[q][j][l] + 1LL * dp1[q][i][l - p] * tail2[i][j][p]) %
                  1000000007;
            }
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        for (p = 1; p < l; p++)
          if (sss[i][j][p]) {
            int ss = 0;
            add(ss, dpp[j][l - p]);
            add(ss, dpp1[j][l - p]);
            add(ss, dp3[j][l - p]);
            add(dp3[i][l], 1LL * ss * sss[i][j][p] % 1000000007);
          }
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        for (p = 1; p <= n; p++)
          if (ve[j][p].size() == 1) {
            sss[i][p][l] = (sss[i][p][l] + dp[i][j][l]) % 1000000007;
            sss[i][p][l] = (sss[i][p][l] + dp1[i][j][l]) % 1000000007;
          }
    for (ans = 0, i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        ans = (((ans + dp[i][j][l]) % 1000000007 + dp1[i][j][l]) % 1000000007) %
              1000000007;
    for (i = 1; i <= n; i++) add(ans, dp3[i][l]);
    for (i = 1; i <= n; i++)
      for (j = 1; j <= n; j++)
        add(dpp[i][l], dp[i][j][l]), add(dpp1[i][l], dp1[i][j][l]);
    if (l > 1) printf("%d\n", ans);
  }
}
