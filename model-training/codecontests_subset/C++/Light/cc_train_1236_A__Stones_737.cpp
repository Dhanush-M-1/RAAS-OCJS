#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
inline int read() {
  int x = 0, w = 0;
  char ch = 0;
  while (!isdigit(ch)) w |= ch == '-', ch = getchar();
  while (isdigit(ch)) x = (x << 1) + (x << 3) + (ch ^ 48), ch = getchar();
  return w ? -x : x;
}
int t;
int main() {
  t = read();
  while (t--) {
    int a = read(), b = read(), c = read(), ans = 0;
    int tmp = c / 2;
    ans += min(b, tmp) * 2 + min(b, tmp);
    b -= min(b, tmp);
    tmp = b / 2;
    ans += min(a, tmp) * 2 + min(a, tmp);
    cout << ans << endl;
  }
  return 0;
}
