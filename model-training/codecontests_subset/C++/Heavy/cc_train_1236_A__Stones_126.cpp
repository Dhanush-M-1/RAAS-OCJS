#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long s = 0, w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') s = s * 10 + ch - '0', ch = getchar();
  return s * w;
}
void put1() { puts("YES"); }
void put2() { puts("NO"); }
const int manx = 2e5 + 5;
;
long long a[manx], b[manx];
int main() {
  long long q = read();
  while (q--) {
    long long a, b, c;
    a = read(), b = read(), c = read();
    long long ans = 0;
    if (c >= 2 && b >= 1) {
      if (b - c / 2 >= 0)
        ans += c / 2 * 3, b -= c / 2;
      else
        ans += b * 3, b = 0;
    }
    if (b >= 2 && a >= 1) {
      if (a - b / 2 >= 0)
        ans += b / 2 * 3;
      else
        ans += a * 3;
    }
    cout << ans << endl;
  }
  return 0;
}
