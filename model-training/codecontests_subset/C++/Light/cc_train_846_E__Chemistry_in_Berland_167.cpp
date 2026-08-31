#include <bits/stdc++.h>
const int maxn = 1e5 + 10;
const int N = 2e5 + 10;
using namespace std;
long long gcd(long long p, long long q) { return q == 0 ? p : gcd(q, p % q); }
long long qmul(long long p, long long q) {
  long long f = 0;
  while (q) {
    if (q & 1) f = f + p;
    if (f > 5e18) return -1;
    p = p + p;
    q >>= 1;
  }
  return f;
}
long long qpow(long long p, long long q, long long mo) {
  long long f = 1;
  while (q) {
    if (q & 1) f = f * p % mo;
    p = p * p % mo;
    q >>= 1;
  }
  return f;
}
int n, m, t, du[maxn], x[maxn], k[maxn];
long long a[maxn], b[maxn];
int main() {
  int i, j;
  scanf("%d", &n);
  for (i = 1; i <= (int)n; i++) scanf("%lld", &b[i]);
  for (i = 1; i <= (int)n; i++) scanf("%lld", &a[i]);
  for (i = 2; i <= (int)n; i++) scanf("%d%d", &x[i], &k[i]), du[x[i]]++;
  queue<int> pq;
  for (i = 1; i <= (int)n; i++)
    if (du[i] == 0) pq.push(i);
  while (!pq.empty()) {
    int p = pq.front();
    pq.pop();
    if (p == 1) return 0 * puts(a[p] <= b[p] ? "YES" : "NO");
    if (a[p] <= b[p]) {
      b[x[p]] += b[p] - a[p];
    } else {
      if (b[x[p]] - 1.0 * (a[p] - b[p]) * k[p] < -(1LL << 60))
        b[x[p]] = -(1LL << 60);
      else
        b[x[p]] -= (a[p] - b[p]) * k[p], a[p] = b[p];
      if (b[x[p]] < -(1LL << 60)) b[x[p]] = -(1LL << 60);
    }
    if (--du[x[p]] == 0) pq.push(x[p]);
  }
  return 0;
}
