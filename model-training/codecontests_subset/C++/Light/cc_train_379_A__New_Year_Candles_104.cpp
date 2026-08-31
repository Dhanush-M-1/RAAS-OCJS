#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T& x) {
  bool f = false;
  char ch = getchar();
  x = 0;
  while (ch < 48) f = (ch == '-'), ch = getchar();
  while (47 < ch) x = (x << 3) + (x << 1) + ch - 48, ch = getchar();
  if (f) x = -x;
}
int a, b, ans;
int main() {
  read(a), read(b);
  while (a) {
    if (a >= b)
      ans += a / b * b, a = a - a / b * b + a / b;
    else
      ans += a, a = 0;
  }
  printf("%d\n", ans);
  return 0;
}
