#include <bits/stdc++.h>
using namespace std;
const int MAXN = 5020;
const int inf = 1 << 31 - 1;
int n, m, curVal[MAXN], rez[MAXN], aux[MAXN][5];
int main() {
  cin >> n >> m;
  fill(rez, rez + n + 10, inf);
  for (int p = 1; p <= m; ++p) {
    int type, l, r, x;
    cin >> type >> l >> r >> x;
    aux[p][1] = type;
    aux[p][2] = l;
    aux[p][3] = r;
    aux[p][4] = x;
    if (type == 1) {
      for (int i = l; i <= r; ++i) curVal[i] += x;
    } else {
      for (int i = l; i <= r; ++i) {
        int temp = x - curVal[i];
        rez[i] = min(rez[i], temp);
      }
    }
  }
  for (int i = 1; i <= n; ++i)
    if (rez[i] == inf) rez[i] = 0;
  fill(curVal, curVal + n + 10, 0);
  for (int p = 1; p <= m; ++p) {
    int type, l, r, x;
    type = aux[p][1];
    l = aux[p][2];
    r = aux[p][3];
    x = aux[p][4];
    if (type == 1) {
      for (int i = l; i <= r; ++i) curVal[i] += x;
    } else {
      int maxim = -inf;
      for (int i = l; i <= r; ++i) maxim = max(maxim, rez[i] + curVal[i]);
      if (maxim != x) {
        cout << "NO";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int i = 1; i <= n; ++i) cout << rez[i] << " ";
  return 0;
}
