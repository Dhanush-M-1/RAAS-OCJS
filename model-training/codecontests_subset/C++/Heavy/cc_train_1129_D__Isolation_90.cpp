#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const long long MOD = 998244353;
long long add(long long a, long long b) {
  a += b;
  if (a >= MOD) a -= MOD;
  return a;
}
long long sub(long long a, long long b) {
  a -= b;
  if (a < 0) a += MOD;
  return a;
}
long long mult(long long a, long long b) { return (a * b) % MOD; }
const int BQSZ = 325;
int buq_fin[BQSZ], buq_off[BQSZ], bqsz;
int off[N], A[N], buq[BQSZ][2 * BQSZ + 1], pre[N], dp[N];
vector<int> g[N];
int n, k;
void upd_buq(int bid) {
  memset((buq[bid]), (0), sizeof(buq[bid]));
  int cur = 0;
  for (int x = (bid * BQSZ), qwerty = (buq_fin[bid] + 1); x < qwerty; x++) {
    cur += pre[x];
    buq[bid][cur + BQSZ] = add(buq[bid][cur + BQSZ], dp[x + 1]);
  }
}
void upd(int i, int v) {
  int bid = i / BQSZ;
  pre[i] += v;
  upd_buq(bid);
  for (int x = (1), qwerty = (2 * BQSZ + 1); x < qwerty; x++)
    buq[bid][x] = add(buq[bid][x - 1], buq[bid][x]);
  for (int x = (bid + 1), qwerty = (bqsz); x < qwerty; x++) buq_off[x] += v;
}
long long get() {
  long long ans = 0;
  for (int x = (0), qwerty = (bqsz); x < qwerty; x++) {
    int kk = min(2 * BQSZ, k + BQSZ - buq_off[x]);
    if (kk >= 0) ans = add(ans, buq[x][kk]);
  }
  return ans;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int x = (0), qwerty = (n); x < qwerty; x++)
    cin >> A[x], buq_fin[x / BQSZ] = x;
  bqsz = (n - 1) / BQSZ + 1;
  dp[n] = 1;
  upd_buq(bqsz - 1);
  for (int x = n - 1; x >= 0; x--) {
    upd(x, 1);
    if (int((g[A[x]]).size()) >= 1) upd(g[A[x]].back(), -2);
    if (int((g[A[x]]).size()) >= 2) upd(g[A[x]][int((g[A[x]]).size()) - 2], 1);
    dp[x] = get();
    g[A[x]].push_back(x);
    if (x) upd_buq((x - 1) / BQSZ);
  }
  cout << dp[0] << "\n";
}
