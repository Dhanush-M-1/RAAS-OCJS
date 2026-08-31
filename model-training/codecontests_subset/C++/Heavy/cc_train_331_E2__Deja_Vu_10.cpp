#include <bits/stdc++.h>
using namespace std;
const int mo = 1e9 + 7;
const int N = 55;
int f[2][2 * N][N];
int g[2][2][2 * N][N][N];
int e[N][N], st[N * N], ed[N * N], n, m;
int v1[2 * N][N][N], v2[2 * N][N][N];
vector<int> seq[N * N];
pair<int, int> walk(vector<int> &vec, int x, int flg) {
  int p = 0;
  for (; p + 1 <= vec.size();) {
    int y = vec[p], ed = e[x][y];
    if (!ed || vec.size() > 2 * n || ((ed > m) ^ flg))
      return pair<int, int>(23333, -1);
    for (auto j : seq[ed]) vec.push_back(j);
    x = y;
    ++p;
  }
  return pair<int, int>(vec.size(), x);
}
void work(bool flg) {
  memset(v1, 0, sizeof(v1));
  memset(v2, 0, sizeof(v2));
  for (int i = (int)(1); i <= (int)(2 * m); i++)
    if ((i <= m) ^ flg)
      for (int j = (int)(0); j <= (int)(seq[i].size() - 1); j++)
        if (seq[i][j] == st[i]) {
          int sz = seq[i].size();
          vector<int> t1, t2;
          for (int k = (int)(j - 1); k >= (int)(0); k--)
            t1.push_back(seq[i][k]);
          pair<int, int> res1 = walk(t1, st[i], flg ^ 1);
          if (res1.first > 2 * n) continue;
          if (j + 1 == sz)
            ++v2[res1.first + 1][res1.second][ed[i]];
          else if (seq[i][j + 1] == ed[i]) {
            for (int k = (int)(j + 2); k <= (int)(sz - 1); k++)
              t2.push_back(seq[i][k]);
            pair<int, int> res2 = walk(t2, ed[i], flg);
            if (res2.first + res1.first + 1 <= 2 * n)
              ++v1[res1.first + res2.first + 1][res1.second][res2.second];
          }
        }
}
void UPD(int &x, int y) { (x += y) >= mo ? x -= mo : 233; }
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (int)(1); i <= (int)(m); i++) {
    int x, y, cnt, v;
    scanf("%d%d%d", &x, &y, &cnt);
    e[x][y] = i;
    e[y][x] = i + m;
    st[i] = ed[i + m] = x;
    ed[i] = st[i + m] = y;
    for (int j = (int)(1); j <= (int)(cnt); j++) {
      scanf("%d", &v);
      seq[i].push_back(v);
    }
    seq[i + m] = seq[i];
    reverse(seq[i + m].begin(), seq[i + m].end());
    if (!cnt) ++g[0][0][1][x][y];
  }
  work(0);
  memcpy(g[1][1], v1, sizeof(v1));
  memcpy(g[1][0], v2, sizeof(v2));
  work(1);
  for (int l = (int)(1); l <= (int)(n * 2); l++)
    for (int x = (int)(1); x <= (int)(n); x++)
      for (int y = (int)(1); y <= (int)(n); y++) g[0][1][l][x][y] = v2[l][y][x];
  for (int l = (int)(1); l <= (int)(n * 2); l++)
    for (int x = (int)(1); x <= (int)(n); x++)
      for (int y = (int)(1); y <= (int)(n); y++)
        for (int fl = (int)(0); fl <= (int)(1); fl++)
          UPD(f[fl][l][y], g[1][fl][l][x][y]);
  for (int l = (int)(1); l <= (int)(n * 2); l++) {
    int ans = 0;
    for (int i = (int)(1); i <= (int)(n); i++) {
      UPD(ans, f[1][l][i]);
      for (int la = (int)(0); la <= (int)(1); la++)
        for (int no = (int)(0); no <= (int)(1); no++)
          for (int j = (int)(0); j <= (int)(2 * n - l); j++)
            for (int k = (int)(1); k <= (int)(n); k++)
              UPD(f[no][l + j][k],
                  1ll * f[la][l][i] * g[la ^ 1][no][j][i][k] % mo);
    }
    printf("%d\n", ans);
  }
}
