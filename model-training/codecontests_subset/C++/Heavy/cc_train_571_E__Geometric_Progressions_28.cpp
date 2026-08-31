#include <bits/stdc++.h>
using namespace std;
namespace zyt {
template <typename T>
inline bool read(T &x) {
  char c;
  bool f = false;
  x = 0;
  do c = getchar();
  while (c != EOF && c != '-' && !isdigit(c));
  if (c == EOF) return false;
  if (c == '-') f = true, c = getchar();
  do x = x * 10 + c - '0', c = getchar();
  while (isdigit(c));
  if (f) x = -x;
  return true;
}
template <typename T>
inline void write(T x) {
  static char buf[20];
  char *pos = buf;
  if (x < 0) putchar('-'), x = -x;
  do *pos++ = x % 10 + '0';
  while (x /= 10);
  while (pos > buf) putchar(*--pos);
}
const int N = 1e2 + 10, M = 2000, P = 1e9 + 7;
int a[N], b[N], n, pcnt, prime[M];
int power(int a, long long b) {
  int ans = 1;
  while (b) {
    if (b & 1) ans = (long long)ans * a % P;
    a = (long long)a * a % P;
    b >>= 1;
  }
  return ans;
}
struct prgrs {
  long long a[M], b[M];
  prgrs() {
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
  }
} arr[N];
void get(int n) {
  for (int i = 0; i < pcnt; i++)
    while (n % prime[i] == 0) n /= prime[i];
  for (int i = 2; i * i <= n; i++)
    if (n % i == 0) {
      prime[pcnt++] = i;
      while (n % i == 0) n /= i;
    }
  if (n > 1) prime[pcnt++] = n;
}
void get(int n, long long *const a) {
  for (int i = 0; i < pcnt; i++) {
    a[i] = 0;
    while (n % prime[i] == 0) ++a[i], n /= prime[i];
  }
}
long long exgcd(const long long a, const long long b, long long &x,
                long long &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  long long xx, yy, tmp = exgcd(b, a % b, xx, yy);
  x = yy;
  y = xx - a / b * yy;
  return tmp;
}
long long gcd(const long long a, const long long b) {
  return b ? gcd(b, a % b) : a;
}
void FAIL() {
  puts("-1");
  exit(0);
}
prgrs merge(const prgrs &A, const prgrs &B) {
  prgrs ans;
  int cnt = 0;
  long long a, b, c, x, y;
  for (int i = 0; i < pcnt; i++) {
    if (A.b[i] || B.b[i]) {
      if (cnt == 0)
        a = A.b[i], b = -B.b[i], c = B.a[i] - A.a[i], ++cnt;
      else if (cnt == 1) {
        long long aa = A.b[i], bb = -B.b[i], cc = B.a[i] - A.a[i],
                  g = gcd(a, aa);
        if (g < 0) g = -g;
        if (!a) swap(a, aa), swap(b, bb), swap(c, cc);
        if (a * bb == b * aa) {
          if (a * cc != c * aa) FAIL();
        } else {
          if (aa) {
            int t1 = a / g, t2 = aa / g;
            a *= t2, b *= t2, c *= t2;
            aa *= t1, bb *= t1, cc *= t1;
            bb -= b, cc -= c;
          }
          if (cc % bb) FAIL();
          y = cc / bb;
          if ((c - b * y) % a) FAIL();
          x = (c - b * y) / a;
          if (x < 0 || y < 0) FAIL();
          ++cnt;
        }
      } else if (A.b[i] * x + A.a[i] != B.b[i] * y + B.a[i])
        FAIL();
    } else if (A.a[i] != B.a[i])
      FAIL();
  }
  if (cnt == 0)
    ans = A;
  else if (cnt == 1) {
    long long g = gcd(a, b);
    if (c % g) FAIL();
    a /= g, b /= g, c /= g;
    exgcd(a, b, x, y);
    x *= c, y *= c;
    if (g < 0) a = -a, b = -b, c = -c, g = -g;
    if (a && b) {
      if (x < 0 || y < 0) {
        long long t = LLONG_MIN;
        if (x < 0) t = max(t, (-x - b - 1) / -b);
        if (y < 0) t = max(t, (-y + a - 1) / a);
        x -= t * b, y += t * a;
      }
      long long t = min(x / -b, y / a);
      x += t * b, y -= t * a;
    }
    if (x < 0 || y < 0) FAIL();
    if (a * x + b * y != c) fprintf(stderr, "gg");
    for (int i = 0; i < pcnt; i++)
      ans.a[i] = A.a[i] + A.b[i] * x,
      ans.b[i] = (A.b[i] || B.b[i] ? a * B.b[i] : 0);
  } else
    for (int i = 0; i < pcnt; i++) ans.a[i] = A.a[i] + A.b[i] * x, ans.b[i] = 0;
  return ans;
}
int work() {
  read(n);
  for (int i = 1; i <= n; i++) {
    read(a[i]), read(b[i]);
    get(a[i]), get(b[i]);
  }
  sort(prime, prime + pcnt);
  for (int i = 1; i <= n; i++) get(a[i], arr[i].a), get(b[i], arr[i].b);
  for (int i = 2; i <= n; i++) arr[1] = merge(arr[1], arr[i]);
  int ans = 1;
  for (int i = 0; i < pcnt; i++)
    ans = (long long)ans * power(prime[i], arr[1].a[i]) % P;
  write(ans);
  return 0;
}
}  // namespace zyt
int main() { return zyt::work(); }
