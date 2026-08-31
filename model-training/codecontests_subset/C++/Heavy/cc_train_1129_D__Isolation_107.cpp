#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
const long long BIG = 1446803456761533460;
const int Big = 336860180;
stringstream sss;
const int maxn = 100010;
const int SQ = 400;
const int maxnsq = maxn / SQ + 10;
int n, k;
int A[maxn], P[maxn];
map<int, int> lst;
int block[maxnsq][maxn * 2];
int lazy[maxnsq], val[maxn];
int dp[maxn];
int sum = 0;
int& blk(int x, int y) { return block[x / SQ][y + maxn]; }
void inc(int l, int r) {
  while (l < r) {
    if (l % SQ == 0 && l + SQ <= r) {
      sum = ((sum) + (MOD - blk(l, k - lazy[l / SQ]))) % MOD;
      ++lazy[l / SQ];
      l += SQ;
    } else {
      if (val[l] + lazy[l / SQ] == k) sum = ((sum) + (MOD - dp[l])) % MOD;
      blk(l, val[l]) = ((blk(l, val[l])) + (MOD - dp[l])) % MOD;
      ++val[l];
      blk(l, val[l]) = ((blk(l, val[l])) + (dp[l])) % MOD;
      ++l;
    }
  }
}
void dec(int l, int r) {
  while (l < r) {
    if (l % SQ == 0 && l + SQ <= r) {
      --lazy[l / SQ];
      sum = ((sum) + (blk(l, k - lazy[l / SQ]))) % MOD;
      l += SQ;
    } else {
      blk(l, val[l]) = ((blk(l, val[l])) + (MOD - dp[l])) % MOD;
      --val[l];
      blk(l, val[l]) = ((blk(l, val[l])) + (dp[l])) % MOD;
      if (val[l] + lazy[l / SQ] == k) sum = ((sum) + (dp[l])) % MOD;
      ++l;
    }
  }
}
void MAIN() {
  cin >> n >> k;
  for (int i = (0); i < (n); ++i) {
    cin >> A[i];
    P[i + 1] = lst.count(A[i]) ? lst[A[i]] : 0;
    lst[A[i]] = i + 1;
  }
  dp[0] = 1;
  sum = 1;
  blk(0, 0) = 1;
  for (int i = (1); i < (n + 1); ++i) {
    inc(P[i], i);
    dec(P[P[i]], P[i]);
    dp[i] = sum;
    sum = ((sum) + (dp[i])) % MOD;
    val[i] = -lazy[i / SQ];
    blk(i, val[i]) = ((blk(i, val[i])) + (dp[i])) % MOD;
  }
  cout << dp[n] << '\n';
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  cout << fixed << setprecision(10);
  sss << R"(
5 2
1 1 2 1 3
    )";
  MAIN();
  return 0;
}
