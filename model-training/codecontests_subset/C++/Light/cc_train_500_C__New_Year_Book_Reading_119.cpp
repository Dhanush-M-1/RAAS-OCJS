#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:102400000,102400000")
template <class T>
inline void gmax(T &a, T b) {
  if (b > a) a = b;
}
template <class T>
inline void gmin(T &a, T b) {
  if (b < a) a = b;
}
using namespace std;
const int N = 1000 + 10, M = 2e6 + 10, Z = 1e9 + 7, maxint = 2147483647,
          ms1 = 16843009, ms31 = 522133279, ms63 = 1061109567,
          ms127 = 2139062143;
const double PI = acos(-1.0), eps = 1e-8;
void fre() {
  freopen("/Users/luras/Desktop/in.txt", "r", stdin);
  freopen("/Users/luras/Desktop/out.txt", "w", stdout);
}
const int INF = 1e9;
int casenum, casei;
int n, m, w[N], b[N], e[N], sum;
int a[N], t;
int main() {
  while (~scanf("%d%d", &n, &m)) {
    for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
    t = 0;
    for (int i = 1; i <= m; i++) {
      scanf("%d", &b[i]);
      if (!e[b[i]]) {
        e[b[i]] = ++t;
      }
    }
    for (int i = 1; i <= m; i++) a[e[b[i]]] = b[i];
    sum = 0;
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (a[j] == b[i]) {
          for (int k = j; k > 1; k--) {
            a[k] = a[k - 1];
          }
          a[1] = b[i];
          break;
        }
        sum += w[a[j]];
      }
    }
    printf("%d\n", sum);
  }
  return 0;
}
