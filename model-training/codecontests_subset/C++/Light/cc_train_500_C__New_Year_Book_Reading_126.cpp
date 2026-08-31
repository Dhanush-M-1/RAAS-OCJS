#include <bits/stdc++.h>
using namespace std;
int n, m, l;
long long res;
int a[1000009], b[1000009], w[1000009];
int dd[1000009];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &w[i]);
  for (int i = 1; i <= m; i++) scanf("%d", &b[i]);
  l = n;
  for (int i = 1; i <= m; i++)
    if (!dd[b[i]]) {
      dd[b[i]] = 1;
      a[l] = b[i];
      l--;
    }
  for (int i = 1; i <= m; i++) {
    bool ok = false;
    for (int i = 1; i <= n; i++) dd[i] = 0;
    for (int j = i - 1; j >= 1; j--)
      if (!dd[b[j]]) {
        dd[b[j]] = 1;
        if (b[j] == b[i]) {
          ok = true;
          break;
        }
        res += w[b[j]];
      }
    if (!ok)
      for (int j = n; j >= 1; j--)
        if (!dd[a[j]]) {
          dd[a[j]] = 1;
          if (a[j] == b[i]) {
            ok = true;
            break;
          }
          res += w[a[j]];
        }
  }
  cout << res << endl;
  return 0;
}
