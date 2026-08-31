#include <bits/stdc++.h>
using namespace std;
const int N = 53, M = N * N, mod = 1e9 + 7;
template <typename T>
void rd(T &x) {
  int ch = getchar();
  x = 0;
  for (; ch < '0' || ch > '9'; ch = getchar())
    ;
  for (; ch >= '0' && ch <= '9'; ch = getchar()) x = x * 10 + ch - '0';
}
void qmo(int &x) { x += x >> 31 & mod; }
int n, m, id[N][N], x[M], y[M], l[M], q[N << 1], fr, re, dp[N << 1][N][2];
vector<int> a[M];
struct Node {
  int to, l;
  bool st, ed;
  Node(int _a = 0, int _b = 0, bool _c = 0, bool _d = 0)
      : to(_a), l(_b), st(_c), ed(_d) {}
};
vector<Node> pt[N];
int main() {
  rd(n);
  rd(m);
  for (int i = 1; i <= m; ++i) {
    rd(x[i]);
    rd(y[i]);
    rd(l[i]);
    a[i].resize(l[i]);
    id[x[i]][y[i]] = i;
    for (int j = 0; j < l[i]; ++j) rd(a[i][j]);
  }
  for (int i = 1, p, e; i <= m; ++i) {
    for (p = 0; p + 1 < l[i]; ++p)
      if (a[i][p] == x[i] && a[i][p + 1] == y[i]) break;
    if (!l[i])
      pt[x[i]].emplace_back(y[i], 1, 0, 0);
    else if (p + 1 < l[i]) {
      q[re = 0] = x[i];
      for (int j = p - 1; ~j; --j) q[++re] = a[i][j];
      for (fr = 0; fr < re && (e = id[q[fr + 1]][q[fr]]) && re <= (n << 1);
           ++fr)
        for (int j = l[e] - 1; ~j && re <= (n << 1); --j) q[++re] = a[e][j];
      if (fr < re) continue;
      int St = q[re], Le = re + 1;
      q[re = 0] = y[i];
      for (int j = p + 2; j < l[i]; ++j) q[++re] = a[i][j];
      for (fr = 0; fr < re && (e = id[q[fr]][q[fr + 1]]) && re <= (n << 1);
           ++fr)
        for (int j = 0; j < l[e] && re <= (n << 1); ++j) q[++re] = a[e][j];
      if (fr == re) pt[St].emplace_back(q[re], Le + re, 1, 1);
    } else if (a[i][0] == y[i]) {
      q[re = 0] = y[i];
      for (int j = 1; j < l[i]; ++j) q[++re] = a[i][j];
      for (fr = 0; fr < re && (e = id[q[fr]][q[fr + 1]]) && re <= (n << 1);
           ++fr)
        for (int j = 0; j < l[e] && re <= (n << 1); ++j) q[++re] = a[e][j];
      if (fr == re) pt[x[i]].emplace_back(q[re], re + 1, 0, 1);
    } else if (a[i][l[i] - 1] == x[i]) {
      q[re = 0] = x[i];
      for (int j = l[i] - 2; ~j; --j) q[++re] = a[i][j];
      for (fr = 0; fr < re && (e = id[q[fr + 1]][q[fr]]) && re <= (n << 1);
           ++fr)
        for (int j = l[e] - 1; ~j && re <= (n << 1); --j) q[++re] = a[e][j];
      if (fr == re) pt[q[re]].emplace_back(y[i], re + 1, 1, 0);
    }
  }
  for (int i = 1; i <= n; ++i) dp[0][i][0] = 1;
  for (int i = 0; i < (n << 1); ++i)
    for (int j = 1; j <= n; ++j)
      for (Node _ : pt[j])
        if (i + _.l <= (n << 1))
          qmo(dp[i + _.l][_.to][_.ed] += dp[i][j][!_.st] - mod);
  for (int i = 1; i <= (n << 1); ++i) {
    int ans = 0;
    for (int j = 1; j <= n; ++j) qmo(ans += dp[i][j][1] - mod);
    printf("%d\n", ans);
  }
}
