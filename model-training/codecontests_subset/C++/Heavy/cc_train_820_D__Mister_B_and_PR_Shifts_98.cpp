#include <bits/stdc++.h>
using namespace std;
inline long long input() {
  int32_t x;
  scanf("%d", &x);
  return x;
}
const long long maxn = 2e6 + 1000;
const long long mod = 1e9 + 7;
struct old {
  long long sum_[maxn], a[maxn];
  long long cnt[maxn], add[maxn];
  long long Q = 0;
  long long L[maxn], R[maxn];
  inline long long Sum(long long n) { return (n * (n + 1) / 2); }
  inline long long ok(long long x) { return x; }
  inline long long answer(long long l, long long r) {
    long long res = ok(sum_[r] - (l ? sum_[l - 1] : 0));
    for (long long pt = 0; pt < Q; pt++) {
      pair<long long, long long> eshterak = {max(l, L[pt]), min(r, R[pt])};
      if (eshterak.first > eshterak.second) continue;
      long long sz = eshterak.second - eshterak.first + 1;
      long long start = eshterak.first - L[pt] + 1;
      res = ok(ok(Sum(start + sz - 1) - Sum(start - 1)) + res);
    }
    return res;
  }
  inline void clear() {
    for (long long i = 1; i < maxn; i++) {
      cnt[i] = ok(cnt[i] + cnt[i - 1]);
      add[i] = ok(add[i] + add[i - 1] + cnt[i - 1]);
    }
    memset(cnt, 0, sizeof cnt);
    for (long long i = 0; i < maxn; i++) {
      add[i] = ok(add[i] + (i ? add[i - 1] : 0));
      sum_[i] = ok(sum_[i] + add[i]);
    }
    memset(add, 0, sizeof add);
    Q = 0;
  }
  long long shit(char tp, long long l = -1, long long r = -1) {
    if (tp == 'A')
      return answer(l, r);
    else {
      cnt[l] = ok(cnt[l] + 1);
      add[l] = ok(1 + add[l]);
      cnt[r + 1] = ok(cnt[r + 1] - 1);
      add[r + 1] = ok(add[r + 1] - (r - l + 2));
      L[Q] = l, R[Q] = r;
      Q++;
      return 0;
    }
  }
  old() {
    for (long long i = 0; i < maxn; i++) {
      sum_[i] = a[i] = cnt[i] = add[i] = L[i] = R[i] = 0;
    }
  }
} pos, neg;
long long a[maxn], n, dp[maxn];
inline long long reverse(long long x) { return n - x - 1; }
inline void dj() {
  for (long long i = 1; i < n; i++) dp[i] += dp[i - 1];
}
inline void add_seg(long long from, long long to, long long val) {
  dp[from] += val;
  dp[to + 1] -= val;
}
int32_t main() {
  n = input();
  for (long long i = 0; i < n; i++) a[i] = input();
  for (long long i = 0; i < n; i++) {
    long long L = i - a[i] + 1;
    if (L >= 0) {
      long long from = reverse(i), to = reverse(L);
      add_seg(from, to, a[i]);
      neg.shit('Q', from, to);
      if (L > 0) {
        from = reverse(L - 1), to = reverse(0);
        pos.shit('Q', from, to);
      }
      if (i == n - 1) continue;
      from = reverse(n - 1), to = reverse(i + 1);
      pos.shit('Q', from, to);
      add_seg(from, to, L);
    } else {
      long long from = reverse(n - 1), to = reverse(n + L);
      add_seg(from, to, a[i]);
      neg.shit('Q', from, to);
      add_seg(from, to, -(i + 1));
      from = reverse(i), to = reverse(0);
      add_seg(from, to, a[i]);
      neg.shit('Q', from, to);
      from = reverse(n + L - 1), to = reverse(i + 1);
      if (from > to) continue;
      pos.shit('Q', from, to);
    }
  }
  dj();
  pos.clear();
  neg.clear();
  long long id, res = 1e18;
  for (long long i = 0; i < n; i++) {
    long long value = pos.shit('A', n - i - 1, n - i - 1) -
                      neg.shit('A', n - i - 1, n - i - 1) + dp[n - i - 1];
    if (value < res) res = value, id = (n - i) % n;
  }
  cout << res << " " << id << endl;
}
