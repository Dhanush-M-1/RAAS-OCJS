#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline bool chkmin(T &a, const T &b) {
  return a > b ? a = b, 1 : 0;
}
template <typename T>
inline bool chkmax(T &a, const T &b) {
  return a < b ? a = b, 1 : 0;
}
const int INF = 0x3f3f3f3f;
template <class T>
inline bool RD(T &ret) {
  char c;
  int sgn;
  if (c = getchar(), c == EOF) return 0;
  while (c != '-' && (c < '0' || c > '9')) c = getchar();
  sgn = (c == '-') ? -1 : 1, ret = (c == '-') ? 0 : (c - '0');
  while (c = getchar(), c >= '0' && c <= '9') ret = ret * 10 + (c - '0');
  ret *= sgn;
  return 1;
}
template <class T>
inline void PT(T x) {
  if (x < 0) putchar('-'), x = -x;
  if (x > 9) PT(x / 10);
  putchar(x % 10 + '0');
}
const int N = 1e5 + 100;
long long a[N], sum[N];
long long maxn[N];
int main() {
  int n;
  long long d;
  cin >> n >> d;
  for (int i = 1; i <= n; i++) {
    scanf("%lld", &a[i]);
    sum[i] = sum[i - 1] + a[i];
  }
  maxn[n + 1] = -(1LL << 55);
  for (int i = n; i >= 1; i--) {
    maxn[i] = max(maxn[i + 1], sum[i]);
  }
  bool flag = false;
  long long add = 0, ans = 0;
  for (int i = 1; i <= n; i++) {
    sum[i] += add;
    if (sum[i] > d) flag = true;
    if (a[i] == 0) {
      if (sum[i] < 0) {
        ans++;
        if (-sum[i] > d - (maxn[i + 1] + add)) flag = true;
        add = min(-sum[i] + d + add, (add + d - (maxn[i + 1] + add)));
      }
    }
  }
  if (flag)
    puts("-1");
  else
    printf("%lld\n", ans);
}
