#include <bits/stdc++.h>
using namespace std;
map<int, int> mp;
int n, k, q;
void dfs(int l, int r, int dep) {
  if (dep <= 1 || l == r) {
    mp[r - l + 1]++;
    return;
  }
  int mid = (l + r) >> 1;
  dfs(l, mid, dep - 1);
  dfs(mid + 1, r, dep - 1);
}
int ADD(int x, int y) { return (x += y) >= q ? x - q : x; }
int SUB(int x, int y) { return (x -= y) < 0 ? x + q : x; }
int MUL(int x, int y) { return (long long)x * y % q; }
int HALF(int x) { return x & 1 ? (x + q >> 1) : (x >> 1); }
const int N = 100010;
int inv[N], invs[N];
int calc(int x, int y) {
  int ret = MUL(x, y);
  for (int i = 1; i <= x; ++i) {
    ret = SUB(ret, MUL(SUB(invs[i + y], invs[i]), 2));
  }
  return ret;
}
int main() {
  scanf("%d%d%d", &n, &k, &q);
  dfs(1, n, k);
  inv[0] = inv[1] = 1;
  invs[0] = invs[1] = 1;
  for (int i = 2; i <= n; ++i) {
    inv[i] = MUL(inv[q % i], q - q / i);
    invs[i] = ADD(invs[i - 1], inv[i]);
  }
  int ans = 0;
  for (auto i : mp)
    for (auto j : mp)
      if (i.first <= j.first) {
        if (i.first == j.first) {
          int ret = calc(i.first, i.first);
          ans = ADD(ans, MUL(ret, HALF(MUL(i.second, i.second - 1))));
          ans = ADD(ans, MUL(i.second, HALF(MUL(i.first, i.first - 1))));
        } else {
          int ret = calc(i.first, j.first);
          ans = ADD(ans, MUL(ret, MUL(i.second, j.second)));
        }
      }
  cout << HALF(ans);
}
