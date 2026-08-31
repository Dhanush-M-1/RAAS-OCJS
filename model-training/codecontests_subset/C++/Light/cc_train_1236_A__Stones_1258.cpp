#include <bits/stdc++.h>
using namespace std;
inline int read() {
  register int x = 0, c = getchar();
  while (!isdigit(c)) c = getchar();
  while (isdigit(c)) x = (x << 3) + (x << 1) + (c ^ 48), c = getchar();
  return x;
}
int main(void) {
  int T;
  T = read();
  while (T--) {
    int a, b, c, ans = 0;
    a = read(), b = read(), c = read();
    ans += min(b, c >> 1) * 3;
    b -= min(b, c >> 1);
    ans += min(b >> 1, a) * 3;
    printf("%d\n", ans);
  }
}
