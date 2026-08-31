#include <bits/stdc++.h>
using namespace std;
namespace fast {
inline char nc() {
  static char buf[100000], *L = buf, *R = buf;
  return L == R && (R = (L = buf) + fread(buf, 1, 100000, stdin), L == R)
             ? EOF
             : *L++;
}
template <class orz>
inline void qread(orz &x) {
  x = 0;
  char ch = nc();
  bool f = 0;
  while (ch < '0' || ch > '9') (ch == '-') && (f = 1), ch = nc();
  while (ch >= '0' && ch <= '9') x = (x << 3) + (x << 1) + (ch ^ 48), ch = nc();
  f && (x = -x);
}
}  // namespace fast
using namespace fast;
template <class orz>
inline void read(orz &x) {
  x = 0;
  bool f = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') (ch == '-') && (f = 1), ch = getchar();
  while (ch >= '0' && ch <= '9')
    x = (x << 1) + (x << 3) + (ch ^ 48), ch = getchar();
  f && (x = -x);
}
template <class orz>
inline void out(orz x) {
  (x < 0) && (putchar('-'), x = -x);
  if (x > 9) out(x / 10);
  putchar(x % 10 + '0');
}
const double PI = acos(-1);
const double eps = 1e-8;
const int INF = 0x3f3f3f3f;
const long long mod = 998244353;
const int maxn = 2e5 + 5;
long long c[maxn], n;
long long ask(int x) {
  long long ans = 0;
  for (; x; x -= x & -x) ans += c[x];
  return ans;
}
void add(int x, long long y) {
  for (; x <= n; x += x & -x) c[x] += y;
}
long long s[maxn];
long long ans[maxn];
int erfen(long long key) {
  int left = 1;
  int right = n;
  while (left <= right) {
    int mid = (left + right) / 2;
    if (ask(mid) <= key) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return right;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &s[i]);
    add(i, i * 1LL);
  }
  for (int i = n; i >= 1; i--) {
    ans[i] = erfen(s[i]) + 1;
    add(ans[i], -1LL * ans[i]);
  }
  printf("%lld", ans[1]);
  for (int i = 2; i <= n; i++) {
    printf(" %lld", ans[i]);
  }
  putchar('\n');
}
