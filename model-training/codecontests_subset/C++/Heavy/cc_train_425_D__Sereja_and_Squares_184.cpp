#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void read(T& x) {
  bool fu = 0;
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  if (c == '-') fu = 1, c = getchar();
  for (x = 0; c > 32; c = getchar()) x = x * 10 + c - '0';
  if (fu) x = -x;
};
template <class T>
inline void read(T& x, T& y) {
  read(x);
  read(y);
}
template <class T>
inline void read(T& x, T& y, T& z) {
  read(x);
  read(y);
  read(z);
}
inline char getc() {
  char c;
  for (c = getchar(); c <= 32; c = getchar())
    ;
  return c;
}
const int N = 100010;
const int D = 500;
const int de = 100010;
int n, i, j, k, l, p, k1, k2, d, g, x, y, z;
long long ans;
pair<int, int> a[N], b[N], c[N];
bool cmp(pair<int, int> a, pair<int, int> b) {
  return make_pair(a.second, a.first) < make_pair(b.second, b.first);
}
bool vis[N * 4];
bool find(int x, int y) {
  int p = lower_bound(a + 1, a + 1 + n, make_pair(x, y)) - a;
  return (a[p] == make_pair(x, y));
}
int main() {
  read(n);
  for (i = 1; i <= n; i++) read(a[i].first, a[i].second);
  sort(a + 1, a + 1 + n);
  for (i = 1; i <= n; i = j + 1) {
    for (j = i; j <= n && a[j].first == a[i].first; j++)
      ;
    j--;
    if (j - i + 1 > D) vis[a[j].first + de] = 1;
  }
  for (i = 1; i <= n; i = j + 1) {
    for (j = i; j <= n && a[j].first == a[i].first; j++)
      ;
    j--;
    if (j - i + 1 <= D) {
      for (k1 = i; k1 <= j; k1++)
        for (k2 = k1 + 1; k2 <= j; k2++) {
          d = a[k2].second - a[k1].second;
          if (vis[a[k1].first - d + de])
            if (find(a[k1].first - d, a[k1].second) &&
                find(a[k2].first - d, a[k2].second))
              ans++;
          if (find(a[k1].first + d, a[k1].second) &&
              find(a[k2].first + d, a[k2].second))
            ans++;
        }
    } else {
      for (k = i; k <= j; k++) b[++g] = a[k], c[g] = a[k];
    }
  }
  sort(b + 1, b + 1 + g, cmp);
  for (i = 1; i <= g; i = j + 1) {
    for (j = i; j <= g && b[j].second == b[i].second; j++)
      ;
    j--;
    for (k1 = i; k1 <= j; k1++)
      for (k2 = k1 + 1; k2 <= j; k2++) {
        d = b[k2].first - b[k1].first;
        if (find(b[k1].first, b[k1].second + d) &&
            find(b[k2].first, b[k2].second + d))
          ans++;
      }
  }
  cout << ans << endl;
  scanf("\n");
  return 0;
}
