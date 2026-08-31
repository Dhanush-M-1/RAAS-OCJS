#include <bits/stdc++.h>
using namespace std;
template <class T>
T _abs(T n) {
  return (n < 0 ? -n : n);
}
template <class T>
T _max(T a, T b) {
  return (!(a < b) ? a : b);
}
template <class T>
T _min(T a, T b) {
  return (a < b ? a : b);
}
template <class T>
T sq(T x) {
  return x * x;
}
const double EPS = 1e-9;
const int INF = 0x7f7f7f7f;
long long mx[5100], add[5100];
int t[5100], st[5100], fn[5100], d[5100];
int main() {
  int i, n, m, j;
  cin >> n >> m;
  for (j = 1; j <= n; j++) mx[j] = 1000000000;
  for (i = 0; i < m; i++) {
    scanf("%d %d %d %d", &t[i], &st[i], &fn[i], &d[i]);
    if (t[i] == 1) {
      for (j = st[i]; j <= fn[i]; j++) add[j] += d[i];
    } else {
      for (j = st[i]; j <= fn[i]; j++) {
        mx[j] = min(mx[j], d[i] - add[j]);
      }
    }
  }
  bool fl = 1;
  long long mn;
  memcpy(add, mx, sizeof(mx));
  for (j = 1; j <= n; j++)
    if (_abs(mx[j]) > 1000000000) fl = 0;
  for (i = 0; i < m && fl; i++) {
    if (t[i] == 1) {
      for (j = st[i]; j <= fn[i]; j++) add[j] += d[i];
    } else {
      mn = -100000000000000ll;
      for (j = st[i]; j <= fn[i]; j++) mn = max(add[j], mn);
      if (mn != d[i]) fl = 0;
    }
  }
  if (fl) {
    cout << "YES\n" << mx[1];
    for (j = 2; j <= n; j++) cout << ' ' << mx[j];
    puts("");
  } else
    puts("NO");
  return 0;
}
