#include <bits/stdc++.h>
using namespace std;
char buf[1 << 21], *p1 = buf, *p2 = buf, obuf[1 << 23], *O = obuf;
inline int read() {
  int x = 0, sign = 0;
  char s = getchar();
  while (!isdigit(s)) sign |= s == '-', s = getchar();
  while (isdigit(s)) x = (x << 1) + (x << 3) + (s - '0'), s = getchar();
  return sign ? -x : x;
}
void print(int x) {
  if (x > 9) print(x / 10);
  (*O++ = x % 10 + '0');
}
const int N = 3e5 + 5;
long long n, l, r;
void solve() {
  cin >> n >> l >> r;
  long long cnt = n, now = 1, tmp = 1;
  while (--cnt) {
    long long nw = tmp + cnt * 2 - 1;
    long long nl = max(l, tmp), nr = min(nw, r);
    if (nl <= nr)
      for (long long i = nl; i <= nr; i++) {
        if ((i - tmp) & 1)
          cout << now + (i - tmp + 1) / 2 << " ";
        else
          cout << now << " ";
      }
    tmp = nw + 1, now++;
  }
  if (r == tmp) cout << "1 ";
  puts("");
}
int main() {
  int testcase = 1;
  cin >> testcase;
  while (testcase--) solve();
  return 0;
}
