#include <bits/stdc++.h>
using namespace std;
inline long long gcd(long long a, long long b) {
  while (b != 0) {
    long long c = a % b;
    a = b;
    b = c;
  }
  return a < 0 ? -a : a;
}
inline long long lowbit(long long x) { return x & (-x); }
const double PI = 3.14159265358979323846;
const int inf = 0x3f3f3f3f;
const long long INF = 0x3f3f3f3f3f3f3f3f;
const long long mod = 998244353;
inline long long rd() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
const double eps = 1e-6;
const int M = 1e6 + 10;
const int N = 1e6 + 10;
struct MM {
  int id, val;
  bool friend operator<(const MM& m1, const MM& m2) { return m1.val < m2.val; }
};
MM a[N], b[N], c[N], d[N];
int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
int n, m, k;
vector<int> ans;
MM pp[N];
long long f(int x) {
  ans.clear();
  long long sum = 0;
  if (x > x3 || x + x1 < k || x + x2 < k || 2 * k - x > m) return INF;
  for (int i = 1; i <= x; i++) {
    sum += c[i].val;
    ans.push_back(c[i].id);
  }
  for (int i = 1; i <= k - x; i++) {
    sum += a[i].val;
    ans.push_back(a[i].id);
  }
  for (int i = 1; i <= k - x; i++) {
    sum += b[i].val;
    ans.push_back(b[i].id);
  }
  int cnt = 0;
  for (int i = max(k - x + 1, 1); i <= x1; i++) {
    pp[++cnt] = a[i];
  }
  for (int i = max(k - x + 1, 1); i <= x2; i++) {
    pp[++cnt] = b[i];
  }
  for (int i = x + 1; i <= x3; i++) {
    pp[++cnt] = c[i];
  }
  for (int i = 1; i <= x4; i++) {
    pp[++cnt] = d[i];
  }
  int res = m - (2 * k - x);
  sort(pp + 1, pp + 1 + cnt);
  for (int i = 1; i <= res; i++) {
    ans.push_back(pp[i].id);
    sum += pp[i].val;
  }
  return sum;
}
int main() {
  n = rd(), m = rd(), k = rd();
  for (int i = 1; i <= n; i++) {
    int t = rd(), aa = rd(), bb = rd();
    if (aa && bb)
      c[++x3] = {i, t};
    else if (aa)
      a[++x1] = {i, t};
    else if (bb)
      b[++x2] = {i, t};
    else
      d[++x4] = {i, t};
  }
  sort(a + 1, a + 1 + x1);
  sort(b + 1, b + 1 + x2);
  sort(c + 1, c + 1 + x3);
  sort(d + 1, d + 1 + x4);
  if (x3 + x1 < k || x3 + x2 < k) {
    cout << -1 << endl;
    return 0;
  }
  int l = 0, r = x3;
  int an = l;
  while (l + 10 < r) {
    int lmid = l + (r - l) / 3, rmid = r - (r - l) / 3;
    if (f(lmid) < f(rmid)) {
      an = lmid;
      r = rmid - 1;
    } else {
      an = rmid;
      l = lmid + 1;
    }
  }
  for (int i = l; i <= r; i++) {
    if (f(i) < f(an)) an = i;
  }
  long long aa = f(an);
  if (aa == INF) {
    cout << -1 << endl;
    return 0;
  }
  cout << aa << endl;
  for (auto& x : ans) {
    printf("%d ", x);
  }
  cout << endl;
}
