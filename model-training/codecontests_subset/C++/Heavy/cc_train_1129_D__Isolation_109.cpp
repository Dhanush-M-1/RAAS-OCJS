#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector")
#pragma GCC optimize("unroll-loops")
using namespace std;
const int BLK = 320;
const int MXN = 1e5 + 5;
const int MOD = 998244353;
int add(int x, int y) { return (x += y) < MOD ? x : x - MOD; }
int sub(int x, int y) { return (x -= y) >= 00 ? x : x + MOD; }
int b[BLK];
int q[BLK][2 * BLK + 5];
int n, k;
int d[MXN];
int dp[MXN];
int arr[MXN];
int last1[MXN];
int last2[MXN];
void add(int pos) {
  int id = (pos - 1) / BLK;
  for (int i = BLK; i <= 2 * BLK; ++i) {
    q[id][i] = add(q[id][i], dp[pos - 1]);
  }
}
void update(int pos, int sgn) {
  int id = (pos - 1) / BLK;
  b[id] += sgn;
  for (int i = pos; i > id * BLK; --i) {
    if (sgn == +1) q[id][d[i] + BLK] = sub(q[id][d[i] + BLK], dp[i - 1]);
    d[i] += sgn;
    if (sgn == -2) {
      q[id][d[i] + BLK] = add(q[id][d[i] + BLK], dp[i - 1]),
                   q[id][d[i] + BLK + 1] =
                       add(q[id][d[i] + BLK + 1], dp[i - 1]);
    }
  }
}
int get(int pos) {
  int ret = 0;
  int id = (pos - 1) / BLK;
  for (int i = pos; i > id * BLK; --i) {
    if (d[i] <= k) ret = add(ret, dp[i - 1]);
  }
  int sum = b[id];
  while (--id >= 0) {
    if (abs(sum - k) <= BLK) {
      ret = add(ret, q[id][k - sum + BLK]);
    } else if (sum < k) {
      ret = add(ret, q[id][BLK + BLK]);
    }
    sum += b[id];
  }
  return ret;
}
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  dp[0] = 1;
  cin >> n >> k;
  for (int i = 1; i <= n; ++i) {
    cin >> arr[i];
    add(i);
    update(i, 1);
    if (last1[arr[i]]) update(last1[arr[i]], -2);
    if (last2[arr[i]]) update(last2[arr[i]], +1);
    dp[i] = get(i);
    last2[arr[i]] = last1[arr[i]];
    last1[arr[i]] = i;
  }
  cout << dp[n] << '\n';
}
