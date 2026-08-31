#include <bits/stdc++.h>
using namespace std;
const int MX_N = 1e5 + 5;
const int MX_K = 1e5 + 5;
const int MX_A = MX_N;
const int MOD = 998244353;
const int B = 300;
int N, K, A[MX_N];
int pos[MX_A], prv[MX_N], dp[MX_N];
struct Bucket {
  int pre[B], cnt[B], offset;
  Bucket() {
    for (int i = (0); i <= (B - 1); ++i) {
      pre[i] = 0;
      cnt[i] = 0;
    }
    offset = 0;
  }
  void rebuild(int b) {
    int mn = MX_N;
    int j = b * B;
    for (int i = (0); i <= (B - 1); ++i) {
      pre[i] = 0;
      mn = min(mn, cnt[i]);
    }
    offset += mn;
    for (int i = (0); i <= (B - 1); ++i) {
      cnt[i] -= mn;
      pre[cnt[i]] += dp[i + j];
      if (pre[cnt[i]] >= MOD) pre[cnt[i]] -= MOD;
    }
    for (int i = (1); i <= (B - 1); ++i) {
      pre[i] += pre[i - 1];
      if (pre[i] >= MOD) pre[i] -= MOD;
    }
  }
  int sum() {
    if (offset > K) return 0;
    return pre[min(B - 1, K - offset)];
  }
  int get(int b, int i) {
    if (offset + cnt[i] > K) return 0;
    return dp[b * B + i];
  }
} bucket[MX_N / B + 1];
void update(int x, int y, int v) {
  if (x > y) return;
  int bx = x / B, jx = x % B, by = y / B, jy = y % B;
  if (bx == by) {
    for (int i = (jx); i <= (jy); ++i) {
      bucket[bx].cnt[i] += v;
    }
    bucket[bx].rebuild(bx);
  } else {
    for (int i = (jx); i <= (B - 1); ++i) {
      bucket[bx].cnt[i] += v;
    }
    bucket[bx].rebuild(bx);
    for (int i = (bx + 1); i <= (by - 1); ++i) {
      bucket[i].offset += v;
    }
    for (int i = (0); i <= (jy); ++i) {
      bucket[by].cnt[i] += v;
    }
    bucket[by].rebuild(by);
  }
}
int query(int i) {
  int b = i / B, j = i % B;
  int sum = 0;
  for (int k = (0); k <= (b - 1); ++k) {
    sum += bucket[k].sum();
    if (sum >= MOD) sum -= MOD;
  }
  for (int k = (0); k <= (j); ++k) {
    sum += bucket[b].get(b, k);
    if (sum >= MOD) sum -= MOD;
  }
  return sum;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> N >> K;
  for (int i = (1); i <= (N); ++i) {
    cin >> A[i];
    prv[i] = pos[A[i]];
    pos[A[i]] = i;
  }
  dp[0] = 1;
  bucket[0].rebuild(0);
  for (int i = (1); i <= (N); ++i) {
    update(prv[prv[i]], prv[i] - 1, -1);
    update(prv[i], i - 1, 1);
    dp[i] = query(i - 1);
    int b = i / B;
    bucket[b].rebuild(b);
  }
  cout << dp[N];
}
