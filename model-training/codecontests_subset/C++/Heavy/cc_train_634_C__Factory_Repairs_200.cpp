#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-8;
inline int max(int a, int b) { return a < b ? b : a; }
inline int min(int a, int b) { return a > b ? b : a; }
inline long long max(long long a, long long b) { return a < b ? b : a; }
inline long long min(long long a, long long b) { return a > b ? b : a; }
const int mod = 1e9 + 7;
const int N = 1e6 + 10;
const long long inf = 1e18;
long long power(long long a, long long n) {
  if (n == 0) {
    return 1;
  }
  long long b = power(a, n / 2);
  b = b * b % mod;
  if (n % 2) b = b * a % mod;
  return b;
}
int add(int a, int b) { return (a + b) % mod; }
int mul(int a, int b) { return (long long)a * b % mod; }
int n, k, up1, up2, q;
long long seg[2][N], A[N];
void update(int a, int b, int nod, int pos) {
  if (pos < a || pos > b) return;
  if (a == b) {
    seg[0][nod] = min(A[a], (long long)up1);
    seg[1][nod] = min(A[a], (long long)up2);
    return;
  }
  int m = (a + b) / 2;
  update(a, m, 2 * nod, pos);
  update(m + 1, b, 2 * nod + 1, pos);
  for (int i = 0; i < 2; ++i)
    seg[i][nod] = seg[i][nod * 2] + seg[i][nod * 2 + 1];
}
pair<long long, long long> query(int a, int b, int nod, int l, int r) {
  if (r < a || l > b || l > r) return make_pair(0, 0);
  if (l <= a && b <= r) {
    return make_pair(seg[0][nod], seg[1][nod]);
  }
  int m = (a + b) / 2;
  pair<long long, long long> x = query(a, m, 2 * nod, l, r),
                             y = query(m + 1, b, 2 * nod + 1, l, r);
  return make_pair(x.first + y.first, x.second + y.second);
}
int main() {
  scanf("%d %d %d %d %d", &n, &k, &up1, &up2, &q);
  while (q--) {
    int x;
    scanf("%d", &x);
    if (x == 1) {
      int d, a;
      scanf("%d %d", &d, &a);
      d--;
      A[d] += a;
      update(0, n - 1, 1, d);
    } else {
      int p;
      scanf("%d", &p);
      p--;
      pair<long long, long long> x1 = query(0, n - 1, 1, 0, p - 1);
      pair<long long, long long> x2 = query(0, n - 1, 1, p + k, n - 1);
      printf("%lld\n", x1.second + x2.first);
    }
  }
  return 0;
}
