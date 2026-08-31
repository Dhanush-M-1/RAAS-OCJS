#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  cin >> n >> m;
  int tab[n], pow[n], t[m], a[m], b[m], w[m];
  for (int i = 0; i < n; i++) {
    tab[i] = 100000000;
    pow[i] = 0;
  }
  for (int i = 0; i < m; i++) {
    cin >> t[i] >> a[i] >> b[i] >> w[i];
    if (t[i] == 1) {
      for (int j = a[i] - 1; j < b[i]; j++) pow[j] += w[i];
    } else {
      for (int j = a[i] - 1; j < b[i]; j++) tab[j] = min(tab[j], w[i] - pow[j]);
    }
  }
  int maks;
  for (int i = 0; i < m; i++) {
    if (t[i] == 1) {
      for (int j = a[i] - 1; j < b[i]; j++) tab[j] += w[i];
    } else {
      maks = -1000000000;
      for (int j = a[i] - 1; j < b[i]; j++) maks = max(maks, tab[j]);
      if (maks != w[i]) {
        cout << "NO\n";
        return 0;
      }
    }
  }
  cout << "YES\n";
  for (int j = 0; j < n; j++) cout << tab[j] - pow[j] << " ";
  cout << "\n";
  return 0;
}
