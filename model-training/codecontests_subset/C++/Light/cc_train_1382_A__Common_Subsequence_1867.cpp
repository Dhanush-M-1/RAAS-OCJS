#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  int t;
  cin >> t;
  while (t--) {
    bool h = 0;
    cin >> n >> m;
    int an[n], am[m];
    for (int i = 0; i < n; i++) cin >> an[i];
    for (int i = 0; i < m; i++) cin >> am[i];
    sort(an, an + n);
    sort(am, am + m);
    int i = 0, j = 0, k = 0;
    while (i < n && j < m) {
      if (an[i] == am[j]) {
        k = an[i];
        h = 1;
        break;
      }
      if (an[i] > am[j]) j++;
      if (an[i] < am[j]) i++;
    }
    if (h)
      cout << "YES" << endl << 1 << ' ' << k << endl;
    else
      cout << "NO" << endl;
  }
  return 0;
}
