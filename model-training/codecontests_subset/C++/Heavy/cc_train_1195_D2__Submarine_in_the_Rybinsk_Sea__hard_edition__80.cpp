#include <bits/stdc++.h>
using namespace std;
template <class T>
bool ckmin(T& a, const T& b) {
  return a > b ? a = b, 1 : 0;
}
template <class T>
bool ckmax(T& a, const T& b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T>
inline void read(T& x) {
  x = 0;
  T fg = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') fg = -1;
    ch = getchar();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  x = fg * x;
}
template <typename T, typename... Args>
inline void read(T& x, Args&... args) {
  read(x), read(args...);
}
template <typename T>
inline void write(T x) {
  int len = 0;
  char c[21];
  if (x < 0) putchar('-'), x = -x;
  do {
    ++len;
    c[len] = x % 10 + '0';
  } while (x /= 10);
  for (int i = len; i >= 1; i--) putchar(c[i]);
}
template <typename T, typename... Args>
inline void write(T x, Args... args) {
  write(x), write(args...);
}
inline int add(int a, int b) {
  long long res = ((long long)a + b) % 998244353;
  if (res < 0) res += 998244353;
  return res;
}
inline int mul(int a, int b) { return (int)((long long)a * b % 998244353); }
long long a[100005];
long long cnt[100005], sumcnt[12];
int main() {
  int n;
  while (cin >> n) {
    for (int i = 1; i <= n; i++) read(a[i]);
    memset(sumcnt, 0, sizeof sumcnt);
    for (int i = 1; i <= n; i++) {
      long long x = a[i];
      cnt[i] = 0;
      while (x) {
        x /= 10;
        cnt[i]++;
      }
      sumcnt[cnt[i]]++;
    }
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      int x, tmp, cntx, xishu;
      for (int cnty = 1; cnty < 12; cnty++) {
        x = a[i];
        tmp = 0;
        cntx = 0, xishu = 1;
        while (x) {
          tmp = add(tmp, mul(xishu, x % 10));
          cntx++;
          if (cntx <= cnty) xishu = mul(xishu, 10);
          xishu = mul(xishu, 10);
          x /= 10;
        }
        x = a[i];
        cntx = 0, xishu = 1;
        while (x) {
          if (cntx < cnty) xishu = mul(xishu, 10);
          tmp = add(tmp, mul(xishu, x % 10));
          cntx++;
          xishu = mul(xishu, 10);
          x /= 10;
        }
        ans = add(ans, mul(sumcnt[cnty], tmp));
      }
    }
    cout << ans << '\n';
  }
  return 0;
}
