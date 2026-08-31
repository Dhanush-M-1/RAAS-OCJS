#include <bits/stdc++.h>
using namespace std;
inline int rand_small() { return rand() % 32768; }
inline long long rand_big() { return 32768 * rand_small() + rand_small(); }
const int N = 105;
const long long mod = 1000000007ll;
const double eps = 1e-7;
long long gcd(long long x, long long y) {
  if (x < y) swap(x, y);
  return y ? gcd(y, x % y) : x;
}
long long lcm(long long x, long long y) { return x / gcd(x, y) * y; }
long long qpow(long long x, long long y) {
  long long res = 1ll;
  while (y) {
    if (y & 1) res = res * x % mod;
    x = x * x % mod, y >>= 1;
  }
  return res;
}
int n, pos = -1, t[N], r[N];
long long a[N], b[N], b_[N];
void solve1() {
  bool has_sol = true;
  for (int i = 0; i < n; i++) {
    if (!has_sol) break;
    if (b[i] == 1ll && a[i] != a[pos]) has_sol = false;
    if (b[i] > 1ll) {
      long long now = a[i];
      has_sol = false;
      for (int j = 0; j <= (int)ceil(log(1.0 * a[pos]) / log(2.0));
           j++, now *= b[i]) {
        if (now == a[pos]) has_sol = true;
      }
    }
  }
  if (has_sol)
    printf("%lld\n", a[pos] % mod);
  else
    printf("-1\n");
}
void init2() {
  for (int i = 0; i < n; i++) {
    for (int j = 1; j <= (int)ceil(log(1.0 * b[i]) / log(2.0)); j++) {
      long long rt = (long long)floor(pow(b[i], 1.0 / j) + 0.5);
      if (fabs(pow(rt, j) - b[i]) < eps) t[i] = j, b_[i] = rt;
    }
  }
}
void solve2(int x) {
  long long m = rand_big() + 1ll, num1 = a[0] % m, num2 = a[x] % m, num = -1;
  int posi, posj,
      T = (int)ceil(log(1.0 * a[0]) + log(1.0 * a[x]) +
                    log(1.0 * b[0]) * log(1.0 * b[x]))
          << 2;
  for (int i = 0; i < T; i++, num1 = num1 * b[0] % m) {
    num2 = a[x] % m;
    for (int j = 0; j < T; j++, num2 = num2 * b[x] % m) {
      if (num1 == num2) {
        posi = i, posj = j;
        num = num1;
      }
    }
  }
  bool has_sol = (num >= 0ll);
  for (int i = 0; i < n; i++) {
    long long tmp = a[i] % m;
    if (!has_sol) break;
    has_sol = false;
    for (int j = 0; j <= (int)ceil(T * log(1.0 * b[0]) / log(2.0));
         j++, tmp = tmp * b[i] % m) {
      if (tmp == num) {
        has_sol = true;
        break;
      }
    }
  }
  if (has_sol) {
    num = a[0] % mod;
    for (int i = 0; i < posi; i++) num = num * b[0] % mod;
    printf("%lld\n", num);
  } else
    printf("-1\n");
}
int main() {
  srand(clock());
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%lld%lld", &a[i], &b[i]);
    if (b[i] == 1ll) pos = i;
  }
  if (~pos)
    solve1();
  else {
    init2();
    bool flag = false;
    for (int i = 1; i < n; i++) {
      if (b_[i] != b_[0]) {
        flag = true, solve2(i);
        break;
      }
    }
    if (!flag) {
      for (int i = 0; i < n; i++) {
        r[i] = 0;
        while (a[i] % b_[i] == 0ll) r[i]++, a[i] /= b_[i];
      }
      bool has_sol = true;
      long long L = t[0], ans = r[0];
      for (int i = 1; i < n; i++) {
        if (a[i] != a[0]) has_sol = false;
      }
      for (int i = 1; i < n; i++) {
        if (!has_sol) break;
        has_sol = false;
        for (int j = 0; j < t[i]; j++) {
          if ((ans + L * j) % t[i] == r[i] % t[i]) {
            has_sol = true, ans += L * j;
            break;
          }
        }
        L = lcm(L, t[i]);
      }
      if (!has_sol)
        printf("-1\n");
      else {
        int mx = r[0];
        for (int i = 1; i < n; i++) mx = max(mx, r[i]);
        while (ans < mx) ans += L;
        printf("%lld\n", a[0] * qpow(b_[0], ans) % mod);
      }
    }
  }
  return 0;
}
