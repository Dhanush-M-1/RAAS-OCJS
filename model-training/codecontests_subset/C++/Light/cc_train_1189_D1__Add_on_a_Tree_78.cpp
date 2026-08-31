#include <bits/stdc++.h>
using namespace std;
int dirx[] = {1, -1, 0, 0}, diry[] = {0, 0, 1, -1};
long long bigmod(long long x, long long p) {
  long long res = 1;
  while (p) {
    if (p & 1) res = (res * x) % 998244353;
    x = (x * x) % 998244353;
    p >>= 1;
  }
  return res;
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  int n, m;
  cin >> n;
  m = n - 1;
  vector<int> cnt(n);
  while (m--) {
    int u, v;
    cin >> u >> v;
    cnt[u - 1]++;
    cnt[v - 1]++;
  }
  int i = 0;
  for (; i < n; i++)
    if (cnt[i] == 2) break;
  cout << (i < n ? "NO" : "YES\n");
  return 0;
}
