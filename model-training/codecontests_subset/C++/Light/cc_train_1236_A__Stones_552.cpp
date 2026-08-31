#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int sum = 0, ff = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') ff = -1;
    ch = getchar();
  }
  while (isdigit(ch)) sum = sum * 10 + (ch ^ 48), ch = getchar();
  return sum * ff;
}
int Q, a, b, c;
int main() {
  Q = read();
  for (; Q--;) {
    a = read();
    b = read();
    c = read();
    int ans = 0;
    ans += min(b, c / 2) * 3;
    b = max(0, b - c / 2);
    ans += min(a, b / 2) * 3;
    printf("%d\n", ans);
  }
  return 0;
}
