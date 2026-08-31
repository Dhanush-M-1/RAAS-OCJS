#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:268435456")
using namespace std;
template <typename T>
inline T abs(T a) {
  return ((a < 0) ? -a : a);
}
template <typename T>
inline T sqr(T a) {
  return a * a;
}
template <class T>
T gcd(T a, T b) {
  return a ? gcd(b % a, a) : b;
}
template <class T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
template <class T>
T sign(T a) {
  return a > 0 ? 1 : (a < 0 ? -1 : 0);
}
const int dx[] = {-1, 0, 1, 0};
const int dy[] = {0, 1, 0, -1};
const int dxK[] = {-1, -1, 0, 1, 1, 1, 0, -1};
const int dyK[] = {0, 1, 1, 1, 0, -1, -1, -1};
const int dxKn[] = {-2, -1, 1, 2, 2, 1, -1, -2};
const int dyKn[] = {1, 2, 2, 1, -1, -2, -2, -1};
const int N = int(5e5) + 9;
const int M = int(3e3) + 9;
const int LOGN = 22;
const int SQN = 350;
const int MOD = int(1e9) + 7;
const int INF = 1e9 + 100;
const long long INF64 = 2e18;
const long double PI = 3.1415926535897932384626433832795;
const long double EPS = 1e-9;
int n, k, a, b, q;
int ta[N * 4], tb[N * 4];
void upd(int v, int l, int r, int pos, int d) {
  if (l == r) {
    assert(pos == l);
    ta[v] = min(ta[v] + d, a);
    tb[v] = min(tb[v] + d, b);
    return;
  }
  int mid = (l + r) / 2;
  if (pos <= mid)
    upd(v * 2 + 1, l, mid, pos, d);
  else
    upd(v * 2 + 2, mid + 1, r, pos, d);
  ta[v] = ta[v * 2 + 1] + ta[v * 2 + 2];
  tb[v] = tb[v * 2 + 1] + tb[v * 2 + 2];
}
int geta(int v, int l, int r, int L, int R) {
  if (l == L && r == R) return ta[v];
  int mid = (l + r) / 2;
  if (R <= mid)
    return geta(v * 2 + 1, l, mid, L, R);
  else if (L > mid)
    return geta(v * 2 + 2, mid + 1, r, L, R);
  else
    return geta(v * 2 + 1, l, mid, L, mid) +
           geta(v * 2 + 2, mid + 1, r, mid + 1, R);
}
int getb(int v, int l, int r, int L, int R) {
  if (l == L && r == R) return tb[v];
  int mid = (l + r) / 2;
  if (R <= mid)
    return getb(v * 2 + 1, l, mid, L, R);
  else if (L > mid)
    return getb(v * 2 + 2, mid + 1, r, L, R);
  else
    return getb(v * 2 + 1, l, mid, L, mid) +
           getb(v * 2 + 2, mid + 1, r, mid + 1, R);
}
void solve() {
  scanf("%d %d %d %d %d", &n, &k, &a, &b, &q);
  for (int i = 0; i < (int)(q); ++i) {
    int t;
    scanf("%d", &t);
    if (t == 1) {
      int pos, d;
      scanf("%d %d", &pos, &d);
      --pos;
      upd(0, 0, n - 1, pos, d);
    } else {
      int pos;
      scanf("%d", &pos);
      --pos;
      int res = 0;
      if (pos) res += getb(0, 0, n - 1, 0, pos - 1);
      if (pos + k < n) res += geta(0, 0, n - 1, pos + k, n - 1);
      printf("%d\n", res);
    }
  }
}
int main() {
  srand(time(NULL));
  cout << setprecision(10) << fixed;
  cerr << setprecision(10) << fixed;
  solve();
  return 0;
}
