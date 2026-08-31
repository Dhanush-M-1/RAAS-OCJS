#include <bits/stdc++.h>
using namespace std;
const long double PI = acos(-1);
const long double eps = 0.0000000001;
const long long INF = 0x3fffffffffffffff;
long long n, k, fa[1000005], depth[1000005], low[1000005], canback[1000005],
    cantback[1000005];
vector<long long> son[1000005];
void dfs1(long long now) {
  for (long long i = 0; i < (long long)son[now].size(); ++i) {
    depth[son[now][i]] = depth[now] + 1;
    dfs1(son[now][i]);
  }
}
void dfs2(long long now) {
  if (!son[now].size()) {
    low[now] = now;
  }
  for (long long i = 0; i < (long long)son[now].size(); ++i) {
    dfs2(son[now][i]);
    if (depth[low[now]] > depth[low[son[now][i]]]) {
      low[now] = low[son[now][i]];
    }
  }
}
void dfs3(long long now) {
  if (!son[now].size()) {
    canback[now] = 1;
  }
  for (long long i = 0; i < (long long)son[now].size(); ++i) {
    dfs3(son[now][i]);
    if (depth[low[son[now][i]]] - depth[now] <= k) {
      canback[now] += canback[son[now][i]];
    }
  }
}
void dfs4(long long now) {
  cantback[now] = canback[now];
  for (long long i = 0; i < (long long)son[now].size(); ++i) {
    dfs4(son[now][i]);
    if (depth[low[son[now][i]]] - depth[now] <= k) {
      cantback[now] = max(cantback[now], canback[now] - canback[son[now][i]] +
                                             cantback[son[now][i]]);
    } else {
      cantback[now] = max(cantback[now], canback[now] + cantback[son[now][i]]);
    }
  }
}
signed main() {
  depth[0] = INF;
  ios::sync_with_stdio(false);
  cin >> n >> k;
  for (long long i = 2; i <= n; ++i) {
    cin >> fa[i];
    son[fa[i]].push_back(i);
  }
  dfs1(1);
  dfs2(1);
  dfs3(1);
  dfs4(1);
  cout << cantback[1] << endl;
  return 0;
}
