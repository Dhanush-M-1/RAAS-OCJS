#include <bits/stdc++.h>
using namespace std;
const int INF = 0x3f3f3f3f;
const long long LINF = 0x3f3f3f3f3f3f3f3fLL;
const double PI = acos((long double)-1.0);
const double EPS = 1e-10;
const int MOD = 1e9 + 7;
template <typename T>
void cmin(T &x, T y) {
  if (y < x) x = y;
}
template <typename T>
void cmax(T &x, T y) {
  if (y > x) x = y;
}
long long qpow(long long x, long long n, long long mod = MOD) {
  if (n < 0) return 0;
  long long res = 1;
  while (n) {
    if (n & 1) res = res * x % mod;
    x = x * x % mod;
    n >>= 1;
  }
  return res;
}
long long sq(long long x) { return x * x; }
long long read() {
  long long res = 0;
  char c = getchar();
  while (!isdigit(c)) c = getchar();
  while (isdigit(c)) {
    res = res * 10 + (c - '0');
    c = getchar();
  }
  return res;
}
const int MAXN = 200000 + 10;
int n;
int a[MAXN];
int pos[MAXN];
struct SegmentTree {
  int cnt[MAXN << 2];
  long long sum[MAXN << 2];
  int add[MAXN << 2];
  void PushUp(int o) {
    cnt[o] = cnt[(o << 1)] + cnt[(o << 1 | 1)];
    sum[o] = sum[(o << 1)] + sum[(o << 1 | 1)];
  }
  void PushDown(int o, int l, int r) {
    if (add[o]) {
      int m = (l + r) >> 1;
      sum[(o << 1)] += 1LL * cnt[(o << 1)] * add[o];
      sum[(o << 1 | 1)] += 1LL * cnt[(o << 1 | 1)] * add[o];
      add[(o << 1)] += add[o];
      add[(o << 1 | 1)] += add[o];
      add[o] = 0;
    }
  }
  void Build(int o, int l, int r) {
    add[o] = 0;
    if (l == r) {
      cnt[o] = 1;
      sum[o] = 0;
      return;
    }
    int m = (l + r) >> 1;
    Build((o << 1), l, m);
    Build((o << 1 | 1), m + 1, r);
    PushUp(o);
  }
  void Add(int o, int l, int r, int ql, int qr, int v) {
    if (ql <= l && r <= qr) {
      sum[o] += 1LL * cnt[o] * v;
      add[o] += v;
      return;
    }
    PushDown(o, l, r);
    int m = (l + r) >> 1;
    if (ql <= m) Add((o << 1), l, m, ql, qr, v);
    if (qr >= m + 1) Add((o << 1 | 1), m + 1, r, ql, qr, v);
    PushUp(o);
  }
  void SetCnt0(int o, int l, int r, int p) {
    if (l == r) {
      cnt[o] = 0;
      sum[o] = 0;
      return;
    }
    PushDown(o, l, r);
    int m = (l + r) >> 1;
    if (p <= m) SetCnt0((o << 1), l, m, p);
    if (p >= m + 1) SetCnt0((o << 1 | 1), m + 1, r, p);
    PushUp(o);
  }
  int Cnt(int o, int l, int r, int ql, int qr) {
    if (ql <= l && r <= qr) return cnt[o];
    PushDown(o, l, r);
    int m = (l + r) >> 1;
    int res = 0;
    if (ql <= m) res = res + Cnt((o << 1), l, m, ql, qr);
    if (qr >= m + 1) res = res + Cnt((o << 1 | 1), m + 1, r, ql, qr);
    return res;
  }
  long long Sum(int o, int l, int r, int ql, int qr) {
    if (ql <= l && r <= qr) return sum[o];
    PushDown(o, l, r);
    int m = (l + r) >> 1;
    long long res = 0;
    if (ql <= m) res = res + Sum((o << 1), l, m, ql, qr);
    if (qr >= m + 1) res = res + Sum((o << 1 | 1), m + 1, r, ql, qr);
    return res;
  }
  int Pos(int o, int l, int r, int k) {
    if (l == r) return l;
    PushDown(o, l, r);
    int m = (l + r) >> 1;
    int cnt0ls = (m - l + 1) - cnt[(o << 1)];
    if (cnt0ls >= k) return Pos((o << 1), l, m, k);
    return Pos((o << 1 | 1), m + 1, r, k - cnt0ls);
  }
  int Lmid() {
    int cnt0 = n - cnt[1];
    return Pos(1, 1, n, (cnt0 + 1) / 2);
  }
  int Rmid() {
    int cnt0 = n - cnt[1];
    return Pos(1, 1, n, cnt0 / 2 + 1);
  }
} st;
namespace Solver {
void InitOnce() { int t; }
void Read() {
  int res = scanf("%d", &n);
  if (res == -1) exit(0);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    pos[a[i]] = i;
  }
}
long long ans[200005];
void Solve() {
  st.Build(1, 1, n);
  long long cur = 0;
  int Lmost = n, Rmost = 1;
  for (int i = 1; i <= n; ++i) {
    int p = pos[i];
    cmin(Lmost, p);
    cmax(Rmost, p);
    cur += (n - p + 1) - st.Cnt(1, 1, n, p, n);
    if (i >= 2) {
      int Lmid = st.Lmid();
      int Rmid = st.Rmid();
      if (p < Lmid) st.Add(1, 1, n, p, Lmid, 1);
      if (p > Rmid) st.Add(1, 1, n, Rmid, p, 1);
    }
    st.SetCnt0(1, 1, n, p);
    ans[i] = cur + st.Sum(1, 1, n, Lmost, Rmost);
    printf("%lld%c", ans[i], " \n"[i == n]);
  }
}
}  // namespace Solver
int main() {
  Solver::InitOnce();
  while (true) {
    Solver::Read();
    Solver::Solve();
  }
  return 0;
}
