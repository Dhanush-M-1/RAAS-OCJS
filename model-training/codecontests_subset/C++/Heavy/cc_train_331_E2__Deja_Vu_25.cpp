#include <bits/stdc++.h>
using namespace std;
const int maxn = 55;
const int mod = 1e9 + 7;
int n, m, ql, qr;
int que[maxn * 2];
int cntl[maxn][maxn][maxn * 2], cntr[maxn][maxn][maxn * 2],
    cntm[maxn][maxn][maxn * 2], cnte[maxn][maxn];
int dpe[maxn][maxn * 2], dpl[maxn][maxn * 2], dpr[maxn][maxn * 2],
    dpm[maxn][maxn * 2];
bool ext[maxn][maxn];
vector<int> val[maxn][maxn];
pair<int, int> expandL(int s) {
  int cnt = 0;
  while (ql < qr) {
    int x = que[ql++];
    cnt++;
    if (cnt > 2 * n || !ext[x][s]) return make_pair(-1, 2 * n + 1);
    for (int i = int(val[x][s].size()) - 1; i >= 0; i--)
      que[qr++] = val[x][s][i];
    s = x;
  }
  return make_pair(s, cnt);
}
pair<int, int> expandR(int s) {
  int cnt = 0;
  while (ql < qr) {
    int x = que[ql++];
    cnt++;
    if (cnt > 2 * n || !ext[s][x]) return make_pair(-1, 2 * n + 1);
    for (int i = 0; i < int(val[s][x].size()); i++) que[qr++] = val[s][x][i];
    s = x;
  }
  return make_pair(s, cnt);
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 0; i < m; i++) {
    int x, y, k, v;
    scanf("%d%d%d", &x, &y, &k);
    x--;
    y--;
    ext[x][y] = true;
    while (k--) {
      scanf("%d", &v);
      v--;
      val[x][y].push_back(v);
    }
    if (val[x][y].empty()) cnte[x][y]++;
  }
  for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
      if (ext[i][j] && int(val[i][j].size()) <= 2 * n) {
        for (int p = 0; p + 1 < int(val[i][j].size()); p++)
          if (val[i][j][p] == i && val[i][j][p + 1] == j) {
            ql = qr = 0;
            for (int q = p - 1; q >= 0; q--) que[qr++] = val[i][j][q];
            pair<int, int> vl = expandL(i);
            ql = qr = 0;
            for (int q = p + 2; q < int(val[i][j].size()); q++)
              que[qr++] = val[i][j][q];
            pair<int, int> vr = expandR(j);
            if (vl.second + vr.second + 1 <= 2 * n)
              cntm[vl.first][vr.first][vl.second + vr.second + 1]++;
          }
      }
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++)
      if (ext[i][j] && !val[i][j].empty() && val[i][j][0] == j) {
        ql = qr = 0;
        for (int p = 1; p < int(val[i][j].size()); p++)
          que[qr++] = val[i][j][p];
        pair<int, int> vr = expandR(j);
        if (vr.second + 1 <= 2 * n) cntr[i][vr.first][vr.second + 1]++;
      }
    for (int j = 0; j < n; j++)
      if (ext[j][i] && !val[j][i].empty() && val[j][i].back() == j) {
        ql = qr = 0;
        for (int p = int(val[j][i].size()) - 2; p >= 0; p--)
          que[qr++] = val[j][i][p];
        pair<int, int> vl = expandL(j);
        if (vl.second + 1 <= 2 * n) cntl[vl.first][i][vl.second + 1]++;
      }
  }
  for (int t = 0; t <= 2 * n; t++) {
    if (t == 0) {
      for (int i = 0; i < n; i++) dpl[i][t] = 1;
    } else {
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          dpe[i][t] = (dpe[i][t] + 1LL * dpr[j][t - 1] * cnte[j][i]) % mod;
      for (int i = 0; i < n; i++) {
        dpl[i][t] = dpe[i][t];
        for (int j = 0; j < n; j++)
          for (int k = 1; k <= t; k++)
            dpl[i][t] = (dpl[i][t] + 1LL * dpl[j][t - k] * cntl[j][i][k]) % mod;
      }
      for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
          for (int k = 1; k <= t; k++)
            dpm[i][t] = (dpm[i][t] + 1LL * dpl[j][t - k] * cntm[j][i][k]) % mod;
      for (int i = 0; i < n; i++) {
        dpr[i][t] = dpm[i][t];
        for (int j = 0; j < n; j++)
          for (int k = 1; k <= t; k++)
            dpr[i][t] = (dpr[i][t] + 1LL * dpr[j][t - k] * cntr[j][i][k]) % mod;
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) ans = (ans + dpr[i][t]) % mod;
    if (t) printf("%d\n", ans);
  }
  return 0;
}
