#include <bits/stdc++.h>
using namespace std;
template <class T>
T sqr(const T &a) {
  return a * a;
}
int a, b, x, ans;
int main() {
  scanf("%d%d", &a, &b);
  while (1) {
    ans += a;
    x += a;
    if (x / b == 0) break;
    a = x / b;
    x -= (x / b) * b;
  }
  printf("%d\n", ans);
}
