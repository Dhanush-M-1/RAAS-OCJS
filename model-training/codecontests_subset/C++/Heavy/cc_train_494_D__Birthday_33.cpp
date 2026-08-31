#include <bits/stdc++.h>
using namespace std;
typedef long long arr[100005];
arr cnt, d, sum, bot, top, T, L;
int P[100005][21];
vector<pair<int, int> > a[100005];
int n;
void DFS1(int u, int pre) {
  cnt[u] = 1;
  for (int i = 0; i < a[u].size(); i++) {
    int v = a[u][i].first;
    long long gt = a[u][i].second;
    if (v == pre) continue;
    d[v] = (d[u] + gt) % 1000000007;
    T[v] = T[u] + 1;
    DFS1(v, u);
    P[v][0] = u;
    cnt[u] += cnt[v];
    sum[u] = (sum[u] + sum[v] + gt * cnt[v] % 1000000007) % 1000000007;
    bot[u] = (bot[u] + bot[v] + (gt * gt % 1000000007 * cnt[v] % 1000000007) +
              2ll * sum[v] * gt % 1000000007) %
             1000000007;
  }
}
void DFS2(int u, int pre) {
  for (int i = 0; i < a[u].size(); i++) {
    int v = a[u][i].first;
    long long gt = a[u][i].second;
    if (v == pre) continue;
    L[v] = (L[u] + (sum[u] - sum[v] - gt * cnt[v] % 1000000007) +
            gt * (n - cnt[v]) % 1000000007) %
           1000000007;
    top[v] = (top[u] + 2ll * L[u] * gt % 1000000007 +
              gt * gt % 1000000007 * (n - cnt[u]) % 1000000007) %
             1000000007;
    long long W =
        (bot[u] - bot[v] - (gt * gt % 1000000007 * cnt[v] % 1000000007) -
         2ll * sum[v] * gt % 1000000007) %
        1000000007;
    top[v] =
        (top[v] + W + gt * gt % 1000000007 * (cnt[u] - cnt[v]) % 1000000007 +
         2ll * gt * (sum[u] - sum[v] - gt * cnt[v] % 1000000007) % 1000000007) %
        1000000007;
    DFS2(v, u);
  }
}
void Build_LCA() {
  for (int j = 1; j < 20; j++)
    for (int i = 1; i <= n; i++) P[i][j] = P[P[i][j - 1]][j - 1];
}
int LCA(int u, int v) {
  if (T[u] < T[v]) swap(u, v);
  int hi = T[u] - T[v];
  for (int i = 0; i < 20; i++)
    if (((hi >> i) & 1)) u = P[u][i];
  if (u == v) return u;
  for (int i = 19; i >= 0; i--)
    if (P[u][i] != P[v][i]) {
      u = P[u][i];
      v = P[v][i];
    }
  return P[u][0];
}
int main() {
  cin >> n;
  int u, v, gt, q;
  for (int i = 1; i <= n - 1; i++) {
    cin >> u >> v >> gt;
    a[u].push_back(make_pair(v, gt));
    a[v].push_back(make_pair(u, gt));
  }
  DFS1(1, 0);
  DFS2(1, 0);
  Build_LCA();
  cin >> q;
  while (q--) {
    cin >> u >> v;
    int Par = LCA(u, v);
    long long R1 = (bot[u] + top[u]) % 1000000007;
    long long kc = (d[u] + d[v] - 2ll * d[Par]) % 1000000007;
    if (Par == v) {
      long long R2 = (top[v] + 2ll * kc * L[v] % 1000000007 +
                      kc * kc % 1000000007 * (n - cnt[v]) % 1000000007) %
                     1000000007;
      long long R3 = R1 - R2;
      cout << (2ll * R3 - R1 + 3ll * 1000000007) % 1000000007 << endl;
    } else {
      long long R2 = (bot[v] + 2ll * kc * sum[v] % 1000000007 +
                      kc * kc % 1000000007 * (cnt[v]) % 1000000007) %
                     1000000007;
      cout << (2ll * R2 - R1 + 3ll * 1000000007) % 1000000007 << endl;
    }
  }
}
