#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:16777216")
using namespace std;
template <typename T>
inline bool remin(T& c, const T& n) {
  if (c > n) {
    c = n;
    return 1;
  }
  return 0;
}
template <typename T>
inline bool remax(T& c, const T& n) {
  if (c < n) {
    c = n;
    return 1;
  }
  return 0;
}
int _in;
int in() {
  scanf("%d", &_in);
  return _in;
}
const int N = 1e6 + 1;
int a[N], perm[N];
inline bool fit(int a, int b, int c) {
  return (a = perm[a]) >= 0 && (b = perm[b]) >= 0 && (c = perm[c]) >= 0 &&
         (a <= b && b <= c || c <= a && a <= b || b <= c && c <= a);
}
int main() {
  int n, m, i, from, to = 0, best = 0;
  scanf("%d%d", &n, &m);
  for ((i) = (0); (i) < (n); ++(i)) a[i] = in();
  memset(perm, -1, sizeof(perm));
  for ((i) = (0); (i) < (m); ++(i)) perm[in()] = i;
  for ((from) = (0); (from) < (n); ++(from)) {
    if (perm[a[from]] >= 0) {
      remax(to, from + 1);
      while (to < n + from && fit(a[from], a[(to - 1) % n], a[to % n])) {
        ++to;
      }
      remax(best, to - from);
    }
  }
  printf("%d\n", best);
  return 0;
}
