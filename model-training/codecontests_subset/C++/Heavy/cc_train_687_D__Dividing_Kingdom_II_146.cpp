#include <bits/stdc++.h>
using namespace std;
const int N = 1010;
const int M = N * N / 2;
const int K = 10000;
struct A {
  int ans;
  vector<pair<int, pair<int, int> > > vec;
  A() { ans = -1; }
} ans;
vector<pair<int, pair<int, int> > > vec;
int n, m, q;
int fa[N], dp[N];
int F(int k) {
  if (fa[k] == k) {
    return k;
  } else {
    int res = F(fa[k]);
    dp[k] ^= dp[fa[k]];
    fa[k] = res;
    return res;
  }
}
void solve() {
  ans = A();
  for (int i = 1; i <= n; i++) fa[i] = i, dp[i] = 0;
  for (int i = 0; i <= (int)vec.size() - 1; i++) {
    int u = vec[i].second.first;
    int v = vec[i].second.second;
    int w = vec[i].first;
    if (F(u) != F(v)) {
      dp[fa[u]] = 1 ^ dp[u] ^ dp[v];
      fa[fa[u]] = fa[v];
      ans.vec.push_back(vec[i]);
    } else if (1 ^ dp[u] ^ dp[v]) {
      ans.ans = w;
      return;
    }
  }
}
A operator+(const A& x, const A& y) {
  vec.resize(x.vec.size() + y.vec.size());
  merge(x.vec.begin(), x.vec.end(), y.vec.begin(), y.vec.end(), vec.begin(),
        greater<pair<int, pair<int, int> > >());
  solve();
  ans.ans = max(ans.ans, max(x.ans, y.ans));
  return ans;
}
int x[M], y[M], z[M];
A init_(int l, int r) {
  l = max(l, 1);
  r = min(r, m);
  vec.clear();
  for (int i = l; i <= r; i++)
    vec.push_back(pair<int, pair<int, int> >(z[i], pair<int, int>(x[i], y[i])));
  sort(vec.begin(), vec.end(), greater<pair<int, pair<int, int> > >());
  solve();
  return ans;
}
A sum[M / K][M / K];
int main() {
  cin >> n >> m >> q;
  for (int i = 1; i <= m; i++) scanf("%d%d%d", x + i, y + i, z + i);
  int size = m / K;
  for (int i = 0; i <= size; i++) sum[i][i] = init_(i * K, (i + 1) * K - 1);
  for (int i = 0; i <= size; i++)
    for (int j = i + 1; j <= size; j++) sum[i][j] = sum[i][j - 1] + sum[j][j];
  while (q--) {
    int l, r;
    scanf("%d%d", &l, &r);
    int L = l / K;
    int R = r / K;
    if (L == R) {
      A res = init_(l, r);
      printf("%d\n", res.ans);
    } else {
      A res_L = init_(l, (L + 1) * K - 1);
      A res_R = init_(R * K, r);
      A res = res_L + res_R + sum[L + 1][R - 1];
      printf("%d\n", res.ans);
    }
  }
  return 0;
}
