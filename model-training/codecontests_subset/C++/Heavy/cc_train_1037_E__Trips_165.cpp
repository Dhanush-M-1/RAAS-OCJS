#include <bits/stdc++.h>
using namespace std;
const int MAXN = 200005;
int d[MAXN];
int a[MAXN], b[MAXN], f[MAXN], ans[MAXN];
int n, m, k;
int q[MAXN], fr, re;
vector<int> E[MAXN];
set<long long> S;
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", a + i, b + i);
    d[a[i]]++, d[b[i]]++;
    E[a[i]].push_back(b[i]);
    E[b[i]].push_back(a[i]);
  }
  for (int i = 1; i <= n; ++i) {
    if (d[i] < k) {
      f[i] = 1;
      q[re++] = i;
    }
  }
  ans[m] = n;
  while (fr < re) {
    int u = q[fr++];
    ans[m]--;
    for (int i = 0; i < E[u].size(); ++i) {
      int v = E[u][i];
      if (f[v]) continue;
      if (--d[v] < k) {
        q[re++] = v;
        f[v] = 1;
      }
    }
  }
  for (int i = m - 1; i >= 0; --i) {
    ans[i] = ans[i + 1];
    int u1 = a[i], u2 = b[i];
    if (f[u1] || f[u2]) continue;
    S.insert((long long)u1 * n + u2);
    S.insert((long long)u2 * n + u1);
    d[u1]--, d[u2]--;
    if (d[u1] < k) {
      fr = re = 0;
      q[re++] = u1;
      f[u1] = 1;
      while (fr < re) {
        int u = q[fr++];
        ans[i]--;
        for (int i = 0; i < E[u].size(); ++i) {
          int v = E[u][i];
          if (f[v] || S.find((long long)u * n + v) != S.end()) continue;
          if (--d[v] < k) {
            f[v] = 1;
            q[re++] = v;
          }
        }
      }
    }
    if (!f[u2] && d[u2] < k) {
      fr = re = 0;
      q[re++] = u2;
      f[u2] = 1;
      while (fr < re) {
        int u = q[fr++];
        ans[i]--;
        for (int i = 0; i < E[u].size(); ++i) {
          int v = E[u][i];
          if (f[v] || S.find((long long)u * n + v) != S.end()) continue;
          if (--d[v] < k) {
            f[v] = 1;
            q[re++] = v;
          }
        }
      }
    }
  }
  for (int i = 1; i <= m; ++i) printf("%d\n", ans[i]);
  return 0;
}
