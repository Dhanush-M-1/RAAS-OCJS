#include <bits/stdc++.h>
using namespace std;
int n, k, p, to[210000], pre[210000], ans, inv[2100000], inv2;
vector<int> V;
int Pow(int x, int y) {
  int ans = 1;
  for (int i = 1; i <= y; i *= 2, x = 1LL * x * x % p)
    if (i & y) ans = 1LL * ans * x % p;
  return ans;
}
void dfs(int l, int r, int h) {
  if (l < r) {
    if (h <= 1) {
      ans = (ans + 1LL * (r - l + 1) * (r - l) / 2 % p * Pow(2, p - 2)) % p;
      V.push_back(r - l + 1);
    } else {
      int m = (l + r) / 2;
      dfs(l, m, h - 1);
      dfs(m + 1, r, h - 1);
    }
  } else {
    V.push_back(1);
  }
}
int main() {
  scanf("%d%d%d", &n, &k, &p);
  dfs(1, n, k);
  map<int, int> M;
  for (auto y : V) {
    M[y] += 1;
  }
  inv2 = Pow(2, p - 2);
  for (int i = 1; i <= n; i++) inv[i] = Pow(i, p - 2);
  for (auto it : M)
    for (auto it2 : M) {
      int fac;
      if (it.first == it2.first)
        fac = 1LL * it.second * (it.second - 1) % p;
      else
        fac = 1LL * it.second * it2.second % p;
      int tmp = 0;
      for (int l = 2; l <= it.first + it2.first; l++) {
        int low = max(l - it2.first, 1) - 1;
        int hi = min(l - 1, it.first) - 1;
        tmp = (tmp +
               1LL * (low + hi) * (hi - low + 1) / 2 % p * inv[l] % p * inv2) %
              p;
      }
      ans = (ans + 1LL * tmp * fac) % p;
    }
  printf("%d\n", ans);
}
