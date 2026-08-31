#include <bits/stdc++.h>
using namespace std;
#pragma comment(linker, "/STACK:256000000")
template <class T>
T sqr(T a) {
  return a * a;
}
int a, n, k, ot[10000];
struct zap {
  int t, l, r, d;
};
int was[10000];
zap m[100000];
void init() {
  scanf("%d%d", &n, &k);
  swap(n, k);
  for (int i = 0; i < n; ++i) {
    scanf("%d%d%d%d", &m[i].t, &m[i].l, &m[i].r, &m[i].d);
    m[i].t--;
    m[i].l--;
    m[i].r--;
  }
}
void solve() {
  int q;
  for (int I = 0; I < 3; ++I) {
    q = 0;
    for (int i = 0; i < n; ++i) {
      if (m[i].t) {
        int p = -1e9;
        for (int j = m[i].l; j <= m[i].r; ++j) p = max(ot[j], p);
        if (p == m[i].d) continue;
        q = 1;
        for (int j = m[i].l; j <= m[i].r; ++j) {
          if (!was[j]) {
            ot[j] = m[i].d;
            was[j] = 1;
            continue;
          }
          if (ot[j] < m[i].d) continue;
          ot[j] = m[i].d;
        }
      } else {
        for (int j = m[i].l; j <= m[i].r; ++j) {
          if (abs(ot[j] + m[i].d) > 1e9) {
            cout << "NO";
            return;
          }
          ot[j] += m[i].d;
        }
      }
    }
    for (int i = n - 1; i >= 0; --i) {
      if (m[i].t) {
        int p = -1e9;
        for (int j = m[i].l; j <= m[i].r; ++j) p = max(ot[j], p);
        if (p == m[i].d)
          ;
        continue;
        q = 1;
        for (int j = m[i].l; j <= m[i].r; ++j) {
          if (!was[j]) {
            ot[j] = m[i].d;
            was[j] = 1;
            continue;
          }
          if (ot[j] < m[i].d) continue;
          ot[j] = m[i].d;
        }
      } else {
        for (int j = m[i].l; j <= m[i].r; ++j) ot[j] -= m[i].d;
      }
    }
  }
  if (q) {
    printf("NO");
  } else {
    printf("YES\n");
    for (int i = 0; i < k; ++i) printf("%d ", ot[i]);
  }
}
int main() {
  init();
  solve();
  return 0;
}
