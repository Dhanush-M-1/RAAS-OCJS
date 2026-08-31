#include <bits/stdc++.h>
using namespace std;
int main() {
  int prmin, mn, mx, n, hh, x, prmini, mni = -1, mxi;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> hh;
    prmin = 1000000001;
    mn = 1000000001;
    mx = -1;
    for (int j = 0; j < hh; j++) {
      cin >> x;
      if (x < mn) {
        prmin = mn;
        mn = x;
        prmini = mni;
        mni = j;
      } else if (x < prmin) {
        prmin = x;
        prmini = j;
      } else if (x > mx) {
        mx = x;
        mxi = j;
      }
    }
    if (mn + prmin > mx) {
      cout << -1 << endl;
    } else {
      cout << mni + 1 << " " << prmini + 1 << " " << mxi + 1 << endl;
    }
  }
  return 0;
}
