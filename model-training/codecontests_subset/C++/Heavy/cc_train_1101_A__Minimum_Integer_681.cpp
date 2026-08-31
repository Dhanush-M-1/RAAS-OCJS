#include <bits/stdc++.h>
using namespace std;
inline char gc() { return getchar(); }
template <class T>
int read(T &ans) {
  ans = 0;
  char ch = gc();
  T f = 1;
  while (!isdigit(ch)) {
    if (ch == EOF) return -1;
    if (ch == '-') f = -1;
    ch = gc();
  }
  while (isdigit(ch)) ans = ans * 10 + ch - '0', ch = gc();
  ans *= f;
  return 1;
}
template <class T1, class T2>
int read(T1 &a, T2 &b) {
  return read(a) != EOF && read(b) != EOF ? 2 : EOF;
}
template <class T1, class T2, class T3>
int read(T1 &a, T2 &b, T3 &c) {
  return read(a, b) != EOF && read(c) != EOF ? 3 : EOF;
}
const int Maxn = 1100000;
const int inf = 0x3f3f3f3f;
signed main() {
  long long q, l, r, d;
  read(q);
  while (q--) {
    read(l, r, d);
    if (l > d)
      printf("%I64d\n", d);
    else
      printf("%I64d\n", d * (r / d + 1));
  }
  return 0;
}
