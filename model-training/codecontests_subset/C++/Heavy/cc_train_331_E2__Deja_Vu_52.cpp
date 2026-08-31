#include <bits/stdc++.h>
using namespace std;
struct path {
  int u, u1, v, v1, l;
  inline bool operator==(const path& x) const {
    return u == x.u && u1 == x.u1 && v == x.v && v1 == x.v1 && l == x.l;
  }
} p[3000 << 2];
struct edge {
  bool is;
  int s[55], st;
} is[55][55];
bool pd;
int head[500], sta[500], T[500], L, R, top, n, m, pt, dp[500][500][2];
inline bool extend(int);
int main() {
  scanf("%d%d", &n, &m);
  for (int i(1), j, u, v; i <= m; ++i) {
    scanf("%d%d", &u, &v);
    scanf("%d", &is[u][v].st);
    is[u][v].is = 1;
    for (j = 1; j <= is[u][v].st; ++j) scanf("%d", &is[u][v].s[j]);
  }
  for (int i(1), j, k; i <= n; ++i)
    for (j = 1; j <= n; ++j) {
      if (!is[i][j].is) continue;
      if (is[i][j].s[is[i][j].st] == i) {
        top = 0, sta[++top] = j, sta[++top] = i;
        L = 1, R = is[i][j].st - 1, memcpy(T + 1, is[i][j].s + 1, R << 2);
        reverse(T + 1, T + R + 1);
        if (extend(-1)) p[++pt] = {sta[top], 1, j, 1, top - 1};
      }
      for (k = 1; k <= is[i][j].st; ++k)
        if (is[i][j].s[k] == i) break;
      if (k < is[i][j].st && is[i][j].s[k + 1] == j) {
        top = 0, sta[++top] = i, L = 1, R = k - 1;
        memcpy(T + 1, is[i][j].s + 1, R << 2), reverse(T + 1, T + R + 1);
        if (extend(-1)) {
          reverse(sta + 1, sta + top + 1);
          sta[++top] = j, L = 1, R = is[i][j].st - k - 1;
          memcpy(T + 1, is[i][j].s + k + 2, R << 2);
          if (extend(1))
            if (top - 1 <= n << 1) {
              p[++pt] = {sta[1], 1, sta[top], 0, top - 1};
            }
        }
      }
      if (!is[i][j].st) p[++pt] = {i, 0, j, 1, 1};
      if (is[i][j].s[1] == j) {
        top = 0, sta[++top] = i, sta[++top] = j;
        L = 1, R = is[i][j].st - 1, memcpy(T + 1, is[i][j].s + 2, R << 2);
        if (extend(1)) p[++pt] = {i, 0, sta[top], 0, top - 1};
      }
    }
  for (int i(1); i <= n; ++i) dp[0][i][1] = 1;
  for (int i(0), j; i < n << 1; ++i)
    for (j = 1; j <= pt; ++j)
      if (i + p[j].l <= n << 1)
        (dp[i + p[j].l][p[j].v][p[j].v1] += dp[i][p[j].u][p[j].u1]) %=
            1000000007;
  for (int i(1), j; i <= n << 1; ++i) {
    int ans(0);
    for (j = 1; j <= n; ++j) (ans += dp[i][j][0]) %= 1000000007;
    printf("%d\n", (ans + 1000000007) % 1000000007);
  }
  return 0;
}
inline bool extend(int d) {
  while (L <= R) {
    edge& i1(~d ? is[sta[top]][T[L]] : is[T[L]][sta[top]]);
    if (!i1.is) return false;
    sta[++top] = T[L++];
    for (int j(~d ? 1 : i1.st); j && j <= i1.st; j += d) T[++R] = i1.s[j];
    if (top - 1 > n << 1 || R - 1 > n << 1) return false;
  }
  return true;
}
