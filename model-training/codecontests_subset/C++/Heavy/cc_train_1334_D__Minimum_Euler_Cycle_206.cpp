#include <bits/stdc++.h>
using namespace std;
template <typename T>
void read(T &x) {
  x = 0;
  bool f = 0;
  char c = getchar();
  for (; !isdigit(c); c = getchar())
    if (c == '-') f = 1;
  for (; isdigit(c); c = getchar()) x = x * 10 + (c ^ 48);
  if (f) x = -x;
}
template <typename T>
inline void Mx(T &x, T y) {
  x < y && (x = y);
}
template <typename T>
inline void Mn(T &x, T y) {
  x > y && (x = y);
}
long long T, n, l, r;
int main() {
  read(T);
  while (T--) {
    read(n), read(l), read(r);
    if (n == 2) {
    }
    long long sum = 0, pre = 0;
    for (int i = 1; i < n; i++) {
      sum += (n - i) * 2;
      if (l < sum) {
        long long t = l - pre;
        long long x = (t & 1) ? i : (t / 2) + i, y = (t / 2) + i;
        while (l < sum && l <= r) {
          printf("%lld ", x);
          x == i ? y++, x = y : x = i;
          l++;
        }
      }
      if (l == sum && l <= r) printf("%lld ", n), l++;
      pre = sum;
      if (l > r) break;
    }
    if (l <= r) printf("1");
    puts("");
  }
  return 0;
}
