#include <bits/stdc++.h>
using namespace std;
template <typename T>
inline T read(T& x) {
  x = 0;
  int f = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') f |= (ch == '-'), ch = getchar();
  while (ch >= '0' && ch <= '9') x = x * 10 + ch - '0', ch = getchar();
  return x = f ? -x : x;
}
const int N = 100 + 10;
int n, ans, i, a[N];
bool check(int k) {
  int aa = 0, bb = 0;
  for (int i = 1; i <= n; ++i) {
    aa += a[i];
    bb += k - a[i];
  }
  return aa < bb;
}
int main() {
  read(n);
  for (i = 1; i <= n; ++i) read(a[i]);
  ans = *max_element(a + 1, a + 1 + n);
  for (;; ans++) {
    if (check(ans)) return printf("%d\n", ans), 0;
  }
  return 0;
}
