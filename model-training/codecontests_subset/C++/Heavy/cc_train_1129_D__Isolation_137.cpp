#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector")
#pragma GCC optimize("unroll-loops")
using namespace std;
const int block = 320, nax = 100005, mod = 998244353;
inline int add(int x, int y) { return (x += y) < mod ? x : x - mod; }
inline int sub(int x, int y) { return (x -= y) >= 0 ? x : x + mod; }
int b[block], q[block][block << 1 | 1], n, k, d[nax], dp[nax], a[nax], lst[nax],
    lst2[nax];
void add(int pos) {
  int id = (pos - 1) / block;
  for (int i = block; i <= 2 * block; ++i)
    q[id][i] = add(q[id][i], dp[pos - 1]);
}
void upd(int pos, int sgn) {
  int id = (pos - 1) / block;
  b[id] += sgn;
  for (int i = pos; i > id * block; --i) {
    if (sgn == 1) q[id][d[i] + block] = sub(q[id][d[i] + block], dp[i - 1]);
    d[i] += sgn;
    if (sgn == -2)
      q[id][d[i] + block] = add(q[id][d[i] + block], dp[i - 1]),
                   q[id][d[i] + block + 1] =
                       add(q[id][d[i] + block + 1], dp[i - 1]);
  }
}
int get(int pos) {
  int ret = 0, id = (pos - 1) / block, sum = b[id];
  for (int i = pos; i > id * block; --i)
    if (d[i] <= k) ret = add(ret, dp[i - 1]);
  while (--id >= 0) {
    if (abs(sum - k) <= block)
      ret = add(ret, q[id][k - sum + block]);
    else if (sum < k)
      ret = add(ret, q[id][block << 1]);
    sum += b[id];
  }
  return ret;
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  dp[0] = 1;
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) {
    cin >> a[i], add(i), upd(i, 1);
    if (lst[a[i]]) upd(lst[a[i]], -2);
    if (lst2[a[i]]) upd(lst2[a[i]], 1);
    dp[i] = get(i), lst2[a[i]] = lst[a[i]], lst[a[i]] = i;
  }
  cout << dp[n] << '\n';
}
